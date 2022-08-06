package net.timeboxing.vaadin.component;

public interface ComponentFactory<T> {

    boolean supports(Class<?> clazz);

    Object create();
}
