package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class ExportChatInviteLinkCommand implements Command {

  private final JsonObject json;

  public ExportChatInviteLinkCommand(JsonObject json) {
    this.json = json;
  }

  public ExportChatInviteLinkCommand(Object chatId) {
    this.json = new JsonObject().put("chat_id", chatId);
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
