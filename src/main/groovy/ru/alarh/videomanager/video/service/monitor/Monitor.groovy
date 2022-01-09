package ru.alarh.videomanager.video.service.monitor

import ru.alarh.videomanager.video.domain.target.TargetType

interface Monitor {

  void start(TargetType type)

  void stop(TargetType type)

  void clear(TargetType type)

}