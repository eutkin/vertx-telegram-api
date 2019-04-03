package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class PhotoSize {

  public PhotoSize(JsonObject json) {
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    return json;
  }
}
