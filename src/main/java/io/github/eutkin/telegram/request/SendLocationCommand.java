package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class SendLocationCommand extends SendCommand<SendLocationCommand> {


  public SendLocationCommand(JsonObject json) {
    super(json);
  }

  public SendLocationCommand(Object chatId) {
    super(chatId);
  }

  public SendLocationCommand latitude(Double value) {
    return put("latitude", value);
  }

  public SendLocationCommand longitude(Double value) {
    return put("longitude", value);
  }

  public SendLocationCommand livePeriod(Integer value) {
    return put("live_period", value);
  }



}
