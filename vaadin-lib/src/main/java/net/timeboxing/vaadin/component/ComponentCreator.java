package net.timeboxing.vaadin.component;

import com.google.inject.Injector;
import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import java.lang.reflect.Constructor;

public class ComponentCreator {

    private Injector injector;
    private final Class<?> componentClass;

    private final Constructor<?> constructor;

    public ComponentCreator(Class<?> componentClass) {
        this.componentClass = componentClass;
        this.constructor = getConstructor();
    }

    @Inject
    public void initialize(Injector injector) {
        this.injector = injector;
    }

    public Component create(Object source, ComponentPurpose purpose) {
        try {
            Object[] parameters = new Object[constructor.getParameterCount()];
            parameters[0] = source;
            Object instance = constructor.newInstance(parameters);
            injector.injectMembers(instance);
            return (Component) instance;
        } catch (Exception e) {
            throw new ComponentAdapterException("Failed to create component instance", e);
        }
    }

    private Constructor<?> getConstructor() {
        for (Constructor<?> constructor: componentClass.getConstructors()) {
            if (constructor.isAnnotationPresent(Inject.class)) {
                return constructor;
            }
        }
        throw new ComponentAdapterException(String.format("No constructor annotated with javax.inject.Inject found in %s", componentClass.getName()));
    }
}
