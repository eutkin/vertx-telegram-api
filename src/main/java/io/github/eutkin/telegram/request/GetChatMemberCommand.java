package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class GetChatMemberCommand implements Command {

  private final JsonObject json;

  public GetChatMemberCommand(JsonObject json) {
    this.json = json;
  }

  public GetChatMemberCommand(Integer chatId, Integer userId) {
    this.json = new JsonObject().put("chat_id", chatId).put("user_id", userId);
  }

  public GetChatMemberCommand(String chatId, Integer userId) {
    this.json = new JsonObject().put("chat_id", chatId).put("user_id", userId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
