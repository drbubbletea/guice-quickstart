package net.timeboxing.vaadin.component;

import net.timeboxing.adapter.CustomAdaptedFrom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for using custom purpose enums.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@CustomAdaptedFrom(translation = ComponentForTranslation.class)
public @interface CustomComponentFor {

    Class<?> forClass();

    Class<? extends Enum<?>> purpose() default ComponentPurpose.class;

    String purposeValue() default "DEFAULT";
}
