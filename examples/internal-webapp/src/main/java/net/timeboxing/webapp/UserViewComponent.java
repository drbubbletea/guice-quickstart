package net.timeboxing.webapp;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import net.timeboxing.vaadin.component.ComponentFor;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.Source;
import net.timeboxing.vaadin.component.VaadinComponent;

import javax.inject.Inject;

@ComponentFor(forClass = User.class, purpose = ComponentPurpose.VIEW)
public class UserViewComponent implements VaadinComponent {

    private final User user;
    private final ComponentPurpose purpose;

    private final VerticalLayout layout;

    @Inject
    public UserViewComponent(@Source User user, ComponentPurpose purpose) {
        this.user = user;
        this.purpose = purpose;
        this.layout = new VerticalLayout();
        layout.add(new Label("Testing"));
    }
    @Override
    public Component get() {
        return layout;
    }
}
