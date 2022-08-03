package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import java.util.Optional;

public interface ComponentFactories {
    Optional<Component> get(Object source, ComponentPurpose purpose);
}
