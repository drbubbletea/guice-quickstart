package net.timeboxing.vaadin.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scope;
import net.timeboxing.vaadin.event.VaadinComponentEventBus;

public class VaadinComponentEventModule extends AbstractModule {

    private final Scope scope;

    /**
     *
     * @param scope
     */
    public VaadinComponentEventModule(Scope scope) {
        this.scope = scope;
    }

    @Override
    protected void configure() {
        super.configure();
        bind(VaadinComponentEventBus.class).in(scope);
    }
}
