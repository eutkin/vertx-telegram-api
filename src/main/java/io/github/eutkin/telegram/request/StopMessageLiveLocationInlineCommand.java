package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.InlineKeyboardMarkup;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class StopMessageLiveLocationInlineCommand implements Command {

  private final JsonObject json;

  public StopMessageLiveLocationInlineCommand(JsonObject json) {
    this.json = json;
  }

  public static StopMessageLiveLocationInlineCommand from(String inlineMessageId) {
    JsonObject json = new JsonObject().put("inline_message_id", inlineMessageId);
    return new StopMessageLiveLocationInlineCommand(json);
  }

  public StopMessageLiveLocationInlineCommand replyMarkup(InlineKeyboardMarkup markup) {
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
