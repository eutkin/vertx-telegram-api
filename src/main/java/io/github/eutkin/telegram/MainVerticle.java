package io.github.eutkin.telegram;

import io.github.eutkin.telegram.reactivex.bot.Bot;
import io.reactivex.Completable;
import io.vertx.core.http.HttpMethod;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.file.FileSystem;
import io.vertx.reactivex.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

  private Bot bot;

  @Override
  public Completable rxStart() {

    Router router = Router.router(vertx);
    FileSystem fs = vertx.fileSystem();

    router.routeWithRegex(HttpMethod.POST, "/api/bot.*/GetMe").handler(rc -> fs.rxReadFile("response/GetMe.json").subscribe(buffer -> rc.response().write(buffer).end()));
    return vertx
      .createHttpServer()
      .requestHandler(router)
      .rxListen(8080)
      .ignoreElement();
  }

  public void setBot(Bot bot) {
    this.bot = bot;
  }
}

