package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.*;
import io.vertx.core.json.JsonObject;

public abstract class SendCommand<C extends SendCommand> implements Command {

  protected final JsonObject json;

  public SendCommand(JsonObject json) {
    this.json = json;
  }

  public SendCommand(Object chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  protected C put(String key, Object value) {
    this.json.put(key, value);
    return (C) this;
  }

  public C parseMode(ParseMode parseMode) {
    return put("parse_mode", parseMode.name());
  }

  public C disableWebPagePreview() {
    return put("disable_web_page_preview", true);
  }

  public C disableNotification() {
    return put("disable_notification", true);
  }

  public C replyToMessageId(Integer messageId) {
    return put("reply_to_message_id", messageId);
  }

  public C replyMarkup(InlineKeyboardMarkup markup) {
    return put("reply_markup", markup.toJson());
  }

  public C replyMarkup(ReplyKeyboardMarkup markup) {
    return put("reply_markup", markup.toJson());
  }

  public C replyMarkup(ReplyKeyboardRemove markup) {
    return put("reply_markup", markup.toJson());
  }

  public C replyMarkup(ForceReply markup) {
    return put("reply_markup", markup.toJson());
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
