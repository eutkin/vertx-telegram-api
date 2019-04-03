package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.VertxGen;

@VertxGen
public enum ChatAction {

  TYPING, UPLOAD_PHOTO, RECORD_VIDEO, UPLOAD_VIDEO, RECORD_AUDIO, UPLOAD_AUDIO, UPLOAD_DOCUMENT,

  FIND_LOCATION, RECORD_VIDEO_NOTE, UPLOAD_VIDEO_NOTE
}
