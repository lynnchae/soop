package org.lynn.soop.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DisplayResourceKey {
    public final static String USE_DEFAULT_NAME = "";
    String value() default USE_DEFAULT_NAME;
}
