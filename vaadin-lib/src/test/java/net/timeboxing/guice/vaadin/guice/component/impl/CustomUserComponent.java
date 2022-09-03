package net.timeboxing.guice.vaadin.guice.component.impl;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import net.timeboxing.vaadin.component.ComponentFor;
import net.timeboxing.vaadin.component.VaadinComponent;

import javax.inject.Inject;

@ComponentFor(forClass = User.class, purposeType = "TEST", purposeValue = "EXAMPLE")
public class CustomUserComponent implements VaadinComponent {

    @Inject
    public CustomUserComponent() {
        /* NOOP */
    }
    private final Component component = new Label("testing");
    @Override
    public Component get() {
        return component;
    }
}
