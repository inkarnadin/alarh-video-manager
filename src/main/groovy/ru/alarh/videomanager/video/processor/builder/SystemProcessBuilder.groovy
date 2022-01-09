package ru.alarh.videomanager.video.processor.builder

import ru.alarh.videomanager.video.domain.target.Target

interface SystemProcessBuilder {

  ProcessBuilder build(Target tracker, int counterValue)

}