package net.timeboxing.guice.vaadin.guice.impl;

import com.vaadin.flow.component.Component;
import net.timeboxing.vaadin.component.ComponentFor;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.Source;
import net.timeboxing.vaadin.component.VaadinComponent;
import com.vaadin.flow.component.html.Label;

import javax.inject.Inject;

@ComponentFor(forClass = User.class, purpose = ComponentPurpose.VIEW)
public class UserViewComponent implements VaadinComponent {

    private final User user;
    private final Component component;
    private final ComponentPurpose purpose;

    @Inject
    public UserViewComponent(@Source User user, ComponentPurpose purpose) {
        this.user = user;
        this.purpose = purpose;
        this.component = new Label("test");
    }

    public User user() {
        return user;
    }

    @Override
    public Component get() {
        return component;
    }

    public ComponentPurpose purpose() {
        return purpose;
    }
}
