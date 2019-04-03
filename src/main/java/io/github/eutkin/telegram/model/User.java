package io.github.eutkin.telegram.model;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class User {

  private Integer id;

  private Boolean isBot;

  private String firstName;

  private String lastName;

  private String username;


  private String languageCode;

  public User(JsonObject json) {
    UserConverter.fromJson(json, this);
  }

  public Integer getId() {
    return id;
  }

  public User setId(Integer id) {
    this.id = id;
    return this;
  }

  public Boolean getBot() {
    return isBot;
  }

  public User setBot(Boolean bot) {
    isBot = bot;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public User setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public User setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public User setUsername(String username) {
    this.username = username;
    return this;
  }

  public String getLanguageCode() {
    return languageCode;
  }

  public User setLanguageCode(String languageCode) {
    this.languageCode = languageCode;
    return this;
  }

  public JsonObject toJson() {
    JsonObject json = new JsonObject();
    UserConverter.toJson(this, json);
    return json;
  }

}
