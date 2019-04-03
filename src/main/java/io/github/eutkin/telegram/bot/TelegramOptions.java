package io.github.eutkin.telegram.bot;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.client.WebClientOptions;

@DataObject(generateConverter = true)
public class TelegramOptions {

  private static final String DEFAULT_API = "https://api.telegram.org/bot";
  private static final String DEFAULT_FILE_API = "https://api.telegram.org/file/bot";

  private String token;

  private String api = DEFAULT_API;

  private String fileApi = DEFAULT_FILE_API;

  private WebClientOptions webClientOptions = new WebClientOptions();

  public TelegramOptions(JsonObject json) {
   TelegramOptionsConverter.fromJson(json, this);
  }

  public TelegramOptions(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  public TelegramOptions setToken(String token) {
    this.token = token;
    return this;
  }

  public String getApi() {
    return api;
  }

  public TelegramOptions setApi(String api) {
    this.api = api;
    return this;
  }

  public String getFileApi() {
    return fileApi;
  }

  public TelegramOptions setFileApi(String fileApi) {
    this.fileApi = fileApi;
    return this;
  }

  public WebClientOptions getWebClientOptions() {
    return webClientOptions;
  }

  public TelegramOptions setWebClientOptions(WebClientOptions webClientOptions) {
    this.webClientOptions = webClientOptions;
    return this;
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    TelegramOptionsConverter.toJson(this, json);
    return json;
  }
}
