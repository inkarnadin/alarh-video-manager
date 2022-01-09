package ru.alarh.videomanager.video.service.target

import ru.alarh.videomanager.video.domain.target.TargetType

interface BasicTargetService {

  void read()

  void update(TargetType type, boolean isOnlyNew)

}
