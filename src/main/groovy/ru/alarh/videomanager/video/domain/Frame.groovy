package ru.alarh.videomanager.video.domain

import groovy.util.logging.Slf4j

/**
 * Information about frame.
 *
 * @author inkarnadin
 */
@Slf4j
class Frame {

  public final static Frame DEFAULT_FRAME = new Frame()

  long frame
  long size

  double fps
  double bitrate
  double speed

  Time time

  Frame() {
    this.frame = -1
    this.size = -1

    this.fps = 0.0d
    this.bitrate = 0.0d
    this.speed = 0.0d

    this.time = new Time()
  }

  Frame(String source) {
    log.trace("Source frame data: {}", source)

    try {
      def match = (source =~ /frame=\h*(\d+)/)
      if (match.find()) {
        frame = (match[0] as List)[1] as long
        log.trace("Extract frame value {}", frame)
      }

      match = (source =~ /size=\h*(\d+)/)
      if (match.find()) {
        size = (match[0] as List)[1] as long
        log.trace("Extract size value {}", size)
      }

      match = (source =~ /fps=\h*([\d\\.]+)/)
      if (match.find()) {
        fps = (match[0] as List)[1] as double
        log.trace("Extract fps value {}", fps)
      }

      match = (source =~ /bitrate=\h*([\d\\.]+)/)
      if (match.find()) {
        bitrate = (match[0] as List)[1] as double
        log.trace("Extract bitrate value {}", bitrate)
      }

      match = (source =~ /speed=\h*([\d\\.]+)/)
      if (match.find()) {
        speed = (match[0] as List)[1] as double
        log.trace("Extract speed value {}", speed)
      }

      match = (source =~ /time=\h*(\d{2}:\d{2}:\d{2})/)
      if (match.find())
        time = new Time((match[0] as List)[1] as String)

    } catch (Exception xep) {
      log.warn("Problem during extracting frame data: {}", xep.message)
    }
  }

  private class Time {

    private int hours = 0
    private int minutes = 0
    private int seconds = 0

    Time(String time = "00:00:00") {
      String[] values = time.split(":")

      if (values.length == 3) {
        this.hours = values[0] as int
        this.minutes = values[1] as int
        this.seconds = values[2] as int
      }
    }

    @Override
    String toString() {
      return String.format("%02d:%02d:%02d", this.hours, this.minutes, this.seconds)
    }
  }

}