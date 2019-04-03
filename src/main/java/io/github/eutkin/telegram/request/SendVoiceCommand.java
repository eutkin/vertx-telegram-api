package io.github.eutkin.telegram.request;
import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendVoiceCommand extends SendFileCommand<SendVoiceCommand> {


  public SendVoiceCommand(JsonObject json) {
    super(json);
  }

  public SendVoiceCommand(Object chatId, InputFile inputFile) {
    super(chatId, inputFile);
  }

  @Override
  public String getContentType() {
    return ContentTypes.VOICE_MIME_TYPE;
  }

  @Override
  public String getDefaultFileName() {
    return ContentTypes.VOICE_FILE_NAME;
  }

  @Override
  public String getFileParamName() {
    return "voice";
  }
}
