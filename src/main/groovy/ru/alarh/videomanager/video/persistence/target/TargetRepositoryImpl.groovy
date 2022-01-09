package ru.alarh.videomanager.video.persistence.target

import groovy.transform.CompileStatic
import org.springframework.stereotype.Repository
import ru.alarh.videomanager.video.domain.target.Target
import ru.alarh.videomanager.video.domain.target.TargetType

@Repository
@CompileStatic
class TargetRepositoryImpl implements TargetRepository {

  @Override
  void saveAll(TargetType type, List<Target> targets) {
    InMemoryTargetStore.put(type, targets)
  }

  @Override
  List<Target> findAll(TargetType type) {
    return InMemoryTargetStore.get(type)
  }

  @Override
  void update(boolean isOnlyNew) {
    InMemoryTargetStore.refresh(isOnlyNew)
  }

}
