package ru.alarh.videomanager.video.service

import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetTracker
import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.persistence.target.TargetRepository
import ru.alarh.videomanager.video.processor.MonitorTask
import ru.alarh.videomanager.video.processor.Task

@Service
@Qualifier("monitor")
@CompileStatic
class MonitorTaskCreator implements TaskCreator {

  @Autowired
  private TargetRepository repository

  @Override
  List<Task> create(TargetType type) {
    List<Target> targets = repository.findAll(type)
    return targets.collect {
      new MonitorTask(new TargetTracker(it))
    } as List<Task>
  }

}
