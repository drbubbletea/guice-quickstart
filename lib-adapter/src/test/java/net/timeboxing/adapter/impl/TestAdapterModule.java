package net.timeboxing.adapter.impl;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import net.timeboxing.adapter.guice.AdapterModule;
import net.timeboxing.adapter.guice.GuiceAOPAdaptModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAdapterModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(TestAdapterModule.class);

    @Override
    protected void configure() {
        install(new AdapterModule("net.timeboxing.adapter"));
        install(new GuiceAOPAdaptModule());
        install(new FactoryModuleBuilder().implement(User.class, DefaultUser.class).build(DomainFactory.class));
    }
}
