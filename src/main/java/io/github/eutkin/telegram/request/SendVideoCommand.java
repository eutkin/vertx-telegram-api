package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendVideoCommand extends SendFileCommand<SendVideoCommand> {


  public SendVideoCommand(JsonObject json) {
    super(json);
  }

  public SendVideoCommand(Object chatId, InputFile inputFile) {
    super(chatId, inputFile);
  }

  public SendVideoCommand duration(Integer duration) {
    return put("duration", duration);
  }

  public SendVideoCommand width(Integer width) {
    return put("width", width);
  }

  public SendVideoCommand height(Integer height) {
    return put("height", height);
  }

  @Override
  public String getContentType() {
    return ContentTypes.VIDEO_MIME_TYPE;
  }

  @Override
  public String getDefaultFileName() {
    return ContentTypes.VIDEO_FILE_NAME;
  }

  @Override
  public String getFileParamName() {
    return "video";
  }
}
