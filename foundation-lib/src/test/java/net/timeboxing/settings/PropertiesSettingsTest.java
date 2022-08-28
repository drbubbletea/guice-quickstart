package net.timeboxing.settings;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import net.timeboxing.settings.guice.PropertiesSettingsModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PropertiesSettingsTest {

    @Test
    public void canGetProperties() {
        Injector injector = Guice.createInjector(new PropertiesSettingsModule("src/test/resources/example.properties"));
        Settings settings = injector.getInstance(Settings.class);
        Assertions.assertEquals("test", settings.getString("database.name").orElseThrow());
        Assertions.assertEquals("tester", settings.getString("database.username").orElseThrow());
        Assertions.assertEquals("secretpassword", settings.getString("database.password").orElseThrow());
        Assertions.assertEquals(Integer.valueOf(20), settings.getInteger("database.connections").orElseThrow());
    }
}
