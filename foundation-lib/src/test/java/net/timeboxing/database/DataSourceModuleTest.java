package net.timeboxing.database;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Test;

public class DataSourceModuleTest {

    @Test
    public void canGetInMemoryJdbiAndQuery() {
        Injector injector = Guice.createInjector(new TestDataSourceModule());
        TestDAL testDAL = injector.getInstance(TestDAL.class);
        Assert.assertEquals(1, testDAL.test());
    }
}
