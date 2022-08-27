package net.timeboxing.vaadin.component;

import com.google.inject.Injector;
import com.vaadin.flow.component.Component;

public class DefaultComponentCreator implements ComponentCreator {

    private final Injector injector;

    public DefaultComponentCreator(Injector injector) {
        this.injector = injector;
    }
    @Override
    public Component create(Class<?> clazz, ComponentPurpose purpose) {
        try {
            // get constructor
            // create instance from constructor
            // inject
            // return
            return (Component) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
