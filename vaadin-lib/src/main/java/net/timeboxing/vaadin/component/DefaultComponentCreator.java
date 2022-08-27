package net.timeboxing.vaadin.component;

import com.google.inject.Injector;
import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import java.lang.reflect.Constructor;

public class DefaultComponentCreator implements ComponentCreator {

    private final Injector injector;
    private final Class<?> componentClass;

    public DefaultComponentCreator(Class<?> componentClass, Injector injector) {
        this.componentClass = componentClass;
        this.injector = injector;
    }
    @Override
    public Component create(Class<?> clazz, ComponentPurpose purpose) {
        try {
            // get constructor (TODO: do once per class in constructor)
            Constructor<?> ctr = getConstructor(componentClass);

            // create instance from constructor
            // inject
            // return
            return (Component) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Constructor<?> getConstructor(Class<?> clazz) {
        for (Constructor<?> constructor: clazz.getConstructors()) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                return constructor;
            }
        }
        throw new ComponentAdapterException(String.format("No constructor annotated with javax.inject.Inject found in %s", clazz.getName()));
    }
}
