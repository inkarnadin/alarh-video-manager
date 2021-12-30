package ru.alarh.videomanager.meta

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
@interface Transducer {

  @AliasFor(annotation = Component.class)
  String value() default "";

}