package net.timeboxing.adapter;

public interface AdaptedFromFactory {

    Object get(Object source, Class<? extends Enum<?>> purposeEnum, Object purposeValue);

}
