package ru.alarh.videomanager.video.processor

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j
@CompileStatic
class ProcessKiller {

  static void kill(Process process) {
    log.debug("Process {} will be killed", process.pid())
    try {
      new ProcessBuilder().command("kill", String.valueOf(process.pid())).start()
      Thread.sleep(1000)
      log.debug("Process {} killed successfully", process.pid())
    } catch (IOException | InterruptedException ignored) {
      process.destroy()
      log.debug("Process {} killed with errors", process.pid())
    }
  }

  static void killAll() {
    log.debug("Processes with name contains {} will be killed", "ffmpeg")
    try {
      new ProcessBuilder().command("pkill ffmpeg").start()
      Thread.sleep(1000)
    } catch (IOException | InterruptedException ignored) {
      log.debug("Processes with name contains {} killing failure", "ffmpeg")
    }
  }

}
