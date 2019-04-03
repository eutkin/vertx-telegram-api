package io.github.eutkin.telegram.expection;

import io.github.eutkin.telegram.response.ResponseParameters;
import io.vertx.core.json.JsonObject;

import java.util.Optional;

public class ErrorResponseException extends RuntimeException {

  private final Integer errorCode;
  private final String description;
  private final ResponseParameters parameters;

  public ErrorResponseException(JsonObject json) {
    this.errorCode = json.getInteger("error_code");
    this.description = json.getString("description");
    this.parameters = json.containsKey("parameters") ? new ResponseParameters(json.getJsonObject("parameters")) : null;
  }

  public Optional<ResponseParameters> getParameters() {
    return Optional.ofNullable(parameters);
  }

  public Integer getErrorCode() {
    return errorCode;
  }

  public String getDescription() {
    return description;
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject()
      .put("error_code", getErrorCode())
      .put("description", getDescription());
    getParameters().map(ResponseParameters::toJson).ifPresent(v -> json.put("parameters", v));
    return json;
  }
}
