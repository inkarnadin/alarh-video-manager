package ru.alarh.videomanager.video.processor

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import ru.alarh.videomanager.video.domain.target.TargetTracker
import ru.alarh.videomanager.video.processor.builder.RecorderProcessBuilder

@Slf4j
@CompileStatic
class RecordTask extends AbstractTask {

  RecordTask(TargetTracker tracker) {
    super(tracker, new ProcessExecutor(new RecorderProcessBuilder()))
  }

}
