package io.github.eutkin.telegram;

import io.reactivex.Completable;
import io.vertx.core.http.HttpMethod;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.file.FileSystem;
import io.vertx.reactivex.core.http.HttpServer;
import io.vertx.reactivex.ext.web.Router;

public class TelegramStubVerticle extends AbstractVerticle {

  private HttpServer httpServer;

  @Override
  public Completable rxStart() {
    Router router = Router.router(vertx);
    FileSystem fs = vertx.fileSystem();

    router
      .routeWithRegex(HttpMethod.POST, "/api/bot.*/getMe")
      .handler(rc -> fs.rxReadFile("response/GetMe.json")
        .subscribe(buffer -> rc.response().setChunked(true).write(buffer).end())
      );
    return vertx
      .createHttpServer()
      .requestHandler(router)
      .rxListen(8080)
      .doOnSuccess(server -> this.httpServer = server)
      .ignoreElement();
  }

  @Override
  public Completable rxStop() {
    return httpServer.rxClose();
  }
}
