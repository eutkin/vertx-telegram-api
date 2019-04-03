package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class SendMediaGroupCommand implements Command {
    
    public SendMediaGroupCommand(JsonObject json) {
      
    }
    
    @Override
    public JsonObject toJson() {
      JsonObject json = new JsonObject();
      return json;
    }
}
