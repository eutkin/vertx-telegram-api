package io.github.eutkin.telegram.reactivex.bot;

import io.github.eutkin.telegram.BotVerticle;
import io.github.eutkin.telegram.TelegramStubVerticle;
import io.github.eutkin.telegram.model.ChatMessage;
import io.github.eutkin.telegram.model.InputFile;
import io.github.eutkin.telegram.model.User;
import io.github.eutkin.telegram.request.*;
import io.reactivex.Single;
import io.reactivex.internal.functions.Functions;
import io.vertx.core.json.JsonObject;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.file.FileSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(VertxExtension.class)
class BotTest {


  private Bot bot;

  private Integer chatId = 349703984;

  private Map<String, JsonObject> models;


  @BeforeEach
  public void deploy(Vertx vertx, VertxTestContext testContext) {

    FileSystem fileSystem = vertx.fileSystem();
    fileSystem
      .rxReadDir("model")
      .flattenAsFlowable(Functions.identity())
      .flatMapSingle(fileName ->
        fileSystem.rxReadFile(fileName)
          .map(buf -> new SimpleEntry<>(normalize(fileName), buf.toJsonObject()))
      )
      .toList()
      .map(list -> list.stream().collect(toMap(Map.Entry::getKey, Map.Entry::getValue)))
      .doOnSuccess(models -> this.models = models)
      .flatMap(v -> vertx.rxDeployVerticle(TelegramStubVerticle.class.getCanonicalName()))
      .flatMap(id -> vertx.rxDeployVerticle(BotVerticle.class.getCanonicalName()))
      .doOnSuccess(id -> this.bot = Bot.createProxy(vertx))
      .subscribe(id -> testContext.completeNow(), testContext::failNow);
  }

  private String normalize(String fileName) {
    String[] paths = fileName.split(File.separator);
    return paths[paths.length - 1].replace(".json", "");
  }

  private void assertModel(Object model) {
    Class<?> modelClass = model.getClass();
    try {
      JsonObject actualJson = (JsonObject) modelClass.getMethod("toJson").invoke(model);
      JsonObject expectedJson = models.get(modelClass.getSimpleName());
      assertThat(actualJson).isEqualTo(expectedJson);
    } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private void assertSingle(Single<?> result, VertxTestContext testContext) {
    result.doOnSuccess(this::assertModel).subscribe(res -> testContext.completeNow(), testContext::failNow);
  }

  @Test
  void rxGetMe(Vertx vertx, VertxTestContext testContext) {
    Single<User> userSingle = bot.rxGetMe();
    Single<User> expectedUserSingle = vertx.fileSystem()
      .rxReadFile("model/User.json")
      .map(Buffer::toJsonObject)
      .map(User::new);

    expectedUserSingle.zipWith(userSingle, (expected, actual) -> assertThat(actual).isEqualTo(expected))
      .subscribe(v -> testContext.completeNow(), testContext::failNow);


  }

  @Test
  void rxSendMessage(Vertx vertx, VertxTestContext testContext) {
    Single<ChatMessage> messageSingle = vertx.fileSystem()
      .rxReadFile("command/SendMessage_1.json")
      .map(Buffer::toJsonObject)
      .map(SendMessageCommand::new)
      .flatMap(command -> bot.rxSendMessage(command));

    Single<ChatMessage> expectedMessageSingle = vertx.fileSystem().rxReadFile("model/Message.json")
      .map(Buffer::toJsonObject)
      .map(ChatMessage::new);

    expectedMessageSingle.zipWith(messageSingle, (expected, actual) -> assertThat(actual).isEqualTo(expected))
      .subscribe(v -> testContext.completeNow(), testContext::failNow);

  }

  @Test
  void rxForwardMessage(VertxTestContext testContext) {
  }

  @Test
  void rxSendPhoto(VertxTestContext testContext) {
  }

  @Test
  void rxSendAudio(VertxTestContext testContext) {
  }

  @Test
  void rxSendDocument(VertxTestContext testContext) {
    SendDocumentCommand command = new SendDocumentCommand(chatId, InputFile.fromFileSystem("/home/eutkin/Изображения/test.txt"))
      .disableNotification();
    bot.rxSendDocument(command)
      .flatMap(v -> bot.rxGetFile(new GetFileCommand("BQADAgADagQAAmdjEUlFmyWXZfrK9gI")))
      .subscribe(id -> testContext.completeNow(), testContext::failNow);

  }

  @Test
  void rxSendAnimation(VertxTestContext testContext) {
  }

  @Test
  void rxSendVoice(VertxTestContext testContext) {
  }

  @Test
  void rxSendVideo(VertxTestContext testContext) {
  }

  @Test
  void rxSendVideoNote(VertxTestContext testContext) {
  }

  @Test
  void rxSendMediaGroup(VertxTestContext testContext) {
  }

  @Test
  void rxSendLocation(VertxTestContext testContext) {
  }

  @Test
  void rxEditMessageLiveLocation(VertxTestContext testContext) {
  }

  @Test
  void rxStopMessageLiveLocationFromMessage(VertxTestContext testContext) {
  }

  @Test
  void rxStopMessageLiveLocationFromInline(VertxTestContext testContext) {
  }

  @Test
  void rxSendVenue(VertxTestContext testContext) {
  }

  @Test
  void rxSendContact(VertxTestContext testContext) {
  }

  @Test
  void rxSendChatAction(VertxTestContext testContext) {
  }

  @Test
  void rxAddStickerToSet(VertxTestContext testContext) {
  }

  @Test
  void rxAnswerCallbackQuery(VertxTestContext testContext) {
  }

  @Test
  void rxGetUserProfilePhotos(VertxTestContext testContext) {
  }

  @Test
  void rxGetFile(VertxTestContext testContext) {
  }

  @Test
  void rxKickChatMember(VertxTestContext testContext) {
  }

  @Test
  void rxUnbanChatMember(VertxTestContext testContext) {
  }

  @Test
  void rxRestrictChatMember(VertxTestContext testContext) {
  }

  @Test
  void rxPromoteChatMember(VertxTestContext testContext) {
  }

  @Test
  void rxExportChatInviteLink(VertxTestContext testContext) {
  }

  @Test
  void rxSetChatPhoto(VertxTestContext testContext) {
  }

  @Test
  void rxDeleteChatPhoto(VertxTestContext testContext) {
  }

  @Test
  void rxSetChatTitle(VertxTestContext testContext) {
  }

  @Test
  void rxSetChatDescription(VertxTestContext testContext) {
  }

  @Test
  void rxPinChatMessage(VertxTestContext testContext) {
  }

  @Test
  void rxUnpinChatMessage(VertxTestContext testContext) {
  }

  @Test
  void rxLeaveChat(VertxTestContext testContext) {
  }

  @Test
  void rxGetChat(VertxTestContext testContext) {
  }

  @Test
  void rxGetChatAdministrators(VertxTestContext testContext) {
  }

  @Test
  void rxGetChatMembersCount(VertxTestContext testContext) {
  }

  @Test
  void rxGetChatMember(VertxTestContext testContext) {
  }

  @Test
  void rxSetChatStickerSet(VertxTestContext testContext) {
  }

  @Test
  void rxDeleteChatStickerSet(VertxTestContext testContext) {
  }

  @Test
  void rxGetUpdates(VertxTestContext testContext) {
    bot.rxGetUpdates(new GetUpdatesCommand())
      .subscribe(res -> testContext.completeNow(), testContext::failNow);
  }

  @Test
  void download(VertxTestContext testContext) {
    bot.rxDownloadFile(new DownloadFileCommand("BQADAgADagQAAmdjEUlFmyWXZfrK9gI").fileName("/tmp/telegramXXX"))
      .doOnSuccess(System.out::println)
      .subscribe(fileName -> testContext.completeNow(), testContext::failNow);
  }
}
