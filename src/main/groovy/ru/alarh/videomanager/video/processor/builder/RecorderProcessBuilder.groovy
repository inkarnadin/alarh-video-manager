package ru.alarh.videomanager.video.processor.builder

import groovy.transform.CompileStatic
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.utility.FileUtils
import ru.alarh.videomanager.video.utility.WebUtils

@CompileStatic
class RecorderProcessBuilder implements SystemProcessBuilder {

  @Override
  ProcessBuilder build(Target target, int counterValue) {
    String url = WebUtils.buildRTSPLink(target)
    String path = FileUtils.getOrCreateTargetDirectory(target.name, "video")

    List<String> commandAndArgs = [
      "ffmpeg",
      "-y",
      "-hide_banner",
      "-rtsp_transport", "tcp",
      "-i", url,
      "-acodec", "copy",
      "-vcodec", "copy",
      "$path/$counterValue" + ".mkv" as String
    ]

    return new ProcessBuilder()
      .redirectErrorStream(true)
      .command(commandAndArgs)
  }

}
