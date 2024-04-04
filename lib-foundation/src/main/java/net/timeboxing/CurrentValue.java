package net.timeboxing;


import jakarta.inject.Provider;

public interface CurrentValue<T> extends Provider<T> {

    void set(T value);
}
