package ru.alarh.videomanager.meta

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

import java.lang.annotation.*

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@interface Transducer {

  @AliasFor(annotation = Component.class)
  String value() default "";

}