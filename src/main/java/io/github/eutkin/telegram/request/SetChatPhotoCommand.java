package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.MultiMap;

// FIXME: 01.04.19
@DataObject
public class SetChatPhotoCommand implements FileCommand {

  private JsonObject json;

  public SetChatPhotoCommand(JsonObject json) {
    this.json = json;
  }

  public SetChatPhotoCommand(Object chatId, InputFile file) {
    this.json = new JsonObject().put("chat_id", chatId);
    if (file.getFileSourceType() == FileSourceType.FILE_PATH) {
      this.json.put("filePath", file.getFileSource());
    } else {
      this.json.put(getFileParamName(), file.getFileSource());
    }
  }

  @Override
  public JsonObject toJson() {
    return json;
  }

  @Override
  public String getContentType() {
    return ContentTypes.PHOTO_MIME_TYPE;
  }

  @Override
  public String getFileParamName() {
    return "photo";
  }

  @Override
  public String getDefaultFileName() {
    return ContentTypes.PHOTO_FILE_NAME;
  }
}
