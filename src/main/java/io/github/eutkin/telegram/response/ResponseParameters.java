package io.github.eutkin.telegram.response;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ResponseParameters {

  private final Long migrateToChatId;
  private final Integer retryAfter;


  public ResponseParameters(JsonObject json) {
    this.migrateToChatId = json.getLong("migrate_to_chat_id");
    this.retryAfter = json.getInteger("retry_after");
  }

  public Long getMigrateToChatId() {
    return migrateToChatId;
  }

  public Integer getRetryAfter() {
    return retryAfter;
  }

  public JsonObject toJson() {
    return new JsonObject()
      .put("migrate_to_chat_id", getMigrateToChatId())
      .put("retry_after", getRetryAfter());
  }
}
