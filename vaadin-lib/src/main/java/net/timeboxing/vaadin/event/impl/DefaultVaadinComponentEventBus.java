package net.timeboxing.vaadin.event.impl;

import net.timeboxing.vaadin.event.ComponentEvent;
import net.timeboxing.vaadin.event.ListenerRegistration;
import net.timeboxing.vaadin.event.VaadinComponentEventBus;
import net.timeboxing.vaadin.event.VaadinComponentEventListener;

public class DefaultVaadinComponentEventBus implements VaadinComponentEventBus {

    @Override
    public <T extends ComponentEvent> ListenerRegistration listen(Class<T> event, VaadinComponentEventListener<T> listener) {
        return null;
    }
}
