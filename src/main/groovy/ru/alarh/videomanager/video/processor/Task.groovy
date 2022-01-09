package ru.alarh.videomanager.video.processor

interface Task extends Runnable {

  void shutdown()

  boolean state()

}