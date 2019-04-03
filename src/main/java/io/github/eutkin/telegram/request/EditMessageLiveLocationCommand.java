package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class EditMessageLiveLocationCommand extends SendCommand<EditMessageLiveLocationCommand> {


  public EditMessageLiveLocationCommand(JsonObject json) {
    super(json);
  }

  public EditMessageLiveLocationCommand(Object chatId) {
    super(chatId);
  }

  public EditMessageLiveLocationCommand messageId(Integer value) {
    return put("message_id", value);
  }

  public EditMessageLiveLocationCommand inlineMessageId(String  value) {
    return put("inline_message_id", value);
  }

  public EditMessageLiveLocationCommand latitude(Double value) {
    return put("latitude", value);
  }

  public EditMessageLiveLocationCommand longitude(Double value) {
    return put("longitude", value);
  }
}
