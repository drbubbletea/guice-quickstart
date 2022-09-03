package net.timeboxing.vaadin.component;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

public class CustomVaadinComponentCreator {

    private Injector injector;
    private final Class<?> componentClass;

    private final Constructor<?> constructor;
    private final Object[] parameterTypes;
    private final Type[] genericTypes;
    private final Annotation[][] parameterAnnotations;

    public CustomVaadinComponentCreator(Class<?> componentClass) {
        this.componentClass = componentClass;
        this.constructor = getConstructor();
        this.parameterTypes = constructor.getParameterTypes();
        this.genericTypes = constructor.getGenericParameterTypes();
        this.parameterAnnotations = constructor.getParameterAnnotations();
    }

    @Inject
    public void initialize(Injector injector) {
        this.injector = injector;
    }

    public VaadinComponent create(Object source, Object... purpose) {
        if (purpose.length != 2 || !String.class.isAssignableFrom(purpose[0].getClass()) || !String.class.isAssignableFrom(purpose[1].getClass())) {
            throw new ComponentAdapterException("Only custom purpose type and value is supported in this VaadinComponentCreator");
        }
        try {
            Object[] parameters = getParameters((String) purpose[0], (String) purpose[1], source);
            Object instance = constructor.newInstance(parameters);
            // handle any injection outside of the constructor
            injector.injectMembers(instance);
            return (VaadinComponent) instance;
        } catch (Exception e) {
            throw new ComponentAdapterException("Failed to create component instance", e);
        }
    }

    private Object[] getParameters(String purpose, String value, Object source) {
        Object[] parameters = new Object[constructor.getParameterCount()];
        for (int i = 0; i < parameters.length; i++) {
            boolean found = false;
            for (Annotation annotation: parameterAnnotations[i]) {
                if (Source.class == annotation.annotationType()) {
                    parameters[i] = source;
                    found = true;
                    break;
                } else if (Purpose.class == annotation.annotationType()) {
                    parameters[i] = value;
                    found = true;
                    break;
                }
            }
            if (!found) {
                parameters[i] = injector.getInstance(Key.get(TypeLiteral.get(genericTypes[i])));
            }
        }
        return parameters;
    }

    private Constructor<?> getConstructor() {
        for (Constructor<?> ctor: componentClass.getConstructors()) {
            if (ctor.isAnnotationPresent(Inject.class)) {
                return ctor;
            }
        }
        throw new ComponentAdapterException(String.format("No constructor annotated with javax.inject.Inject found in %s", componentClass.getName()));
    }
}
