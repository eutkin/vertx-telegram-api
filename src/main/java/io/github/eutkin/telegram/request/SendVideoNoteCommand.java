package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendVideoNoteCommand extends SendFileCommand<SendVideoNoteCommand> {


  public SendVideoNoteCommand(JsonObject json) {
    super(json);
  }

  public SendVideoNoteCommand(Object chatId, InputFile inputFile) {
    super(chatId, inputFile);
  }

  public SendVideoNoteCommand duration(Integer duration) {
    return put("duration", duration);
  }

  public SendVideoNoteCommand length(Integer length) {
    return put("length", length);
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
    return "video_note";
  }
}
