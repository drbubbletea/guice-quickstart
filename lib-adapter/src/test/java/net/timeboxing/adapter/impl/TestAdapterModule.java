package net.timeboxing.adapter.impl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import net.timeboxing.adapter.guice.AdapterModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAdapterModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(TestAdapterModule.class);

    private final String[] packagesToTest;

    public TestAdapterModule(String... packagesToTest) {
        this.packagesToTest = packagesToTest;
    }
    @Override
    protected void configure() {
        install(new AdapterModule(packagesToTest));
        install(new FactoryModuleBuilder().implement(User.class, DefaultUser.class).build(DomainFactory.class));
    }
}
