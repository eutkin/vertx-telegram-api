package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class DeleteChatPhotoCommand implements Command {

  private final JsonObject json;

  public DeleteChatPhotoCommand(JsonObject json) {
    this.json = json;
  }

  public DeleteChatPhotoCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public DeleteChatPhotoCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
