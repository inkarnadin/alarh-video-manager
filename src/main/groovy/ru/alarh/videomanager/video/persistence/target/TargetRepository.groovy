package ru.alarh.videomanager.video.persistence.target

import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetType
import ru.alarh.videomanager.video.persistence.Repository

interface TargetRepository extends Repository<TargetType, Target> {

  void saveAll(TargetType type, List<Target> targets)

  List<Target> findAll(TargetType type)

  void update(boolean isOnlyNew)

}
