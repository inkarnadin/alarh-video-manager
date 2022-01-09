package ru.alarh.videomanager.video.persistence.task

import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.persistence.Repository
import ru.alarh.videomanager.video.processor.Task

import java.util.concurrent.ScheduledFuture

interface TaskRepository extends Repository<TargetType, ScheduledFuture<Task>> {

  void saveAll(TargetType type, List<ScheduledFuture<Task>> tasks)

  List<ScheduledFuture<Task>> findAll(TargetType type)

}
