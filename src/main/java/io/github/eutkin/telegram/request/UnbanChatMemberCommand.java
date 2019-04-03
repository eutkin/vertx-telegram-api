package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class UnbanChatMemberCommand implements Command {

  private final JsonObject json;
    
    public UnbanChatMemberCommand(JsonObject json) {
      this.json = json;
    }

    public UnbanChatMemberCommand(Object chatId, Integer userId) {
      this.json = new JsonObject().put("chat_id", chatId).put("user_id", userId);
    }
    
    @Override
    public JsonObject toJson() {
      return json;
    }
}
