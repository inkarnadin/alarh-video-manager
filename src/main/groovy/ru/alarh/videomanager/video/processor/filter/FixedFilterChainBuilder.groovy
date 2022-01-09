package ru.alarh.videomanager.video.processor.filter

import groovy.transform.CompileStatic
import ru.alarh.videomanager.video.domain.target.Target

@CompileStatic
class FixedFilterChainBuilder {

  static Filter build(Target target) {
    Filter filter = new ConnectionTimeoutFilter(target)
    filter.link(new UnauthorizedFilter(target))
      .link(new InvalidDataFilter(target))
      .link(new PathNotFoundFilter(target))
    return filter
  }

}
