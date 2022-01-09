package ru.alarh.videomanager.video.processor.filter

import groovy.transform.CompileStatic
import ru.alarh.videomanager.video.domain.target.Target

@CompileStatic
abstract class Filter {

  private Filter filter

  protected final Target target

  Filter(Target target) {
    this.target = target
  }

  Filter link(Filter filter) {
    this.filter = filter
    return filter
  }

  abstract boolean filtrate(String line)

  protected boolean nextFilter(String line) {
    if (!filter)
      return false
    return filter.filtrate(line)
  }

}