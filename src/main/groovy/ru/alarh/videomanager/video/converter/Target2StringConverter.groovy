package ru.alarh.videomanager.video.converter

import groovy.transform.CompileStatic
import ru.alarh.videomanager.meta.Transducer
import ru.alarh.videomanager.video.domain.target.Target

/**
 * Target converter class.
 *
 * @author inkarnadin
 */
@Transducer
@CompileStatic
class Target2StringConverter implements Converter<Target, String> {

  /**
   * Convert target to string.
   *
   * @param target address object
   * @return target as string
   */
  @Override
  String convert(Target target) {
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
