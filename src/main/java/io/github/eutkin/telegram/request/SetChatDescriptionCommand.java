package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SetChatDescriptionCommand implements Command {

  private final JsonObject json;

  public SetChatDescriptionCommand(JsonObject json) {
    this.json = json;
  }

  public SetChatDescriptionCommand(Integer chatId, String description) {
    this((Object) chatId, description);
  }

  public SetChatDescriptionCommand(String chatId, String description) {
    this((Object) chatId, description);
  }

  private SetChatDescriptionCommand(Object chatId, String description) {
    this.json = new JsonObject().put("chat_id", chatId).put("description", description);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
