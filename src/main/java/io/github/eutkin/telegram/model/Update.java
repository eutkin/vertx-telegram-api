package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
// FIXME: 28.03.19 не все поля
public class Update {

  private final Integer updateId;
  private ChatMessage message;

  public Update(JsonObject json) {
    this.updateId = json.getInteger("update_id");
    this.message = json.containsKey("message") ? new ChatMessage(json.getJsonObject("message")) : null;
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("update_id", getUpdateId());
    getMessage().map(ChatMessage::toJson).ifPresent(v -> json.put("message", v));
    return json;
  }

  public Integer getUpdateId() {
    return updateId;
  }

  public Optional<ChatMessage> getMessage() {
    return Optional.ofNullable(message);
  }

  @Override
  public String toString() {
    return toJson().encodePrettily();
  }
}

