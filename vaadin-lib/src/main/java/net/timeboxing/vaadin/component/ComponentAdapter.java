package net.timeboxing.vaadin.component;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Optional;

/**
 * Static implementation of the adapter pattern for our Vaadin components.
 */
public class ComponentAdapter {


    private static Provider<DefaultVaadinComponentFactory> factoryProvider;

    private ComponentAdapter() {
        /* NOOP */
    }

    @Inject
    public static void initialize(Provider<DefaultVaadinComponentFactory> provider) {
        factoryProvider = provider;
    }

    /**
     * Find a suitable Component based on the ComponentPurpose value provided.
     *
     * TODO: clean up this method
     */
    public static Optional<VaadinComponent> adapt(Object source, ComponentPurpose purpose) {
        if (factoryProvider == null) {
            throw new ComponentAdapterException("Component factory not initialized");
        }
        return factoryProvider.get().get(source, purpose);
    }

}
