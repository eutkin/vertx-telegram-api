package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class Chat {

  private final Long id;
  private final ChatType type;

  //Private
  private final String firstNme;
  private final String lastName;

  //Private and Channel
  private final String username;

  //Channel and Group
  private final String title;

  private final boolean allMembersAreAdministrators;

  private final ChatPhoto photo;
  private final String description;
  private final String inviteLink;
  private final ChatMessage pinnedMessage;
  private final String stickerSetName;
  private final boolean canSetStickerSet;

  public Chat(JsonObject json) {
    this.id = json.getLong("id");
    this.type = ChatType.valueOf(json.getString("type").toUpperCase());
    this.firstNme = json.getString("first_name");
    this.lastName = json.getString("last_name");
    this.username = json.getString("username");
    this.title = json.getString("title");
    this.allMembersAreAdministrators = json.getBoolean("all_members_are_administrators", false);
    this.photo = json.containsKey("photo") ? new ChatPhoto(json.getJsonObject("photo")) : null;
    this.description = json.getString("description");
    this.inviteLink = json.getString("invite_link");
    this.pinnedMessage = json.containsKey("pinned_message") ? new ChatMessage(json.getJsonObject("pinned_message")) : null;
    this.stickerSetName = json.getString("sticker_set_name");
    this.canSetStickerSet = json.getBoolean("can_set_sticker_set", false);

  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("id",getId())
      .put("type", getType().name().toLowerCase());
    getFirstNme().ifPresent(v -> json.put("first_name", v));
    getLastName().ifPresent(v -> json.put("last_name", v));
    getUsername().ifPresent(v -> json.put("username", v));
    getTitle().ifPresent(v -> json.put("title", v));
    getPhoto().map(ChatPhoto::toJson).ifPresent(v -> json.put("photo", v));
    getDescription().ifPresent(v -> json.put("description", v));
    getInviteLink().ifPresent(v -> json.put("invite_link", v));
    getPinnedMessage().map(ChatMessage::toJson).ifPresent(v -> json.put("pinned_message", v));
    getStickerSetName().ifPresent(v -> json.put("sticker_set_name", v));
    if (isAllMembersAreAdministrators()) {
      json.put("all_members_are_administrators", true);
    }
    if (isCanSetStickerSet()) {
      json.put("can_set_sticker_set", true);
    }

    return json;
  }

  public Long getId() {
    return id;
  }

  public ChatType getType() {
    return type;
  }

  public Optional<String> getFirstNme() {
    return Optional.ofNullable(firstNme);
  }

  public Optional<String> getLastName() {
    return Optional.ofNullable(lastName);
  }

  public Optional<String> getUsername() {
    return Optional.ofNullable(username);
  }

  public Optional<String> getTitle() {
    return Optional.ofNullable(title);
  }

  public Optional<ChatPhoto> getPhoto() {
    return Optional.ofNullable(photo);
  }

  public Optional<String> getDescription() {
    return Optional.ofNullable(description);
  }

  public Optional<String> getInviteLink() {
    return Optional.ofNullable(inviteLink);
  }

  public Optional<ChatMessage> getPinnedMessage() {
    return Optional.ofNullable(pinnedMessage);
  }

  public Optional<String> getStickerSetName() {
    return Optional.ofNullable(stickerSetName);
  }

  public boolean isAllMembersAreAdministrators() {
    return allMembersAreAdministrators;
  }

  public boolean isCanSetStickerSet() {
    return canSetStickerSet;
  }
}
