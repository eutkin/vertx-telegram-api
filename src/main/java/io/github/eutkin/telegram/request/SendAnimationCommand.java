package io.github.eutkin.telegram.request;
import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendAnimationCommand extends SendFileCommand<SendAnimationCommand> {


  public SendAnimationCommand(JsonObject json) {
    super(json);
  }

  public SendAnimationCommand(Object chatId, InputFile inputFile) {
    super(chatId, inputFile);
  }

  public SendAnimationCommand duration(Integer duration) {
    return put("duration", duration);
  }

  public SendAnimationCommand width(Integer width) {
    return put("width", width);
  }

  public SendAnimationCommand height(Integer height) {
    return put("height", height);
  }

  @Override
  public String getContentType() {
    return ContentTypes.GIF_MIME_TYPE;
  }

  @Override
  public String getDefaultFileName() {
    return ContentTypes.GIF_FILE_NAME;
  }

  @Override
  public String getFileParamName() {
    return "animation";
  }
}
