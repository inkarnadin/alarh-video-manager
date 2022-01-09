package ru.alarh.videomanager.video.processor.filter

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetState

@PackageScope
@CompileStatic
class PathNotFoundFilter extends Filter {

  private final static List filters = [
    ".*404 Not Found.*"
  ]

  PathNotFoundFilter(Target target) {
    super(target)
  }

  @Override
  boolean filtrate(String line) {
    boolean result = filters.find { error ->
      line ==~ error
    }

    if (result)
      target.state = TargetState.NOT_FOUND

    return (result) ? true : nextFilter(line)
  }

}

