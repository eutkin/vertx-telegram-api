package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.net.URI;

@DataObject
public class InputFile {

  private final String fileSource;

  private final FileSourceType fileSourceType;

  public InputFile(JsonObject json) {
    this.fileSource = json.getString("source");
    this.fileSourceType = FileSourceType.valueOf(json.getString("type"));
  }

  public static InputFile fromFileId(String fileId) {
    return new InputFile(fileId, FileSourceType.FILE_ID);
  }

  public static InputFile fromURL(URI uri) {
    return new InputFile(uri.toString(), FileSourceType.FILE_EXTERNAL_URL);
  }

  public static InputFile fromFileSystem(String fileName) {
    return new InputFile(fileName, FileSourceType.FILE_PATH);
  }

  private InputFile(String fileSource, FileSourceType fileSourceType) {
    this.fileSource = fileSource;
    this.fileSourceType = fileSourceType;
  }

  public String getFileSource() {
    return fileSource;
  }

  public FileSourceType getFileSourceType() {
    return fileSourceType;
  }

  public JsonObject toJson() {
    return new JsonObject()
      .put("source", fileSource)
      .put("type", fileSourceType.name())
      ;
  }
}
