package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.InlineKeyboardMarkup;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class StopMessageLiveLocationMessageCommand implements Command {

  private final JsonObject json;

  public StopMessageLiveLocationMessageCommand(JsonObject json) {
    this.json = json;
  }

  public static StopMessageLiveLocationMessageCommand from(String chatId, Integer messageId) {
    return fromMes(chatId, messageId);
  }

  public static StopMessageLiveLocationMessageCommand from(Integer chatId, Integer messageId) {
   return fromMes(chatId, messageId);
  }

  private static StopMessageLiveLocationMessageCommand fromMes(Object chatId, Integer messageId) {
    JsonObject json = new JsonObject().put("chat_id", chatId).put("message_id", messageId);
    return new StopMessageLiveLocationMessageCommand(json);
  }

  public StopMessageLiveLocationMessageCommand replyMarkup(InlineKeyboardMarkup markup) {
    if (markup != null) {
      json.put("reply_markup", markup.toJson());
    }
    return this;
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
