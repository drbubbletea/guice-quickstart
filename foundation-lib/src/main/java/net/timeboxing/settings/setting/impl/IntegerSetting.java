package net.timeboxing.settings.setting.impl;

import net.timeboxing.settings.setting.Setting;

public class IntegerSetting implements Setting<Integer> {

    private final Integer value;

    public IntegerSetting(Integer value) {
        this.value = value;
    }

    @Override
    public Integer get() {
        return null;
    }
}
