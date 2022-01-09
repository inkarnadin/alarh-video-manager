package ru.alarh.videomanager.video.processor

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import ru.alarh.videomanager.video.domain.target.Frame
import ru.alarh.videomanager.video.domain.target.TargetState
import ru.alarh.videomanager.video.domain.target.TargetTracker
import ru.alarh.videomanager.video.processor.filter.Filter
import ru.alarh.videomanager.video.processor.filter.FixedFilterChainBuilder

import java.util.concurrent.CancellationException

@Slf4j
@CompileStatic
class LogReader implements Runnable {

  private final Process process
  private final TargetTracker tracker
  private final String targetName

  private final Filter filter

  LogReader(Process process, TargetTracker tracker) {
    this.process = process
    this.tracker = tracker
    this.targetName = "<${tracker.targetName}>"
    this.filter = FixedFilterChainBuilder.build(tracker.target)
  }

  /**
   * Method for run reading output FFmpeg logs and save it to log file.
   * If during reading was found lines corresponding error pattern then task will be stopped.
   */
  @Override
  void run() {
    log.info("{} start read output!", targetName)

    try (BufferedReader br = new BufferedReader(new InputStreamReader(process.inputStream))) {
      String line
      while ((line = br.readLine()) != null) {
        if (filter.filtrate(line)) {
          log.warn("{} {}", targetName, line)
          throw new CancellationException()
        }

        updateFrameData(line)
        log.debug("{} {}", targetName, line)
      }
    } catch (IOException ex) {
      log.warn(ex.message)
    }

    tracker.target.state = TargetState.SUCCESS

    log.info("{} stop reading output!", targetName)
  }

  void updateFrameData(String line) {
    if (line.indexOf("frame") != -1) {
      tracker.target.lastFrame = new Frame(line)
      tracker.update(tracker.target)
    }
  }

}
