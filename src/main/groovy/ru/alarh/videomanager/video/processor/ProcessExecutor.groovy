package ru.alarh.videomanager.video.processor

import groovy.transform.CompileStatic
import ru.alarh.videomanager.video.domain.target.TargetTracker
import ru.alarh.videomanager.video.processor.builder.SystemProcessBuilder

import java.util.concurrent.CompletableFuture

@CompileStatic
class ProcessExecutor implements Executor {

  private int counter
  private Process process

  private SystemProcessBuilder builder

  ProcessExecutor(SystemProcessBuilder builder) {
    this.builder = builder
  }

  @Override
  void start(TargetTracker tracker) {
    process = builder.build(tracker.target, counter++).start()
    CompletableFuture.runAsync(() -> new LogReader(process, tracker).run())
  }

  @Override
  void stop() {
    if (state())
      ProcessKiller.kill(process)
  }

  @Override
  boolean state() {
    process?.isAlive()
  }

}
