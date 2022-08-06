package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

public interface ComponentCreator {

    Component create(Class<?> clazz, ComponentPurpose purpose);
}
