package net.timeboxing.vaadin;

import net.timeboxing.vaadin.component.ComponentPurpose;

import javax.inject.Inject;

/**
 * Simplified implementation of the adapter pattern for our Vaadin widgets.
 */
public class ComponentAdapter {

    private ComponentAdapter() {
        /* NOOP */
    }

    @Inject
    static void initialize() {

    }

    static <T> T adapt(Class<?> source, ComponentPurpose purpose) {
        return null;
    }

}
