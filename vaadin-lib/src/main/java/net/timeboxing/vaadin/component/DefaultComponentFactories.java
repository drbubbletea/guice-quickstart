package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import java.util.Optional;

public class DefaultComponentFactories implements ComponentFactories {


    @Inject
    public DefaultComponentFactories() {

    }

    public Optional<Component> get(Object source, ComponentPurpose purpose) {
        return null;
    }
}
