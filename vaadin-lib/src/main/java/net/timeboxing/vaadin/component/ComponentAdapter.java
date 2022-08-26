package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Optional;

/**
 * Static implementation of the adapter pattern for our Vaadin components.
 */
public class ComponentAdapter {

    private static Provider<ComponentFactory<?>> componentFactoryProvider;

    private ComponentAdapter() {
        /* NOOP */
    }

    @Inject
    public static void initialize(Provider<ComponentFactory<?>> provider) {
        componentFactoryProvider = provider;
    }

    /**
     * Find a suitable Component based on the source object and the stated purpose.
     */
    public static Optional<Component> adapt(Object source, ComponentPurpose purpose) {
        if (componentFactoryProvider == null) {
            throw new ComponentAdapterException("Component factory not initialized");
        }
        return componentFactoryProvider.get().create(source, purpose);
    }

}
