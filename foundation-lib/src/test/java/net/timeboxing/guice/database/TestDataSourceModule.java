package net.timeboxing.guice.database;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import net.timeboxing.guice.database.impl.DBTestDAL;

public class TestDataSourceModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new InMemoryDataSourceModule(InMemoryDS.class));
        bind(TestDAL.class).to(DBTestDAL.class).in(Scopes.SINGLETON);
    }
}
