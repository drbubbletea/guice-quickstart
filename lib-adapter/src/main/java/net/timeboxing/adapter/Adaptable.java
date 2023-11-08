package net.timeboxing.adapter;

import java.util.Optional;

public interface Adaptable {

    default <T> Optional<T> adaptTo(Class<T> desiredClass) {
        return Optional.empty();
    }
}
