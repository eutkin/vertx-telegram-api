package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class GetChatAdministratorsCommand implements Command {

  private final JsonObject json;

  public GetChatAdministratorsCommand(JsonObject json) {
    this.json = json;
  }

  public GetChatAdministratorsCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public GetChatAdministratorsCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
