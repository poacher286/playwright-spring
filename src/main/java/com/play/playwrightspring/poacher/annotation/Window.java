package com.play.playwrightspring.poacher.annotation;

import java.lang.annotation.*;

@UIPage
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Window {
    String value() default "";
}
