package net.timeboxing.adapter.impl.widget;

import jakarta.inject.Inject;
import net.timeboxing.adapter.AdaptedFrom;
import net.timeboxing.adapter.impl.CustomPurpose;
import net.timeboxing.adapter.impl.User;


@AdaptedFrom(from = User.class, to = Widget.class, purposeEnum = CustomPurpose.class, purposeValue = "ERROR2")

public class CustomErrorWidgetNoAdapteeAnnotation implements Widget {

    private final User user;
    @Inject
    public CustomErrorWidgetNoAdapteeAnnotation(User user) {
        this.user = user;
    }

    @Override
    public String display() {
        return user.name() + "error!";
    }
}
