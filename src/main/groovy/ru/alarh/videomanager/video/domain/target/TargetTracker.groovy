package ru.alarh.videomanager.video.domain.target

import groovy.transform.CompileStatic
import groovy.transform.EqualsAndHashCode

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport

@CompileStatic
@EqualsAndHashCode
class TargetTracker {

  final Target target
  private final PropertyChangeSupport support

  TargetTracker(Target target) {
    this.target = target
    this.support = new PropertyChangeSupport(this)
  }

  void addListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener)
  }

  void removeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener)
  }

  void update(Target newTarget) {
    target.name = newTarget.name
    target.host = newTarget.host
    target.login = newTarget.login
    target.password = newTarget.password
    target.state = newTarget.state
    target.lastFrame = newTarget.lastFrame

    support.firePropertyChange("update", null, target)
  }

  String getTargetName() {
    return target?.name ?: "<empty name>"
  }

}
