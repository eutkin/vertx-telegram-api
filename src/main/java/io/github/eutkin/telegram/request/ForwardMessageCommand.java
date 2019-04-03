package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class ForwardMessageCommand implements Command {
    
    public ForwardMessageCommand(JsonObject json) {
      
    }
    
    public JsonObject toJson() {
      JsonObject json = new JsonObject();
      return json;
    }
}
