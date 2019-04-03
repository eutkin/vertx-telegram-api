package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class GetMeCommand implements Command {
    
    public GetMeCommand(JsonObject json) {
      
    }

  public GetMeCommand() {
  }

  public JsonObject toJson() {
      return new JsonObject();
    }
}
