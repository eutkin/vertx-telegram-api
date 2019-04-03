package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendAudioCommand extends SendFileCommand {


  public SendAudioCommand(JsonObject json) {
    super(json);
  }

  public SendAudioCommand(Object chatId, InputFile inputFile) {
    super(chatId, inputFile);
  }

  public SendAudioCommand duration(int duration) {
    put("duration", duration);
    return this;
  }

  public SendAudioCommand performer(String performer) {
    put("performer", performer);
    return this;
  }

  public SendAudioCommand title(String title) {
    put("title", title);
    return this;
  }

  @Override
  public String getContentType() {
    return ContentTypes.AUDIO_MIME_TYPE;
  }

  @Override
  public String getDefaultFileName() {
    return ContentTypes.AUDIO_FILE_NAME;
  }

  @Override
  public String getFileParamName() {
    return "audio";
  }


}
