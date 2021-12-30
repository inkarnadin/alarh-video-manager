package ru.alarh.videomanager.video.utility

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Slf4j
@CompileStatic
class FileUtils {

  /**
   * Pre-validate file path and return path if file exists.
   *
   * @param pathToFile path to file
   * @return wrapped path object if file is exists
   */
  static Optional<Path> checkAndGetFilePath(String pathToFile) {
    if (pathToFile) {
      Path path = Paths.get(pathToFile)
      if (Files.exists(path))
        return Optional.of(path)
    }
    log.warn("Wrong file path: {}", pathToFile)
    return Optional.empty()
  }

}
