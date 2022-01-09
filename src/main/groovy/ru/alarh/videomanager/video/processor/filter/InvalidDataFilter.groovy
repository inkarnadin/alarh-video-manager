package ru.alarh.videomanager.video.processor.filter

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetState

@PackageScope
@CompileStatic
class InvalidDataFilter extends Filter {

  private final static List filters = [
    ".*Invalid data found when processing input.*",
    ".*500 Internal Server Error.*"
  ]

  InvalidDataFilter(Target target) {
    super(target)
  }

  @Override
  boolean filtrate(String line) {
    boolean result = filters.find { error ->
      line ==~ error
    }

    if (result)
      target.state = TargetState.INVALID

    return (result) ? true : nextFilter(line)
  }

}
