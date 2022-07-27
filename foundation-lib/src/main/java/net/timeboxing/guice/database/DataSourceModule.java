package net.timeboxing.guice.database;

import com.google.inject.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;

public class DataSourceModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(DataSourceModule.class);

    private final Class<? extends Annotation> dataSource;

    public DataSourceModule(Class<? extends Annotation> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure() {
        super.configure();
    }
}
