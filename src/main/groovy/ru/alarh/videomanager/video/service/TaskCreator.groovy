package ru.alarh.videomanager.video.service

import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.processor.Task

interface TaskCreator {

  List<Task> create(TargetType type)

}
