package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class ChatMember {

//  private final User user;
//  private final ChatMemberStatus status;
//
//  private final Integer untilDate;
//  private final Boolean canBeEdited;
//  private final Boolean canChangeInfo;
//  private final Boolean canPostMessages;
//  private final Boolean canEditMessages;
//  private final Boolean canDeleteMessages;
//  private final Boolean canInviteUsers;
//  private final Boolean canRestrictMembers;
//  private final Boolean canPinMessages;
//  private final Boolean canPromoteMembers;
//  private final Boolean canSendMessages;
//  private final Boolean canSendMediaMessages;
//  private final Boolean canSendOtherMessages;
//  private final Boolean canAddWebPagePreviews;


  public ChatMember(JsonObject json) {

  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    return json;
  }
}
