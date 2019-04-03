package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.time.Duration;

@DataObject
public class AnswerCallbackQueryCommand implements Command {

  private final JsonObject json;

  public AnswerCallbackQueryCommand(JsonObject json) {
    this.json = json;
  }

  public AnswerCallbackQueryCommand(String  callbackQueryId ) {
    this.json = new JsonObject().put("callback_query_id", callbackQueryId);
  }

  public AnswerCallbackQueryCommand text(String value) {
    this.json.put("text", value);
    return this;
  }

  public AnswerCallbackQueryCommand showAlert() {
    this.json.put("show_alert", true);
    return this;
  }

  public AnswerCallbackQueryCommand url(String value) {
    this.json.put("url", value);
    return this;
  }

  public AnswerCallbackQueryCommand cacheTime(Duration value) {
    this.json.put("cache_time", value.getSeconds());
    return this;
  }


  public JsonObject toJson() {
    return json;
  }
}
