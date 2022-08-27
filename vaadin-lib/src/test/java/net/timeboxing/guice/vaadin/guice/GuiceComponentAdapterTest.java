package net.timeboxing.guice.vaadin.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.vaadin.flow.component.Component;
import net.timeboxing.guice.vaadin.guice.impl.DefaultUser;
import net.timeboxing.guice.vaadin.guice.impl.User;
import net.timeboxing.guice.vaadin.guice.impl.UserEditComponent;
import net.timeboxing.guice.vaadin.guice.impl.UserViewComponent;
import net.timeboxing.vaadin.component.ComponentAdapter;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.VaadinComponent;
import net.timeboxing.vaadin.guice.VaadinComponentModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class GuiceComponentAdapterTest {

    @Test
    public void canAdapt() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new VaadinComponentModule("net.timeboxing"));
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, ComponentPurpose.VIEW);

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(UserViewComponent.class, component.orElseThrow().getClass());
    }

    @Test
    public void differentPurposeSameClass() {
        User user = new DefaultUser(5);
        Injector injector = Guice.createInjector(new VaadinComponentModule("net.timeboxing"));
        Optional<VaadinComponent> component = ComponentAdapter.adapt(user, ComponentPurpose.EDIT);

        Assertions.assertTrue(component.isPresent());
        Assertions.assertEquals(UserEditComponent.class, component.orElseThrow().getClass());
    }
}
