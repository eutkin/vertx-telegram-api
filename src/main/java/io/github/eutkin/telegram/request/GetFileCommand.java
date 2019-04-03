package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class GetFileCommand implements Command {

  private final String fileId;

  public GetFileCommand(JsonObject json) {
    this.fileId = json.getString("file_id");
  }


  public GetFileCommand(String fileId) {
    this.fileId = fileId;
  }

  @Override
  public JsonObject toJson() {
    return new JsonObject().put("file_id", fileId);
  }

  public String getFileId() {
    return fileId;
  }
}
