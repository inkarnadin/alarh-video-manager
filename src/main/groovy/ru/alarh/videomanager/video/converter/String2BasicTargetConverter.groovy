package ru.alarh.videomanager.video.converter

import groovy.transform.CompileStatic
import ru.alarh.videomanager.meta.Transducer
import ru.alarh.videomanager.video.domain.target.Target

@Transducer
@CompileStatic
class String2BasicTargetConverter implements Converter<String, Target> {

  /**
   * Convert string to target object.
   *
   * @param value target as string with colon delimiter.
   * @return target object
   */
  @Override
  Target convert(String value) {
    return (value)
       ? new Target(value.split(":"))
       : null
  }

}
