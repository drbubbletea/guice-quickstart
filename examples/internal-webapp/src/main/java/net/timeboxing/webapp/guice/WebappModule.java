package net.timeboxing.webapp.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import net.timeboxing.vaadin.guice.VaadinComponentModule;
import net.timeboxing.webapp.GreetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebappModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(WebappModule.class);

    @Override
    protected void configure() {
        super.configure();

        LOG.debug("Initializing");
        install(new VaadinComponentModule("net.timeboxing"));
        bind(GreetService.class).in(Scopes.SINGLETON);
    }
}
