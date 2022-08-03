package net.timeboxing.vaadin.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import net.timeboxing.vaadin.component.ComponentAdapter;
import net.timeboxing.vaadin.component.ComponentFactories;
import net.timeboxing.vaadin.component.DefaultComponentFactories;

public class VaadinComponentModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(ComponentAdapter.class);
        bind(ComponentFactories.class).to(DefaultComponentFactories.class).in(Scopes.SINGLETON);
    }
}
