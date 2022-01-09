package ru.alarh.videomanager.video.processor.filter

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetState

@PackageScope
@CompileStatic
class UnauthorizedFilter extends Filter {

  private final static List filters = [
    ".*401 Unauthorized.*"
  ]

  UnauthorizedFilter(Target target) {
    super(target)
  }

  @Override
  boolean filtrate(String line) {
    boolean result = filters.find { error ->
      line ==~ error
    }

    if (result)
      target.state = TargetState.WRONG_AUTH

    return (result) ? true : nextFilter(line)
  }

}
