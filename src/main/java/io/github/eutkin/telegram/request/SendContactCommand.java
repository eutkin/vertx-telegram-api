package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class SendContactCommand extends SendCommand<SendContactCommand> {


  public SendContactCommand(JsonObject json) {
    super(json);
  }

  public SendContactCommand(Object chatId, String phoneNumber, String firstName) {
    super(chatId);
    put("phone_number", phoneNumber);
    put("first_name", firstName);
  }

  public SendContactCommand lastName(String value) {
    return put("last_name", value);
  }

  public SendContactCommand vcard(String value) {
    return put("vcard", value);
  }

}
