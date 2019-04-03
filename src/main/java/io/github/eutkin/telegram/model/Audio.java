package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

@DataObject
public class Audio {

  private final String fileId;
  private final Integer duration;
  private final String performer;
  private final String title;
  private final String mimeType;
  private final Integer fileSize;
  private final PhotoSize thumb;

  public Audio(JsonObject json) {
    this.fileId = json.getString("file_id");
    this.duration = json.getInteger("duration");
    this.performer = json.getString("performer");
    this.title = json.getString("title");
    this.mimeType = json.getString("mime_type");
    this.fileSize = json.getInteger("file_size");
    this.thumb = json.containsKey("thumb") ? new PhotoSize(json.getJsonObject("thumb")) : null;
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("file_id", getFileId())
      .put("duration", getDuration());

    getPerformer().ifPresent(v -> json.put("performer", v));
    getTitle().ifPresent(v -> json.put("title", v));
    getMimeType().ifPresent(v -> json.put("mime_type", v));
    getFileSize().ifPresent(v -> json.put("file_size", v));
    getThumb().map(PhotoSize::toJson).ifPresent(v -> json.put("thumb", v));
    return json;
  }

  public String getFileId() {
    return fileId;
  }

  public Integer getDuration() {
    return duration;
  }

  public Optional<String> getPerformer() {
    return Optional.ofNullable(performer);
  }

  public Optional<String> getTitle() {
    return Optional.ofNullable(title);
  }

  public Optional<String> getMimeType() {
    return Optional.ofNullable(mimeType);
  }

  public Optional<Integer> getFileSize() {
    return Optional.ofNullable(fileSize);
  }

  public Optional<PhotoSize> getThumb() {
    return Optional.ofNullable(thumb);
  }
}
