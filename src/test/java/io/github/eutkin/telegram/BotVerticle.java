package io.github.eutkin.telegram;

import io.github.eutkin.telegram.bot.TelegramOptions;
import io.github.eutkin.telegram.reactivex.bot.Binder;
import io.github.eutkin.telegram.reactivex.bot.Bot;
import io.reactivex.Completable;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.ProxyOptions;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.reactivex.core.AbstractVerticle;

public class BotVerticle extends AbstractVerticle {


  @Override
  public Completable rxStart() {
    TelegramOptions options = new TelegramOptions("611736478:AAGBIz25dwHo_qoWR8K9hKMhRra5WZJAN1I")
//      .api("http://localhost:8080/api/bot")
//      .fileApi("http://localhost:8080/fileApi/bot");
    .setWebClientOptions(new WebClientOptions()
      .setProxyOptions(new ProxyOptions().setHost("proxy.aeroport.tns").setPort(3128)));
    return Bot.rxCreate(vertx, options)
      .map(bot -> Binder.create(vertx).setAddress("bot").register(Bot.class, bot))
      .ignoreElement();
  }

}
