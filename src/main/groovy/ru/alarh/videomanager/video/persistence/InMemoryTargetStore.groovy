package ru.alarh.videomanager.video.persistence

import groovy.transform.CompileStatic
import ru.alarh.videomanager.video.domain.target.BasicTarget
import ru.alarh.videomanager.video.domain.target.TargetType

@CompileStatic
class InMemoryTargetStore {

  static final Map<TargetType, List<BasicTarget>> globalTargetMap = [:]

  static void put(TargetType type, List<BasicTarget> targets) {
    globalTargetMap.put(type, targets)
  }

  static void output() {
    println globalTargetMap
  }

}
