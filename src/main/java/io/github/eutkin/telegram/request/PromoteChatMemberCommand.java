package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class PromoteChatMemberCommand implements Command {

  private final JsonObject json;

  public PromoteChatMemberCommand(JsonObject json) {
    this.json = json;
  }

  public PromoteChatMemberCommand(Object chatId, Integer userId) {
    this.json = new JsonObject().put("chat_id", chatId).put("user_id", userId);
  }

  public PromoteChatMemberCommand canChangeInfo() {
    this.json.put("can_change_info", true);
    return this;
  }

  public PromoteChatMemberCommand canPostMessages() {
    this.json.put("can_post_messages", true);
    return this;
  }

  public PromoteChatMemberCommand canEditMessages() {
    this.json.put("can_edit_messages", true);
    return this;
  }
  public PromoteChatMemberCommand canDeleteMessages() {
    this.json.put("can_delete_messages", true);
    return this;
  }
  public PromoteChatMemberCommand canInviteUsers() {
    this.json.put("can_invite_users", true);
    return this;
  }
  public PromoteChatMemberCommand canRestrictMembers() {
    this.json.put("can_restrict_members", true);
    return this;
  }
  public PromoteChatMemberCommand canPinMessages() {
    this.json.put("can_pin_messages", true);
    return this;
  }
  public PromoteChatMemberCommand canPromoteMembers() {
    this.json.put("can_promote_members", true);
    return this;
  }


  @Override
  public JsonObject toJson() {
    return json;
  }
}
