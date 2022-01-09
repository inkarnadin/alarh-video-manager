package ru.alarh.videomanager.video.processor

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import ru.alarh.videomanager.video.domain.target.TargetTracker

@Slf4j
@CompileStatic
abstract class AbstractTask implements Task {

  protected final Executor executor
  protected final TargetTracker tracker

  AbstractTask(TargetTracker tracker, Executor executor) {
    this.executor = executor
    this.tracker = tracker
  }

  @Override
  void run() {
    log.info("<${tracker.targetName}>")
    executor.start(tracker)
  }

  @Override
  void shutdown() {
    executor.stop()
  }

  @Override
  boolean state() {
    executor.state()
  }

}
