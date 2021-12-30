package ru.alarh.videomanager.video.converter

interface Converter<T, S> {

  S convert(T value)

}