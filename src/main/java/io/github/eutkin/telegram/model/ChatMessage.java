package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ChatMessage {

  private final Chat chat;

  public ChatMessage(JsonObject json) {
    this.chat = new Chat(json.getJsonObject("chat"));
  }

  public Chat getChat() {
    return chat;
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject().put("chat", getChat().toJson());
    return json;
  }
}
