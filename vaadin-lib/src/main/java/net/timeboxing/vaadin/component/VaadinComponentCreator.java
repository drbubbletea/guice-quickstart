package net.timeboxing.vaadin.component;

import com.google.inject.Injector;
import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;

public class VaadinComponentCreator {

    private Injector injector;
    private final Class<?> componentClass;

    private final Constructor<?> constructor;

    public VaadinComponentCreator(Class<?> componentClass) {
        this.componentClass = componentClass;
        this.constructor = getConstructor();
    }

    @Inject
    public void initialize(Injector injector) {
        this.injector = injector;
    }

    public VaadinComponent create(Object source, ComponentPurpose purpose) {
        try {
            Object[] parameters = getParameters(purpose, source);
            Object instance = constructor.newInstance(parameters);
            injector.injectMembers(instance);
            return (VaadinComponent) instance;
        } catch (Exception e) {
            throw new ComponentAdapterException("Failed to create component instance", e);
        }
    }

    private Object[] getParameters(ComponentPurpose purpose, Object source) {
        Object[] parameters = new Object[constructor.getParameterCount()];
        Object[] parameterTypes = constructor.getParameterTypes();
        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
        // TODO: source if annotation present
        // TODO: purpose if a parameter
        for (int i = 0; i < parameters.length; i++) {
            if (ComponentPurpose.class == parameterTypes[i]) {
                parameters[i] = purpose;
                continue;
            }
            for (Annotation annotation: parameterAnnotations[i]) {
                if (Source.class == annotation.annotationType()) {
                    parameters[i] = source;
                    continue;
                }
            }
        }
        return parameters;
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