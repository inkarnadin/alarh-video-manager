package ru.alarh.videomanager.video.domain.target

class Target {

  String host
  String path
  String login
  String password
  String name

  Frame lastFrame = Frame.DEFAULT_FRAME
  TargetState state = TargetState.UNKNOWN

  String location

  Target(BasicTarget targetDto) {
    host = targetDto.host
    path = targetDto.path
    login = targetDto.login
    password = targetDto.password
    name = targetDto.name
  }

}
