package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.ContentTypes;
import io.github.eutkin.telegram.model.FileSourceType;
import io.github.eutkin.telegram.model.InputFile;
import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendDocumentCommand extends SendFileCommand<SendDocumentCommand> {


  public SendDocumentCommand(JsonObject json) {
    super(json);
  }

  public SendDocumentCommand(Object chatId, InputFile inputFile) {
    super(chatId, inputFile);
  }

  @Override
  public String getContentType() {
    return ContentTypes.DOC_MIME_TYPE;
  }

  @Override
  public String getDefaultFileName() {
    return ContentTypes.DOC_FILE_NAME;
  }

  @Override
  public String getFileParamName() {
    return "document";
  }



}
