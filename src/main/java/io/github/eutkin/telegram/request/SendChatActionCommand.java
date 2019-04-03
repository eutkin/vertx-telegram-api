package io.github.eutkin.telegram.request;
import io.github.eutkin.telegram.model.ChatAction;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class SendChatActionCommand extends SendCommand<SendChatActionCommand> {

  public SendChatActionCommand(JsonObject json) {
    super(json);
  }

  public SendChatActionCommand(Object chatId, ChatAction action) {
    super(chatId);
    put("action", action.name().toLowerCase());
  }
}
