package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class Animation {

  private final String fileId;
  private final Integer width;
  private final Integer height;
  private final Integer duration;

  @Nullable
  private final PhotoSize thumb;
  @Nullable
  private final String fileName;
  @Nullable
  private final String mimeType;
  @Nullable
  private final Integer fileSize;

  public Animation(JsonObject json) {
    this.fileId = json.getString("file_id");
    this.width = json.getInteger("width");
    this.height = json.getInteger("height");
    this.duration = json.getInteger("duration");
    this.thumb = json.containsKey("thumb") ? new PhotoSize(json.getJsonObject("thumb")) : null;
    this.fileName = json.getString("file_name");
    this.mimeType = json.getString("mime_type");
    this.fileSize = json.getInteger("file_size");
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("file_id", getFileId())
      .put("width", getWidth())
      .put("height", getHeight())
      .put("duration", getDuration());
    getThumb().map(PhotoSize::toJson).ifPresent(v -> json.put("thumb", v));
    getFileName().ifPresent(v -> json.put("file_name", v));
    getMimeType().ifPresent(v -> json.put("mime_type", v));
    getFileSize().ifPresent(v -> json.put("file_size", v));
    return json;
  }

  public String getFileId() {
    return fileId;
  }

  public Integer getWidth() {
    return width;
  }

  public Integer getHeight() {
    return height;
  }

  public Integer getDuration() {
    return duration;
  }

  public Optional<PhotoSize> getThumb() {
    return Optional.ofNullable(thumb);
  }

  public Optional<String> getFileName() {
    return Optional.ofNullable(fileName);
  }

  public Optional<String> getMimeType() {
    return Optional.ofNullable(mimeType);
  }

  public Optional<Integer> getFileSize() {
    return Optional.ofNullable(fileSize);
  }
}
