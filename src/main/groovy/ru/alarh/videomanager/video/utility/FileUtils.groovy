package ru.alarh.videomanager.video.utility

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

@Slf4j
@CompileStatic
final class FileUtils {

  private FileUtils() {
    throw new UnsupportedOperationException("Unable to instantiate utility class")
  }

  static private String userDir = System.getProperty('user.dir')

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

  static String getOrCreateTargetDirectory(String directoryName, String directoryTypeName) {
    String rootPath = "$userDir/$directoryTypeName"
    new File(rootPath).mkdir()
    String path = "$rootPath/$directoryName"
    new File(path).mkdir()
    return path
  }

}
