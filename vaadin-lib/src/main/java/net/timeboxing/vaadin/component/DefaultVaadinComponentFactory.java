package net.timeboxing.vaadin.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.Map;
import java.util.Optional;

public class DefaultVaadinComponentFactory implements VaadinComponentFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ComponentAdapter.class);

    private Provider<Map<DefaultComponentCreatorKey, VaadinComponentCreator>> creatorsProvider;

    @Inject
    public DefaultVaadinComponentFactory(Provider<Map<DefaultComponentCreatorKey, VaadinComponentCreator>> provider) {
        this.creatorsProvider = provider;
    }

    @Override
    public Optional<VaadinComponent> get(Object source, Object... purpose) {
        DefaultComponentCreatorKey key = new DefaultComponentCreatorKey(source.getClass(), (ComponentPurpose) purpose[0]);

        LOG.debug("Looking for creator for {}", key);
        VaadinComponentCreator creator = creatorsProvider.get().getOrDefault(key, null);
        VaadinComponent result = null;
        if (creator != null) {
            result = creator.create(source, (ComponentPurpose) purpose[0]);
        }
        if (result == null) {
            // find creator for interface
            Class<?>[] interfaces = source.getClass().getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                key = new DefaultComponentCreatorKey(interfaces[i], (ComponentPurpose) purpose[0]);
                LOG.debug("Looking for creator for {}", key);
                creator = creatorsProvider.get().getOrDefault(key, null);
                if (creator != null) {
                    result = creator.create(source, (ComponentPurpose) purpose[0]);
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
