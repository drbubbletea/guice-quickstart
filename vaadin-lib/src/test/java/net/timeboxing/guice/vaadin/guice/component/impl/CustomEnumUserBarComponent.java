package net.timeboxing.guice.vaadin.guice.component.impl;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import net.timeboxing.vaadin.component.ComponentFor;
import net.timeboxing.vaadin.component.Purpose;
import net.timeboxing.vaadin.component.VaadinComponent;

import javax.inject.Inject;

@ComponentFor(forClass = User.class, purposeEnum = CustomPurpose.class, purposeValue = "CUSTOM_BAR")
public class CustomEnumUserBarComponent implements VaadinComponent {

    private final CustomPurpose purpose;
    @Inject
    public CustomEnumUserBarComponent(@Purpose CustomPurpose purpose) {
        this.purpose = purpose;
    }
    private final Component component = new Label("testing");
    @Override
    public Component get() {
        return component;
    }

    public CustomPurpose purpose() {
        return purpose;
    }
}
