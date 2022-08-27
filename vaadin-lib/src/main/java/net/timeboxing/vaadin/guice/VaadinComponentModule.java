package net.timeboxing.vaadin.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;
import net.timeboxing.vaadin.component.*;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import java.util.HashMap;
import java.util.Map;
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

        Reflections reflections = new Reflections(packageToScan);
        Set<Class<?>> components = reflections.getTypesAnnotatedWith(ComponentFor.class);
        for (Class<?> component : components) {
            LOG.debug("Found class {}", component.getCanonicalName());
            ComponentFor annotation = component.getAnnotation(ComponentFor.class);
            Class<?> source = annotation.source();
            ComponentPurpose purpose = annotation.purpose();
            Map<Class<?>, ComponentCreator> creators = new HashMap<>();
//            ComponentCreator creator = new DefaultComponentCreator();
//            creators.put(source, creator);
        }
    }
}
