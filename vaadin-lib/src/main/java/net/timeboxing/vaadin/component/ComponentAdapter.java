package net.timeboxing.vaadin.component;

import com.vaadin.flow.component.Component;
import net.timeboxing.vaadin.guice.VaadinComponentModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;
import java.util.Optional;

/**
 * Static implementation of the adapter pattern for our Vaadin components.
 */
public class ComponentAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(ComponentAdapter.class);

    private static Provider<Map<ComponentCreatorKey, ComponentCreator>> creatorsProvider;

    private ComponentAdapter() {
        /* NOOP */
    }

    @Inject
    public static void initialize(Provider<Map<ComponentCreatorKey, ComponentCreator>> provider) {
        creatorsProvider = provider;
    }

    /**
     * Find a suitable Component based on the source object and the stated purpose.
     */
    public static Optional<Component> adapt(Object source, ComponentPurpose purpose) {
        if (creatorsProvider == null) {
            throw new ComponentAdapterException("Component factory not initialized");
        }
        ComponentCreatorKey key = new ComponentCreatorKey(source.getClass(), purpose);
        // find creator for class
        LOG.debug("Looking for creator for {}", key);
        ComponentCreator creator = creatorsProvider.get().getOrDefault(key, null);
        Component result = null;
        if (creator != null) {
            LOG.info("Creating...");
            result = creator.create(source, purpose);
        }
        if (result == null) {
            // find creator for interface
            Class<?>[] interfaces = source.getClass().getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                key = new ComponentCreatorKey(interfaces[i], purpose);
                LOG.debug("Looking for creator for {}", key);
                creator = creatorsProvider.get().getOrDefault(key, null);
                if (creator != null) {
                    LOG.info("Creating...");
                    result = creator.create(source, purpose);
                    break;
                }
            }
        }
        if (result == null) {
            return Optional.empty();
        }
        return Optional.of(result);
    }

}
