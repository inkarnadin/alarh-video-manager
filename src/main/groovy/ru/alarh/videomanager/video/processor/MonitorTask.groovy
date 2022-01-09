package ru.alarh.videomanager.video.processor

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.util.logging.Slf4j
import ru.alarh.videomanager.video.domain.target.TargetTracker
import ru.alarh.videomanager.video.processor.builder.MonitorProcessBuilder

@Slf4j
@EqualsAndHashCode
@CompileStatic
class MonitorTask extends AbstractTask {

  MonitorTask(TargetTracker tracker) {
    super(tracker, new ProcessExecutor(new MonitorProcessBuilder()))
    Thread.currentThread().setName(tracker.targetName)
  }

}
