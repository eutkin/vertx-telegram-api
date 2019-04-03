package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class GetChatCommand implements Command {

  private final JsonObject json;

  public GetChatCommand(JsonObject json) {
    this.json = json;
  }

  public GetChatCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public GetChatCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
