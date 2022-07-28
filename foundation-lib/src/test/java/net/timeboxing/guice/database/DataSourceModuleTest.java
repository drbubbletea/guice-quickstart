package net.timeboxing.guice.database;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;

public class DataSourceModuleTest {

    @Test
    public void canGetJdbiForDataSource() {
        Injector injector = Guice.createInjector(new InMemoryDataSourceModule(InMemoryDS.class));
        Assert.fail();
    }
}
