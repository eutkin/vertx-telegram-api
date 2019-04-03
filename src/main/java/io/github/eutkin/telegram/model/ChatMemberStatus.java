package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.VertxGen;

@VertxGen
public enum  ChatMemberStatus {
  creator, administrator, member, restricted, left, kicked;
}
