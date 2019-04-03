package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class SetChatTitleCommand implements Command {

  private final JsonObject json;

  public SetChatTitleCommand(JsonObject json) {
    this.json = json;
  }

  public SetChatTitleCommand(Integer chatId, String title) {
    this((Object) chatId, title);
  }

  public SetChatTitleCommand(String chatId, String title) {
      this((Object) chatId, title);
  }

  private SetChatTitleCommand(Object chatId, String title) {
    this.json = new JsonObject().put("chat_id", chatId).put("title", title);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
