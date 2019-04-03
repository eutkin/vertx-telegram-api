package io.github.eutkin.telegram.request;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetUpdatesCommand implements Command {

  private int timeout = 0;
  private int limit = 100;
    
    public GetUpdatesCommand(JsonObject json) {
      this.timeout = json.getInteger("timeout", 0);
      this.limit = json.getInteger("limit", 100);
    }

  public GetUpdatesCommand() {
  }

  public JsonObject toJson() {
      return new JsonObject()
        .put("timeout", timeout)
        .put("limit", limit);
    }
}
