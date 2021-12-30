package ru.alarh.videomanager.video.domain.target

class BasicTarget {

  String host
  String path
  String login
  String password
  String name

  BasicTarget(String... params) {
    host = params[0]
    path = params[1]
    login = params[2]
    password = params[3]
    name = params.length == 5 ? params[4] : ''
  }

}
