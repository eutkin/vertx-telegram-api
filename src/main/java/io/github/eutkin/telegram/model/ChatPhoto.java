package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class ChatPhoto {

    public ChatPhoto(JsonObject json) {

    }

    public JsonObject toJson() {
        JsonObject json = new JsonObject();
        return json;
    }
}
