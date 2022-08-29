package net.timeboxing.guice.vaadin.guice.event;

import net.timeboxing.vaadin.event.ComponentEvent;
import net.timeboxing.vaadin.event.ListenerRegistration;
import net.timeboxing.vaadin.event.impl.DefaultVaadinComponentEventBus;
import net.timeboxing.vaadin.event.impl.YesEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VaadinComponentEventListenerTest {

    @Test
    public void canUnregister() {
        DefaultVaadinComponentEventBus eventBus = new DefaultVaadinComponentEventBus();

        ListenerRegistration registration = eventBus.listen(YesEvent.class, this::runMe);

        Assertions.assertEquals(1, eventBus.analyzeAndCount());
        registration.unregister();
        Assertions.assertEquals(0, eventBus.analyzeAndCount());
    }


    @Test
    public void gcRemoves() {
        DefaultVaadinComponentEventBus eventBus = new DefaultVaadinComponentEventBus();

        ListenerRegistration registration = eventBus.listen(YesEvent.class, this::runMe);

        Assertions.assertEquals(1, eventBus.analyzeAndCount());
        registration = null;
        System.gc();
        Assertions.assertEquals(0, eventBus.analyzeAndCount());
    }


    private <T extends ComponentEvent> void runMe(T t) {
        System.out.println("Success");
    }
}
