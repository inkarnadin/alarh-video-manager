package ru.alarh.videomanager.video.service.target

import groovy.transform.CompileStatic
import org.springframework.stereotype.Service

import ru.alarh.videomanager.video.converter.Converter
import ru.alarh.videomanager.video.dto.BasicTarget
import ru.alarh.videomanager.video.persistence.InMemoryTargetStore
import ru.alarh.videomanager.video.enums.TargetType
import ru.alarh.videomanager.video.properties.TargetGroupProperties
import ru.alarh.videomanager.video.utility.FileUtils

import java.nio.file.Files
import java.nio.file.Path

import static ru.alarh.videomanager.video.enums.TargetType.ACTIVE
import static ru.alarh.videomanager.video.enums.TargetType.DEAD
import static ru.alarh.videomanager.video.enums.TargetType.TWINKLED
import static ru.alarh.videomanager.video.enums.TargetType.UNCERTAIN
import static ru.alarh.videomanager.video.enums.TargetType.UNCHECKED
import static ru.alarh.videomanager.video.enums.TargetType.VERIFIED

@Service
@CompileStatic
class BasicTargetServiceImpl implements BasicTargetService {

  private final TargetGroupProperties properties
  private final Converter<String, BasicTarget> converter

  @SuppressWarnings('SpringJavaInjectionPointsAutowiringInspection')
  BasicTargetServiceImpl(TargetGroupProperties properties, Converter<String, BasicTarget> converter) {
    this.properties = properties
    this.converter = converter
  }

  @Override
  void read() {
    FileUtils.checkAndGetFilePath(properties.active.source).ifPresent(p -> readByType(ACTIVE, p))
    FileUtils.checkAndGetFilePath(properties.verified.source).ifPresent(p -> readByType(VERIFIED, p))
    FileUtils.checkAndGetFilePath(properties.unchecked.source).ifPresent(p -> readByType(UNCHECKED, p))
    FileUtils.checkAndGetFilePath(properties.uncertain.source).ifPresent(p -> readByType(UNCERTAIN, p))
    FileUtils.checkAndGetFilePath(properties.twinkled.source).ifPresent(p -> readByType(TWINKLED, p))
    FileUtils.checkAndGetFilePath(properties.dead.source).ifPresent(p -> readByType(DEAD, p))
  }

  private readByType(TargetType type, Path path) {
    List<BasicTarget> targets = path.collect { Path p ->
      Files.readAllLines(p).findResult {
        converter.convert(it)
      }
    }
    InMemoryTargetStore.put(type, targets)
  }

}
