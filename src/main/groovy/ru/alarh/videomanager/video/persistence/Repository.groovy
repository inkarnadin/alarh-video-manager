package ru.alarh.videomanager.video.persistence

interface Repository<S, T> {

  void saveAll(S type, List<T> targets)

  List<T> findAll(S type)

}
