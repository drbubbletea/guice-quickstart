package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import java.util.Map;
import java.util.Optional;

public class DefaultComponentFactory<T> implements ComponentFactory<T> {

    private final Map<Class<?>, ComponentCreator> creators;

    public DefaultComponentFactory(Map<Class<?>, ComponentCreator> creators) {
        this.creators = creators;
    }

    @Override
    public Optional<Component> create(Object source, ComponentPurpose purpose) {
        return null;
    }
}
