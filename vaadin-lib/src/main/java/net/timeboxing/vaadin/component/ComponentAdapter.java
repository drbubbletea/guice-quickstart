package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Optional;

/**
 * Static implementation of the adapter pattern for our Vaadin widgets.
 */
public class ComponentAdapter {

    private static Provider<ComponentFactories> componentFactoriesProvider;

    private ComponentAdapter() {
        /* NOOP */
    }

    @Inject
    static void initialize(Provider<ComponentFactories> provider) {
        componentFactoriesProvider = provider;
    }

    /**
     * Find a suitable Component based on the source object and the stated purpose.
     */
    public static Optional<Component> adapt(Object source, ComponentPurpose purpose) {
        if (componentFactoriesProvider == null) {
            throw new ComponentAdapterException("Component factories provider not initialized");
        }
        return componentFactoriesProvider.get().get(source, purpose);
    }

}
