package io.github.eutkin.telegram;

import io.reactivex.Completable;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.ext.web.client.WebClient;

import java.net.URL;

public class TelegramApi extends AbstractVerticle {

  WebClient webClient;

  String url = "https://api.telegram.org/bot";

  String token = "token";


  @Override
  public Completable rxStart() {
    webClient = WebClient.wrap(vertx.createHttpClient());

//    webClient.post(String.join("/", url, token, ))
    return Completable.complete();
  }

  @Override
  public void stop() throws Exception {
    webClient.close();
  }
}
