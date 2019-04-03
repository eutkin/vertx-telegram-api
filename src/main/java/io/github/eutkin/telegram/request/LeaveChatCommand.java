package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class LeaveChatCommand implements Command {

  private final JsonObject json;

  public LeaveChatCommand(JsonObject json) {
    this.json = json;
  }

  public LeaveChatCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public LeaveChatCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
