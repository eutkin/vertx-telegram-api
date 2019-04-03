package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class GetChatMembersCountCommand implements Command {

  private final JsonObject json;

  public GetChatMembersCountCommand(JsonObject json) {
    this.json = json;
  }

  public GetChatMembersCountCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public GetChatMembersCountCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
