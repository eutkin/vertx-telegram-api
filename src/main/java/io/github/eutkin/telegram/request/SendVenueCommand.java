package io.github.eutkin.telegram.request;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;

@DataObject
public class SendVenueCommand extends SendCommand<SendVenueCommand> {

  public SendVenueCommand(JsonObject json) {
    super(json);
  }

  public static SendVenueCommand from(Integer chatId, Double latitude, Double longitude, String title, String address) {
    return new SendVenueCommand(chatId, latitude, longitude, title, address);
  }

  public static SendVenueCommand from(String chatId, Double latitude, Double longitude, String title, String address) {
    return new SendVenueCommand(chatId, latitude, longitude, title, address);
  }

  private SendVenueCommand(Object chatId, Double latitude, Double longitude, String title, String address) {
    super(chatId);
    put("latitude", latitude);
    put("longitude", longitude);
    put("title", title);
    put("address", address);
  }

  public SendVenueCommand foursquareId(String value) {
    return put("foursquare_id", value);
  }

  public SendVenueCommand foursquareType(String value) {
    return put("foursquare_type", value);
  }
}
