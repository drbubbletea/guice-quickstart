package net.timeboxing.vaadin.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import net.timeboxing.vaadin.component.*;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class VaadinComponentModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(VaadinComponentModule.class);

    private final String packageToScan;

    public VaadinComponentModule(String packageToScan) {
        this.packageToScan = packageToScan;
    }

    @Override
    protected void configure() {
        requestStaticInjection(ComponentAdapter.class);
        bind(ComponentFactories.class).to(DefaultComponentFactories.class).in(Scopes.SINGLETON);

        Multibinder<ComponentFactory<?>> factoryBinder = Multibinder.newSetBinder(binder(), new TypeLiteral<ComponentFactory<?>>() {
        });

        Reflections reflections = new Reflections(packageToScan);
        Set<Class<?>> components = reflections.getTypesAnnotatedWith(ComponentFor.class);
        for (Class<?> component : components) {
            LOG.debug("Found class {}", component.getCanonicalName());
        }
    }
}
