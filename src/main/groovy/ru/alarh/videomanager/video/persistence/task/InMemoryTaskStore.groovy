package ru.alarh.videomanager.video.persistence.task

import groovy.transform.CompileStatic
import groovy.transform.PackageScope
import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.processor.Task

import java.util.concurrent.ScheduledFuture

@PackageScope
@CompileStatic
class InMemoryTaskStore {

  private static Map<TargetType, List<ScheduledFuture<Task>>> taskMap = [:]

  static void put(TargetType type, List<ScheduledFuture<Task>> tasks) {
    taskMap.put(type, tasks)
  }

  static List<ScheduledFuture<Task>> get(TargetType type) {
    return taskMap.get(type) ?: []
  }

}
