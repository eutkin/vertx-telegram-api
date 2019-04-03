package io.github.eutkin.telegram.expection;

public class FileNotFoundException extends RuntimeException {

  private final String fileId;

  public FileNotFoundException(String fileId) {
    super("File with file-id <" + fileId + "> not found");
    this.fileId = fileId;
  }
}
