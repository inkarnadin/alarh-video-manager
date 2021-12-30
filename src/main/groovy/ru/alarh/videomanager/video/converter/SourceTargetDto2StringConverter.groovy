package ru.alarh.videomanager.video.converter

import groovy.transform.CompileStatic
import ru.alarh.videomanager.meta.Transducer
import ru.alarh.videomanager.video.dto.BasicTarget

/**
 * Target converter class.
 *
 * @author inkarnadin
 */
@Transducer
@CompileStatic
class SourceTargetDto2StringConverter implements Converter<BasicTarget, String> {

  /**
   * Convert target to string.
   *
   * @param target address object
   * @return target as string
   */
  @Override
  String convert(BasicTarget target) {
    if (!target)
      return ""

    return new StringJoiner(":")
      .add(target.host)
      .add(target.path)
      .add(target.login)
      .add(target.password)
      .add(target.name)
      .toString()
  }

}
