package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetUserProfilePhotosCommand implements Command {

  private final JsonObject json;

  public GetUserProfilePhotosCommand(JsonObject json) {
    this.json = json;
  }

  public GetUserProfilePhotosCommand(Integer userId) {
    this.json = new JsonObject().put("user_id", userId);
  }

  public GetUserProfilePhotosCommand offset(Integer value) {
    this.json.put("offset", value);
    return this;
  }

  public GetUserProfilePhotosCommand limit(Integer value) {
    this.json.put("limit", value);
    return this;
  }

  @Override
  public JsonObject toJson() {
    return json;
  }
}
