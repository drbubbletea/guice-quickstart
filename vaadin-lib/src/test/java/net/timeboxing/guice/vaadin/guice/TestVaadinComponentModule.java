package net.timeboxing.guice.vaadin.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import net.timeboxing.guice.vaadin.guice.impl.DefaultTestService;
import net.timeboxing.guice.vaadin.guice.impl.TestService;
import net.timeboxing.vaadin.guice.VaadinComponentModule;

public class TestVaadinComponentModule extends AbstractModule {

    @Override
    protected void configure() {
        super.configure();
        install(new VaadinComponentModule("net.timeboxing"));
        bind(TestService.class).to(DefaultTestService.class).in(Scopes.SINGLETON);
    }
}
