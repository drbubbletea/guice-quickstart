package net.timeboxing.webapp;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import javax.inject.Inject;

@Route("")
public class ApplicationLayout extends AppLayout {

    @Inject
    public ApplicationLayout(MainView mainView) {
        setContent(mainView);
    }
}
