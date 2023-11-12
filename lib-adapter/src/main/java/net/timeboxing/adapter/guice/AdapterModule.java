package net.timeboxing.adapter.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.MapBinder;
import net.timeboxing.adapter.AdaptedFrom;
import net.timeboxing.adapter.AdaptedFromFactoriesAdapter;
import net.timeboxing.adapter.AdaptedFromFactory;
import net.timeboxing.adapter.Adapter;
import net.timeboxing.adapter.DefaultAdaptedFromCreator;
import net.timeboxing.adapter.DefaultAdaptedFromCreatorKey;
import net.timeboxing.adapter.DefaultAdaptedFromFactory;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;


public class AdapterModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(AdapterModule.class);

    private final String[] packagesToScan;
    private final TypeLiteral<DefaultAdaptedFromCreatorKey> creatorKeyTypeLiteral = TypeLiteral.get(DefaultAdaptedFromCreatorKey.class);
    private final TypeLiteral<DefaultAdaptedFromCreator> creatorTypeLiteral = TypeLiteral.get(DefaultAdaptedFromCreator.class);


    public AdapterModule(String... packagesToScan) {
        this.packagesToScan = packagesToScan;
    }
    @Override
    protected void configure() {
        LOG.info("Initializing");
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages(packagesToScan));

        Set<Class<?>> adaptedFromClasses = reflections.getTypesAnnotatedWith(AdaptedFrom.class);
        MapBinder<DefaultAdaptedFromCreatorKey, DefaultAdaptedFromCreator> defaultCreators = MapBinder.newMapBinder(binder(), creatorKeyTypeLiteral, creatorTypeLiteral);

        for (Class<?> adaptedFrom: adaptedFromClasses) {
            LOG.debug("Found class {}", adaptedFrom.getCanonicalName());
            AdaptedFrom annotation = adaptedFrom.getAnnotation(AdaptedFrom.class);
            DefaultAdaptedFromCreatorKey key = new DefaultAdaptedFromCreatorKey(annotation.from(), annotation.purposeEnum(), annotation.purposeValue());
            DefaultAdaptedFromCreator creator = new DefaultAdaptedFromCreator(adaptedFrom, annotation.purposeEnum(), annotation.purposeValue());
            defaultCreators.addBinding(key).toInstance(creator);
            LOG.debug("Bound creator: {}", key);
        }
        bind(Adapter.class).to(AdaptedFromFactoriesAdapter.class).in(Scopes.SINGLETON);
        bind(AdaptedFromFactory.class).to(DefaultAdaptedFromFactory.class).in(Scopes.SINGLETON);
    }
}
