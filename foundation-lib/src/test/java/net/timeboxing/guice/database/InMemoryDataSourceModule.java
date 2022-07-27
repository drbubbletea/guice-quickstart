package net.timeboxing.guice.database;

import com.google.inject.AbstractModule;
import org.h2.jdbcx.JdbcDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.annotation.Annotation;

public class InMemoryDataSourceModule extends AbstractModule {

    private static final Logger LOG = LoggerFactory.getLogger(InMemoryDataSourceModule.class);

    private final Class<? extends Annotation> dataSource;

    public InMemoryDataSourceModule(Class<? extends Annotation> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure() {
        super.configure();

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;");
        ds.setUser("sa");
        ds.setPassword("sa");

        bind(DataSource.class).annotatedWith(dataSource).toProvider(...);
    }
}
