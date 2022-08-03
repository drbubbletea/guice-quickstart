package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import java.util.Optional;
import java.util.Set;

public class DefaultComponentFactories implements ComponentFactories {

    private final Set<ComponentFactory<?>> componentFactories;

    @Inject
    public DefaultComponentFactories(Set<ComponentFactory<?>> componentFactories) {
        this.componentFactories = componentFactories;
    }

    public Optional<Component> get(Object source, ComponentPurpose purpose) {

        return Optional.empty();
    }
}
