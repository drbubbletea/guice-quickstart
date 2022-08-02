package net.timeboxing.vaadin;

import net.timeboxing.vaadin.widget.WidgetPurpose;

import javax.inject.Inject;

/**
 * Simple
 */
public class WidgetAdapter {

    private WidgetAdapter() {
        /* NOOP */
    }

    static <T> T adapt(Class<?> source, WidgetPurpose purpose) {
        return null;
    }

    @Inject
    void initialize() {

    }
}
