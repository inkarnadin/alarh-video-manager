package ru.alarh.videomanager.video.persistence.target

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetType

@PackageScope
@CompileStatic
class InMemoryTargetStore {

  private static final Map<TargetType, List<Target>> globalTargetMap = [:]

  static void put(TargetType type, List<Target> targets) {
    globalTargetMap.put(type, targets)
  }

  /**
   * Refresh target's data.
   *
   * @param isOnlyNew update only new items
   */
  static void refresh(boolean isOnlyNew) {
//    Map<TargetType, List<Target>> targets = globalBasicTargetMap.collectEntries {
//      [
//        (it.key): it.value.findAll {
//          Target t = converter.convert(it)
//          if (isOnlyNew)
//            if (comparator.compare(t, it))
//              return t
//        }
//      ]
//    }
    globalTargetMap.putAll([])
  }

  static List<Target> get(TargetType type) {
    return globalTargetMap.get(type)
  }

//  static void output() {
//    println globalBasicTargetMap
//  }

}
