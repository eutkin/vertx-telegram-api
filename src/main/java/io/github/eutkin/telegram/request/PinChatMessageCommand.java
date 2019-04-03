package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class PinChatMessageCommand implements Command {

  private final JsonObject json;

  public PinChatMessageCommand(JsonObject json) {
    this.json = json;
  }

  public PinChatMessageCommand(Integer chatId, Integer messageId) {
    this((Object) chatId, messageId);
  }

  public PinChatMessageCommand(String chatId, Integer messageId) {
    this((Object) chatId, messageId);
  }

  private PinChatMessageCommand(Object chatId, Integer messageId) {
    this.json = new JsonObject().put("chat_id", chatId).put("message_id", messageId);
  }

  public PinChatMessageCommand disableNotification() {
    this.json.put("disable_notification", true);
    return this;
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
