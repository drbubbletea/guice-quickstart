package net.timeboxing.settings.setting.impl;

import net.timeboxing.settings.setting.Setting;

public class StringSetting implements Setting<String> {
    private final String value;

    public StringSetting(String value) {
        this.value = value;
    }

    @Override
    public String get() {
        return value;
    }
}
