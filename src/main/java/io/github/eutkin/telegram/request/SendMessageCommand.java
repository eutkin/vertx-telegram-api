package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendMessageCommand extends SendCommand<SendMessageCommand> {

  public SendMessageCommand(JsonObject json) {
    super(json);
  }

  public SendMessageCommand(Object chatId, String text) {
    super(chatId);
    put("text", text);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }

}
