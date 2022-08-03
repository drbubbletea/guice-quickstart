package net.timeboxing.guice.vaadin;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HtmlComponent;
import net.timeboxing.vaadin.component.ComponentAdapter;
import net.timeboxing.vaadin.component.ComponentFactories;
import net.timeboxing.vaadin.component.ComponentPurpose;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Provider;
import java.util.Optional;
public class ComponentAdapterTest {

    @Test
    public void adaptCallsProvider() {
        Provider<ComponentFactories> componentFactoriesProvider = TestComponentFactories::new;
        ComponentAdapter.initialize(componentFactoriesProvider);

        Optional<Component> result = ComponentAdapter.adapt(new Object(), ComponentPurpose.VIEW);

        Assertions.assertTrue(result.orElseThrow() instanceof HtmlComponent);
    }

    private class TestComponentFactories implements ComponentFactories {

        @Override
        public Optional<Component> get(Object source, ComponentPurpose purpose) {
            return Optional.of(new HtmlComponent("test"));
        }
    }

}
