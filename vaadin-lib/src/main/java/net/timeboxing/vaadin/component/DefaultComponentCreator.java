package net.timeboxing.vaadin.component;

import com.google.inject.Injector;
import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import java.lang.reflect.Constructor;

public class DefaultComponentCreator implements ComponentCreator {

    private final Injector injector;
    private final Class<?> componentClass;

    private final Constructor<?> constructor;

    public DefaultComponentCreator(Class<?> componentClass, Injector injector) {
        this.componentClass = componentClass;
        this.injector = injector;
        this.constructor = getConstructor(componentClass);
    }
    @Override
    public Component create(Class<?> clazz, ComponentPurpose purpose) {
        try {
            // create instance from constructor
            Object instance = constructor.newInstance();
            // inject
            // return
            return (Component) instance;
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
