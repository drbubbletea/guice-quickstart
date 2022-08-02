package net.timeboxing.vaadin.guice;

import com.google.inject.AbstractModule;
import net.timeboxing.vaadin.ComponentAdapter;

public class VaadinComponentModule extends AbstractModule {

    @Override
    protected void configure() {
        requestStaticInjection(ComponentAdapter.class);
    }
}
