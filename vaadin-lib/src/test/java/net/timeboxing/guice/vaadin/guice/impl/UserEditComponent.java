package net.timeboxing.guice.vaadin.guice.impl;

import com.vaadin.flow.component.Component;
import net.timeboxing.vaadin.component.ComponentFor;
import net.timeboxing.vaadin.component.ComponentPurpose;
import net.timeboxing.vaadin.component.Source;

import javax.inject.Inject;

@ComponentFor(forClass = User.class, purpose = ComponentPurpose.EDIT)
public class UserEditComponent extends Component {

    private final User user;

    @Inject
    public UserEditComponent(@Source User user) {
        this.user = user;
    }

    public User user() {
        return user;
    }
}
