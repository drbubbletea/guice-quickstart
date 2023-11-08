package net.timeboxing.adapter.guice;

import com.google.inject.AbstractModule;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class AdapterModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(AdapterModule.class);

    private final String[] packagesToScan;

    public AdapterModule(String... packagesToScan) {
        this.packagesToScan = packagesToScan;
    }
    @Override
    protected void configure() {
        LOG.info("Initializing");
        Reflections reflections = new Reflections(new ConfigurationBuilder().forPackages(packagesToScan));
    }
}
