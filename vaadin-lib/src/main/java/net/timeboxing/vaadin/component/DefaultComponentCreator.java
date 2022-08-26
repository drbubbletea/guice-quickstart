package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

public class DefaultComponentCreator implements ComponentCreator {


    @Override
    public Component create(Class<?> clazz, ComponentPurpose purpose) {
        try {
            return (Component) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
