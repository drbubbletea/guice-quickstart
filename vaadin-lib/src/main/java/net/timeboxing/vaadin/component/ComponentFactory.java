package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import java.util.Optional;

public interface ComponentFactory<T> {

    Optional<Component> create(Object source, ComponentPurpose purpose);
}
