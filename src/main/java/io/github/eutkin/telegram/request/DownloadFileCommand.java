package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class DownloadFileCommand extends GetFileCommand {

  private String fileName;

  public DownloadFileCommand(JsonObject json) {
    super(json);
    this.fileName = json.getString("fileName");
  }

  public DownloadFileCommand(String fileId) {
    super(fileId);
  }

  public DownloadFileCommand fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  public Optional<String> getFileName() {
    return Optional.ofNullable(fileName);
  }

  @Override
  public JsonObject toJson() {
    JsonObject json = super.toJson();
    getFileName().ifPresent(v -> json.put("fileName", v));
    return json;
  }

  @Override
  public String getTelegramMethod() {
    return "GetFile";
  }
}
