package net.timeboxing.vaadin.component;

public class DefaultComponentFactory<T> implements ComponentFactory<T> {

    private final Class<T> clazz;

    public DefaultComponentFactory(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(clazz);
    }

    @Override
    public Object create() {
        return null;
    }
}
