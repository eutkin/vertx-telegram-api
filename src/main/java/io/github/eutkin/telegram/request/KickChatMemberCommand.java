package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.time.Duration;
import java.util.Optional;

@DataObject
public class KickChatMemberCommand implements Command {

  private final JsonObject json;
    
    public KickChatMemberCommand(JsonObject json) {
      this.json = json;
    }


    public KickChatMemberCommand(Object chatId, Integer userId) {
      this.json = new JsonObject().put("chat_id", chatId).put("user_id", userId);
    }

    public KickChatMemberCommand untilDate(Integer value) {
      this.json.put("until_date", value);
      return this;
    }

    @Override
    public JsonObject toJson() {
      return json;
    }
}
