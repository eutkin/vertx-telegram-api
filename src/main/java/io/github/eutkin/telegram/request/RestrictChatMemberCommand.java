package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class RestrictChatMemberCommand implements Command {

  private final JsonObject json;

  public RestrictChatMemberCommand(JsonObject json) {
    this.json = json;
  }

  public RestrictChatMemberCommand(Object chatId, Integer userId) {
    this.json = new JsonObject().put("chat_id", chatId).put("user_id", userId);
  }

  public RestrictChatMemberCommand untilDate(Integer value) {
    this.json.put("until_date", value);
    return this;
  }

  public RestrictChatMemberCommand canSendMessages() {
    this.json.put("can_send_messages", true);
    return this;
  }

  public RestrictChatMemberCommand canSendMediaMessages() {
    this.canSendMessages();
    this.json.put("can_send_media_messages", true);
    return this;
  }

  public RestrictChatMemberCommand canSendOtherMessages() {
    this.canSendMediaMessages();
    this.json.put("can_send_other_messages", true);
    return this;
  }

  public RestrictChatMemberCommand canAddWebPagePreviews() {
    this.canSendMediaMessages();
    this.json.put("can_add_web_page_previews", true);
    return this;
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
