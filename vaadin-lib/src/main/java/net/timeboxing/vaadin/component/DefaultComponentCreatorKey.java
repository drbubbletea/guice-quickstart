package net.timeboxing.vaadin.component;

import com.google.common.base.Objects;

public class DefaultComponentCreatorKey<T extends Enum<T>> {

    private final Class<?> forClass;
    private final Class<T> purposeEnum;
    private final T purposeValue;

    public DefaultComponentCreatorKey(Class<?> forClass, Class<T> purposeEnum, T purposeValue) {
        this.forClass = forClass;
        this.purposeEnum = purposeEnum;
        this.purposeValue = purposeValue;
    }

    @Override
    public String toString() {
        return "DefaultComponentCreatorKey{" +
                "forClass=" + forClass +
                ", purposeEnum=" + purposeEnum +
                ", purposeValue=" + purposeValue +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultComponentCreatorKey<?> that = (DefaultComponentCreatorKey<?>) o;
        return Objects.equal(forClass, that.forClass) && Objects.equal(purposeEnum, that.purposeEnum) && Objects.equal(purposeValue, that.purposeValue);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(forClass, purposeEnum, purposeValue);
    }
}
