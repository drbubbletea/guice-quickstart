package net.timeboxing.settings.setting.impl;

import net.timeboxing.settings.setting.Setting;

public class IntegerSetting extends AbstractSetting<Integer> {

    public IntegerSetting(Integer value, String name) {
        super(value, name);
    }


    @Override
    protected String serialize() {
        return value.toString();
    }

    @Override
    protected Integer deserialize(String value) {
        return Integer.valueOf(value);
    }
}
