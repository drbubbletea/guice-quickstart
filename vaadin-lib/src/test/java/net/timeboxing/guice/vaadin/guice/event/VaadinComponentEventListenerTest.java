package net.timeboxing.guice.vaadin.guice.event;

import net.timeboxing.vaadin.event.ListenerRegistration;
import net.timeboxing.vaadin.event.VaadinComponentEventBus;
import net.timeboxing.vaadin.event.impl.DefaultVaadinComponentEventBus;
import net.timeboxing.vaadin.event.impl.YesEvent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VaadinComponentEventListenerTest {

    @Test
    public void works() {
        VaadinComponentEventBus eventBus = new DefaultVaadinComponentEventBus();

        ListenerRegistration registration = eventBus.listen(YesEvent.class, this::runMe);

        // TODO: count listeners in bus (expect 1)
        registration.unregister();
        // TODO: count listeners in bus (expect 0)
        Assertions.fail();
    }

    private void runMe(YesEvent event) {

    }
}
