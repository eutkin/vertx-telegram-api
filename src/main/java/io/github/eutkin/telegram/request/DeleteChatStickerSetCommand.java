package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class DeleteChatStickerSetCommand implements Command {

  private final JsonObject json;

  public DeleteChatStickerSetCommand(JsonObject json) {
    this.json = json;
  }

  public DeleteChatStickerSetCommand(Integer chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  public DeleteChatStickerSetCommand(String chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
