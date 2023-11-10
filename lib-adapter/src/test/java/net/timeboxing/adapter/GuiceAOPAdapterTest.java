package net.timeboxing.adapter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.timeboxing.adapter.guice.GuiceAOPAdaptModule;
import net.timeboxing.adapter.impl.DomainFactory;
import net.timeboxing.adapter.impl.TestAdapterModule;
import net.timeboxing.adapter.impl.User;
import net.timeboxing.adapter.impl.widget.Widget;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class GuiceAOPAdapterTest {

    @Test
    void canAdapt() {
        Injector injector = Guice.createInjector(new TestAdapterModule(), new GuiceAOPAdaptModule());
        DomainFactory factory = injector.getInstance(DomainFactory.class);
        User user = factory.create("Crazy Bob");
        Optional<Widget> userWidget = user.adaptTo(Widget.class);
        Assertions.assertNotNull(userWidget.get());
    }
}
