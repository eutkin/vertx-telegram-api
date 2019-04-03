package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SetChatStickerSetCommand implements Command {

  private final JsonObject json;

  public SetChatStickerSetCommand(JsonObject json) {
    this.json = json;
  }

  public SetChatStickerSetCommand(Integer chatId, String stickerSetName) {
    this((Object) chatId, stickerSetName);
  }

  public SetChatStickerSetCommand(String chatId, String stickerSetName) {
    this((Object) chatId, stickerSetName);
  }

  private SetChatStickerSetCommand(Object chatId, String stickerSetName) {
    this.json = new JsonObject().put("chat_id", chatId).put("sticker_set_name", stickerSetName);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
