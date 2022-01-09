package ru.alarh.videomanager.video.domain.target

import groovy.transform.CompileStatic

@CompileStatic
class Target {

  String host
  String path
  String login
  String password
  String name

  Frame lastFrame = Frame.DEFAULT_FRAME
  TargetState state = TargetState.UNKNOWN

  String location

  Target(String... params) {
    host = params[0]
    path = params[1]
    login = params[2]
    password = params[3]
    name = params.length == 5 ? params[4] : ''
  }

}
