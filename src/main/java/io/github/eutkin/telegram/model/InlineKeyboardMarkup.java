package io.github.eutkin.telegram.model;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class 	InlineKeyboardMarkup {
    
    public 	InlineKeyboardMarkup (JsonObject json) {
      
    }
    
    public JsonObject toJson() {
      JsonObject json = new JsonObject();
      return json;
    }
}
