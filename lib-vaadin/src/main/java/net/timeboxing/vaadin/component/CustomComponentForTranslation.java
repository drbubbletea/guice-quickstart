package net.timeboxing.vaadin.component;

import net.timeboxing.adapter.CustomAdaptedFromTranslation;

public class CustomComponentForTranslation extends CustomAdaptedFromTranslation<CustomComponentFor> {
    @Override
    public Class<?> from(CustomComponentFor instance) {
        return instance.forClass();
    }

    @Override
    public Class<?> to(CustomComponentFor instance) {
        return VaadinComponent.class;
    }

    @Override
    public Class<? extends Enum<?>> purposeEnum(CustomComponentFor instance) {
        return instance.purpose();
    }

    @Override
    public Object purposeValue(CustomComponentFor instance) {
        return instance.purposeValue();
    }
}
