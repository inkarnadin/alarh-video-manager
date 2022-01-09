package ru.alarh.videomanager.video.persistence.task

import groovy.transform.CompileStatic
import org.springframework.stereotype.Repository
import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.processor.Task

import java.util.concurrent.ScheduledFuture

@Repository
@CompileStatic
class TaskRepositoryImpl implements TaskRepository {

  @Override
  void saveAll(TargetType type, List<ScheduledFuture<Task>> tasks) {
    InMemoryTaskStore.put(type, tasks)
  }

  @Override
  List<ScheduledFuture<Task>> findAll(TargetType type) {
    return InMemoryTaskStore.get(type)
  }

}
