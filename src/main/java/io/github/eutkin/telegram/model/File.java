package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class File {

  private final String fileId;
  private final Integer fileSize;
  private final String filePath;

  public File(JsonObject json) {
    this.fileId = json.getString("file_id");
    this.fileSize = json.getInteger("file_size");
    this.filePath = json.getString("file_path");
  }

  public String getFileId() {
    return fileId;
  }

  public Optional<Integer> getFileSize() {
    return Optional.ofNullable(fileSize);
  }

  public Optional<String> getFilePath() {
    return Optional.ofNullable(filePath);
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("file_id", getFileId());
    getFilePath().ifPresent(v -> json.put("file_path", v));
    getFileSize().ifPresent(v -> json.put("file_size", v));
    return json;
  }
}
