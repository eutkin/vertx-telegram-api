package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class AddStickerToSetCommand implements Command {
    
    public AddStickerToSetCommand(JsonObject json) {
      
    }
    
    public JsonObject toJson() {
      JsonObject json = new JsonObject();
      return json;
    }
}
