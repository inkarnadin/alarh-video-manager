package ru.alarh.videomanager.video.service.monitor

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import ru.alarh.videomanager.video.domain.target.TargetState
import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.persistence.target.TargetRepository
import ru.alarh.videomanager.video.persistence.task.TaskRepository
import ru.alarh.videomanager.video.processor.Task
import ru.alarh.videomanager.video.properties.TargetGroupProperties
import ru.alarh.videomanager.video.service.TaskCreator

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

@Service
@CompileStatic
class MonitorImpl implements Monitor {

  static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(100)

  @Autowired
  private TargetGroupProperties groupProperties
  @Autowired
  @Qualifier("monitor")
  private TaskCreator taskCreator
  @Autowired
  private TaskRepository taskRepository
  @Autowired
  private TargetRepository targetRepository

  @Override
  void start(TargetType type) {
    def tasks = taskCreator.create(type).collect {
      scheduler.scheduleAtFixedRate(() -> it.run(), 0, 0, TimeUnit.SECONDS)
    }.collect() as List<ScheduledFuture<Task>>
    taskRepository.saveAll(type, tasks)
  }

  @Override
  void stop(TargetType type) {
    def tasks = taskRepository.findAll(type)
    tasks.each {
      it?.cancel(true)
    }
  }

  @Override
  void clear(TargetType type) {
    stop(type)
    def targets = targetRepository.findAll(type)
    targets.each {
      it.state = TargetState.UNKNOWN
    }
  }

}
