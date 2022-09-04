package net.timeboxing.guice.vaadin.guice.component;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.timeboxing.guice.vaadin.guice.component.impl.*;
import net.timeboxing.vaadin.component.ComponentAdapter;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.VaadinComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class GuiceComponentAdapterTest {

    @Test
    void canAdapt() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, ComponentPurpose.VIEW);

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(UserViewComponent.class, component.orElseThrow().getClass());
    }

    @Test
    void adaptContainsPurpose() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, ComponentPurpose.VIEW);

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(ComponentPurpose.VIEW, ((UserViewComponent) component.orElseThrow()).purpose());
    }


    @Test
    void adaptContainsInjectedMembers() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, ComponentPurpose.VIEW);

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals("12345", ((UserViewComponent) component.orElseThrow()).testService().callMe());
    }

    @Test
    void differentPurposeSameClass() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, ComponentPurpose.EDIT);

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(UserEditComponent.class, component.orElseThrow().getClass());
    }

    @Test
    void customPurposeTestExample() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, "TEST", "EXAMPLE");

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(CustomUserTestExampleComponent.class, component.orElseThrow().getClass());
    }
    @Test
    void customPurposeTestFoo() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, "TEST", "FOO");

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(CustomUserTestFooComponent.class, component.orElseThrow().getClass());
    }
    @Test
    void customPurposeAnotherBar() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, "ANOTHER", "BAR");

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(CustomUserAnotherBarComponent.class, component.orElseThrow().getClass());
        CustomUserAnotherBarComponent casted = ((CustomUserAnotherBarComponent) component.orElseThrow());
        Assertions.assertEquals("BAR", casted.purpose());
    }

    @Test
    void customEnumFoo() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, "ANOTHER", "CUSTOM_FOO");

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(CustomEnumUserFooComponent.class, component.orElseThrow().getClass());
        CustomEnumUserFooComponent casted = ((CustomEnumUserFooComponent) component.orElseThrow());
        Assertions.assertEquals(CustomPurpose.CUSTOM_FOO, casted.purpose());
    }

    @Test
    void customEnumBar() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new TestVaadinComponentModule());
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, CustomPurpose.class, "CUSTOM_BAR");

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(CustomEnumUserBarComponent.class, component.orElseThrow().getClass());
        CustomEnumUserBarComponent casted = ((CustomEnumUserBarComponent) component.orElseThrow());
        Assertions.assertEquals(CustomPurpose.CUSTOM_BAR, casted.purpose());
    }
}
