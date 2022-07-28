package net.timeboxing.guice.database;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import javax.sql.DataSource;

public class JdbiProvider implements Provider<Jdbi> {

    private final Logger LOG = LoggerFactory.getLogger(JdbiProvider.class);
    private final Provider<DataSource> dataSourceProvider;

    public JdbiProvider(Provider<DataSource> dataSourceProvider) {
        this.dataSourceProvider = dataSourceProvider;
    }

    @Override
    public Jdbi get() {
        LOG.debug("Getting JDBI instance");
        return Jdbi.create(dataSourceProvider);
    }
}
