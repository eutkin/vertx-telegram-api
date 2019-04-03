package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class UnpinChatMessageCommand implements Command {

  private final JsonObject json;

  public UnpinChatMessageCommand(JsonObject json) {
    this.json = json;
  }

  public UnpinChatMessageCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public UnpinChatMessageCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
