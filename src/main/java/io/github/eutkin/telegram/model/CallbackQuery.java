package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class CallbackQuery {

  private final String id;
  private final User from;
  private final ChatMessage message;
  private final String inlineMessageId;
  private final String chatInstance;
  private final String data;
  private final String gameShortName;

  public CallbackQuery(JsonObject json) {
    this.id = json.getString("id");
    this.from = new User(json.getJsonObject("from"));
    this.message = json.containsKey("message") ? new ChatMessage(json.getJsonObject("message")) : null;
    this.inlineMessageId = json.getString("inline_message_id");
    this.chatInstance = json.getString("chat_instance");
    this.data = json.getString("data");
    this.gameShortName = json.getString("game_short_name");
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("id", getId())
      .put("from", getFrom().toJson())
      .put("chat_instance", getChatInstance());
    getMessage().map(ChatMessage::toJson).ifPresent(v -> json.put("message", v));
    getInlineMessageId().ifPresent(v -> json.put("inline_message_id", v));
    getData().ifPresent(v -> json.put("data", v));
    getGameShortName().ifPresent(v -> json.put("game_short_name", v));
    return json;
  }

  public String getId() {
    return id;
  }

  public User getFrom() {
    return from;
  }

  public Optional<ChatMessage> getMessage() {
    return Optional.ofNullable(message);
  }

  public Optional<String> getInlineMessageId() {
    return Optional.ofNullable(inlineMessageId);
  }

  public String getChatInstance() {
    return chatInstance;
  }

  public Optional<String> getData() {
    return Optional.ofNullable(data);
  }

  public Optional<String> getGameShortName() {
    return Optional.ofNullable(gameShortName);
  }
}
