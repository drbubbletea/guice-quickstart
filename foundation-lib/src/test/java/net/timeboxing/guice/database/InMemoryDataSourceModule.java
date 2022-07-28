package net.timeboxing.guice.database;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import org.h2.jdbcx.JdbcDataSource;
import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Provider;
import javax.sql.DataSource;
import java.lang.annotation.Annotation;

/**
 * Module for any testing features relating to a database.
 */
public class InMemoryDataSourceModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryDataSourceModule.class);

    private final Class<? extends Annotation> dataSourceAnnotation;

    public InMemoryDataSourceModule(Class<? extends Annotation> dataSource) {
        this.dataSourceAnnotation = dataSource;
    }

    @Override
    protected void configure() {
        super.configure();

        Provider<DataSource> dataSourceProvider = new DataSourceProvider();
        bind(DataSource.class).annotatedWith(dataSourceAnnotation).toProvider(dataSourceProvider);
        bind(Jdbi.class).annotatedWith(dataSourceAnnotation).toProvider(new JdbiProvider(dataSourceProvider)).in(Scopes.SINGLETON);
    }

    private class DataSourceProvider implements Provider<DataSource> {

        @Override
        public DataSource get() {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;");
            dataSource.setUser("sa");
            dataSource.setPassword("sa");
            return dataSource;
        }
    }
}
