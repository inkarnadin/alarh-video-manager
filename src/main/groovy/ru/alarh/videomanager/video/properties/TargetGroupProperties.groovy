package ru.alarh.videomanager.video.properties

import groovy.transform.TupleConstructor
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = 'alarh.target-group')
class TargetGroupProperties {

  TargetGroup active
  TargetGroup verified
  TargetGroup unchecked
  TargetGroup uncertain
  TargetGroup dead

  @TupleConstructor
  static class TargetGroup {

    String source
    String monitoring

  }

}
