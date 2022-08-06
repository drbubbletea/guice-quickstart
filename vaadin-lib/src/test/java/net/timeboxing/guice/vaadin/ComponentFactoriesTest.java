package net.timeboxing.guice.vaadin;

import com.vaadin.flow.component.Component;
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
    public void precedenceMatchingClass() {
        Assertions.fail();
    }

    @Test
    public void precedenceMatchingInterface() {
        Assertions.fail();
    }


    @Test
    public void precedenceMatchingAbstractClass() {
        Assertions.fail();
    }
}
