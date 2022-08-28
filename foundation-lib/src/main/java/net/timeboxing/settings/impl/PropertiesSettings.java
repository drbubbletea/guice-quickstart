package net.timeboxing.settings.impl;

import com.google.common.collect.Maps;
import net.timeboxing.settings.SettingsException;
import net.timeboxing.settings.setting.Setting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public final class PropertiesSettings extends AbstractFileSettings {

    private final String path;
    public PropertiesSettings(String path) {
        this.path = path;
        Properties properties = new Properties();
        File file = new File(path);
        try (InputStream input = new FileInputStream(file)) {
            properties.load(input);
            load(Maps.fromProperties(properties));
        } catch (IOException e) {
            throw new SettingsException("Failed to load properties file", e);
        }
    }
}
