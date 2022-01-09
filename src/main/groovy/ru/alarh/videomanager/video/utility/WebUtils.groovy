package ru.alarh.videomanager.video.utility

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import ru.alarh.videomanager.video.domain.target.Target

@Slf4j
@CompileStatic
final class WebUtils {

  private WebUtils() {
    throw new UnsupportedOperationException("Unable to instantiate utility class")
  }

  /**
   * Build RTSP link.
   *
   * @param target remote host object data
   * @return RTSP link
   */
  static String buildRTSPLink(Target target) {
    String path = target.path && !target.path.startsWith("/")
      ? "/$target.path"
      : target.path

    String url = (target.login && target.password)
      ? "rtsp://$target.login:$target.password@$target.host$path"
      : "rtsp://$target.host$path"

    return url
  }

}
