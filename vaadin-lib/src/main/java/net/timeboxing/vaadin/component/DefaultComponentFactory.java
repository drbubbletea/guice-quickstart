package net.timeboxing.vaadin.component;

public class DefaultComponentFactory<T> implements ComponentFactory<T> {

    private final Class<T> clazz;
    private final ComponentCreator creator;

    public DefaultComponentFactory(Class<T> clazz, ComponentCreator creator) {
        this.clazz = clazz;
        this.creator = creator;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(this.clazz);
    }

    @Override
    public Object create() {
        return null;
    }
}
