package net.timeboxing.guice.vaadin;

import com.vaadin.flow.component.Component;
import net.timeboxing.vaadin.component.ComponentCreator;
import net.timeboxing.vaadin.component.ComponentFactory;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.DefaultComponentFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ComponentFactoryTest {

    @Test
    public void notSupportsUnrelatedClass() {
        ComponentCreator creator = new TestComponentCreator<>(UserComponent.class);
        ComponentFactory<User> componentFactory = new DefaultComponentFactory<>(User.class, creator);

        Assertions.assertFalse(componentFactory.supports(Group.class));
    }

    @Test
    public void supportsExactClass() {
        ComponentCreator creator = new TestComponentCreator<>(UserComponent.class);
        ComponentFactory<User> componentFactory = new DefaultComponentFactory<>(User.class, creator);

        Assertions.assertTrue(componentFactory.supports(User.class));
    }

    @Test
    public void canCreate() {
        Assertions.fail();
    }

    private interface Actor {

    }

    private class User implements Actor {

    }

    private class Group {

    }

    @Tag("test")
    private class UserComponent extends Component {

    }

    private class TestComponentCreator<T> implements ComponentCreator {

        private final Class<T> source;

        public TestComponentCreator(Class<T> source) {
            this.source = source;
        }

        @Override
        public Component create(Class<?> clazz, ComponentPurpose purpose) {
            throw new RuntimeException("Not supported");
        }
    }
}
