package io.github.eutkin.telegram.request;

import io.github.eutkin.telegram.model.InputFile;
import io.github.eutkin.telegram.model.ParseMode;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.MultiMap;

import static io.github.eutkin.telegram.model.FileSourceType.FILE_PATH;

public abstract class SendFileCommand<C extends SendFileCommand> extends SendCommand<C> implements FileCommand {


  public SendFileCommand(JsonObject json) {
    super(json);
  }

  public SendFileCommand(Object chatId, InputFile file) {
    super(chatId);
    if (file.getFileSourceType() == FILE_PATH) {
      put("filePath", file.getFileSource());
    } else {
      put(getFileParamName(), file.getFileSource());
    }
  }

  public C caption(String caption) {
    return put("caption", caption);
  }

  public C parseMode(ParseMode parseMode) {
    return put("parse_mode", parseMode.name());
  }

  public abstract String getContentType();

  public abstract String getDefaultFileName();

  public abstract String getFileParamName();

  @Override
  public MultiMap toMap() {
    MultiMap multiMap = super.toMap();
    multiMap.remove("filePath");
    multiMap.remove("fileName");
    return multiMap;
  }

  @Override
  protected C put(String key, Object value) {
    return (C) super.put(key, value);
  }
}
