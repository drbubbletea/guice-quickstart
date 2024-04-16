package net.timeboxing.webapp.guice;

import com.google.inject.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebappModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(WebappModule.class);

    @Override
    protected void configure() {
        super.configure();
        LOG.info("Initializing");
    }
}
