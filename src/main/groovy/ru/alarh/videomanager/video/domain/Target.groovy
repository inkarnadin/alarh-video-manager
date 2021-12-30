package ru.alarh.videomanager.video.domain


import ru.alarh.videomanager.video.dto.BasicTarget

class Target {

  String host
  String path
  String login
  String password
  String name

  Frame lastFrame = Frame.DEFAULT_FRAME
  //TargetStatus status = TargetStatus.UNKNOWN

  String location

  Target(BasicTarget targetDto) {
    host = targetDto.host
    path = targetDto.path
    login = targetDto.login
    password = targetDto.password
    name = targetDto.name
  }

}
