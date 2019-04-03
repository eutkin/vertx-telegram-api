package io.github.eutkin.telegram.request;

public interface FileCommand extends Command {

  default boolean isMultipart() {
    return toJson().containsKey("filePath");
  }

  default String getFileName() {
    return toJson().containsKey("fileName") ? toJson().getString("fileName") : getDefaultFileName();
  }

  String getContentType();

  String getFileParamName();

  default String getFilePath() {
    return toJson().getString("filePath");
  }

  String getDefaultFileName();
}
