package net.timeboxing.transaction;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, METHOD})
@Retention(RUNTIME)
public @interface Transactional {
    TransactionType value() default TransactionType.REQUIRED;

    enum TransactionType {
        REQUIRED,

//        REQUIRES_NEW
    }

    Class[] rollbackOn() default {};

    Class[] dontRollbackOn() default {};

}
