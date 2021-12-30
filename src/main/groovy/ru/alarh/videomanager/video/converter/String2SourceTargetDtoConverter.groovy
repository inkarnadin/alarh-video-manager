package ru.alarh.videomanager.video.converter

import groovy.transform.CompileStatic
import ru.alarh.videomanager.meta.Transducer
import ru.alarh.videomanager.video.dto.BasicTarget

@Transducer
@CompileStatic
class String2SourceTargetDtoConverter implements Converter<String, BasicTarget> {

  /**
   * Convert string to target object.
   *
   * @param value target as string with colon delimiter.
   * @return target object
   */
  @Override
  BasicTarget convert(String value) {
    return (value)
       ? new BasicTarget(value.split(":"))
       : null
  }

}
