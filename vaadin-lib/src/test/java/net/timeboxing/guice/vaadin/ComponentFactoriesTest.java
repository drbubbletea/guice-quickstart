package net.timeboxing.guice.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import net.timeboxing.vaadin.component.ComponentFactories;
import net.timeboxing.vaadin.component.ComponentFactory;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.DefaultComponentFactories;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class ComponentFactoriesTest {

    @Test
    public void noFactoriesReturnsEmpty() {
        Set<ComponentFactory<?>> factories = new HashSet<>();
        ComponentFactories componentFactories = new DefaultComponentFactories(factories);

        Optional<Component> result = componentFactories.get(new Object(), ComponentPurpose.VIEW);

        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void canMatchClass() {
        Set<ComponentFactory<?>> factories = new HashSet<>();
        ComponentFactory<User> userComponentFactory = new TestComponentFactory<>(User.class, ComponentPurpose.VIEW);
        factories.add(userComponentFactory);

        ComponentFactories componentFactories = new DefaultComponentFactories(factories);

        Optional<Component> result = componentFactories.get(new User(), ComponentPurpose.VIEW);

        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    public void notMatchClass() {
        Set<ComponentFactory<?>> factories = new HashSet<>();
        ComponentFactory<User> userComponentFactory = new TestUnmatchedComponentFactory<>(User.class, ComponentPurpose.VIEW);
        factories.add(userComponentFactory);

        ComponentFactories componentFactories = new DefaultComponentFactories(factories);

        Optional<Component> result = componentFactories.get(new User(), ComponentPurpose.VIEW);

        Assertions.assertTrue(result.isEmpty());
    }

    private class User {

    }

    private class TestComponentFactory<T> implements ComponentFactory<T> {

        private final Class<T> clazz;
        private final ComponentPurpose purpose;

        public TestComponentFactory(Class<T> clazz, ComponentPurpose purpose) {
            this.clazz = clazz;
            this.purpose = purpose;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            return this.clazz.isAssignableFrom(clazz);
        }

        @Override
        public Object create() {
            try {
                return new TestComponent();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    private class TestUnmatchedComponentFactory<T> implements ComponentFactory<T> {

        private final Class<T> clazz;
        private final ComponentPurpose purpose;

        public TestUnmatchedComponentFactory(Class<T> clazz, ComponentPurpose purpose) {
            this.clazz = clazz;
            this.purpose = purpose;
        }

        @Override
        public boolean supports(Class<?> clazz) {
            return false;
        }

        @Override
        public Object create() {
            throw new RuntimeException();
        }
    }

    @Tag("test")
    private class TestComponent extends Component {

    }
}
