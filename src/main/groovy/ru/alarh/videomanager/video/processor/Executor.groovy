package ru.alarh.videomanager.video.processor

import ru.alarh.videomanager.video.domain.target.TargetTracker

interface Executor {

  void start(TargetTracker tracker)

  void stop()

  boolean state()

}
