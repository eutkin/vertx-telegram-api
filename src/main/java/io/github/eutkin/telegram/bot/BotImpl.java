package io.github.eutkin.telegram.bot;

import io.github.eutkin.telegram.expection.ErrorResponseException;
import io.github.eutkin.telegram.expection.FileNotFoundException;
import io.github.eutkin.telegram.model.*;
import io.github.eutkin.telegram.request.*;
import io.reactivex.Single;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.ProxyOptions;
import io.vertx.ext.web.client.WebClientOptions;
import io.vertx.reactivex.SingleHelper;
import io.vertx.reactivex.core.buffer.Buffer;
import io.vertx.reactivex.core.file.FileSystem;
import io.vertx.reactivex.ext.web.client.HttpResponse;
import io.vertx.reactivex.ext.web.client.WebClient;
import io.vertx.reactivex.ext.web.codec.BodyCodec;
import io.vertx.reactivex.ext.web.multipart.MultipartForm;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class BotImpl implements Bot {

  private final WebClient webClient;

  private final FileSystem fileSystem;

  private final String url;

  private final String fileUrl;

  private final String token;

  private BotImpl(
    WebClient webClient,
    FileSystem fileSystem,
    TelegramOptions telegramOptions
  ) {
    this.webClient = webClient;
    this.fileSystem = fileSystem;
    this.url = telegramOptions.getApi();
    this.fileUrl = telegramOptions.getFileApi();
    this.token = telegramOptions.getToken();
  }

  public static Single<Bot> create(Vertx vertx, TelegramOptions telegramOptions) {
    io.vertx.reactivex.core.Vertx instance = io.vertx.reactivex.core.Vertx.newInstance(vertx);
    WebClient webClient = WebClient
      .create(instance, telegramOptions.getWebClientOptions());
    FileSystem fileSystem = instance.fileSystem();
    return Single.just(new BotImpl(webClient, fileSystem, telegramOptions));
  }


  private <T extends Command, R> Bot send(T command, Handler<AsyncResult<R>> handler, BodyCodec<R> bodyCodec) {
    webClient
      .postAbs(url + token + "/" + command.getTelegramMethod())
      .as(bodyCodec)
      .putHeader("content-type", "application/x-www-form-urlencoded")
      .rxSendForm(command.toMap())
      .map(HttpResponse::body)
      .subscribe(SingleHelper.toObserver(handler));
    return this;
  }

  private <T extends FileCommand, R> Bot sendFile(
    T command,
    Handler<AsyncResult<R>> handler,
    BodyCodec<R> bodyCodec
  ) {
    if (!command.isMultipart()) {
      return send(command, handler, bodyCodec);
    }
    MultipartForm multipartForm = MultipartForm.create();
    multipartForm.binaryFileUpload(command.getFileParamName(), command.getFileName(), command.getFilePath(), command.getContentType());
    command.toMap().entries().forEach(e -> multipartForm.attribute(e.getKey(), e.getValue()));

    webClient
      .postAbs(url + token + "/" + command.getTelegramMethod())
      .as(bodyCodec)
      .rxSendMultipartForm(multipartForm)
      .map(HttpResponse::body)
      .subscribe(SingleHelper.toObserver(handler));
    return this;

  }


  @Override
  public Bot getMe(Handler<AsyncResult<User>> handler) {
    return send(new GetMeCommand(), handler, BodyCodecs.dataObject(User.class));
  }

  @Override
  public Bot sendMessage(SendMessageCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot forwardMessage(ForwardMessageCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendPhoto(SendPhotoCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendAudio(SendAudioCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendDocument(SendDocumentCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendAnimation(SendAnimationCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendVoice(SendVoiceCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendVideo(SendVideoCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendVideoNote(SendVideoNoteCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return sendFile(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

//  @Override
//  public Bot sendMediaGroup(SendMediaGroupCommand command, Handler<AsyncResult<List<ChatMessage>>> handler) {
//    Single.<List<ChatMessage>>error(new UnsupportedOperationException()).subscribe(SingleHelper.toObserver(handler));
//    return this;
////    return send(command, handler, BodyCodecs.dataObjects(ChatMessage.class));
//  }

  @Override
  public Bot sendLocation(SendLocationCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot editMessageLiveLocation(EditMessageLiveLocationCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot stopMessageLiveLocationFromMessage(StopMessageLiveLocationMessageCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot stopMessageLiveLocationFromInline(StopMessageLiveLocationInlineCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot sendVenue(SendVenueCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendContact(SendContactCommand command, Handler<AsyncResult<ChatMessage>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMessage.class));
  }

  @Override
  public Bot sendChatAction(SendChatActionCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot addStickerToSet(AddStickerToSetCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot answerCallbackQuery(AnswerCallbackQueryCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot getUserProfilePhotos(GetUserProfilePhotosCommand command, Handler<AsyncResult<UserProfilePhotos>> handler) {
    return send(command, handler, BodyCodecs.dataObject(UserProfilePhotos.class));
  }

  @Override
  public Bot getFile(GetFileCommand command, Handler<AsyncResult<File>> handler) {
    return send(command, handler, BodyCodecs.dataObject(File.class));
  }

  @Override
  public Bot kickChatMember(KickChatMemberCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot unbanChatMember(UnbanChatMemberCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot restrictChatMember(RestrictChatMemberCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot promoteChatMember(PromoteChatMemberCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot exportChatInviteLink(ExportChatInviteLinkCommand command, Handler<AsyncResult<String>> handler) {
    return send(command, handler, BodyCodecs.string());
  }

  @Override
  public Bot setChatPhoto(SetChatPhotoCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot deleteChatPhoto(DeleteChatPhotoCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot setChatTitle(SetChatTitleCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot setChatDescription(SetChatDescriptionCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot pinChatMessage(PinChatMessageCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot unpinChatMessage(UnpinChatMessageCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot leaveChat(LeaveChatCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot getChat(GetChatCommand command, Handler<AsyncResult<Chat>> handler) {
    return send(command, handler, BodyCodecs.dataObject(Chat.class));
  }

  @Override
  public Bot getChatAdministrators(GetChatAdministratorsCommand command, Handler<AsyncResult<List<ChatMember>>> handler) {
    return send(command, handler, BodyCodecs.dataObjects(ChatMember.class));
  }

  @Override
  public Bot getChatMembersCount(GetChatMembersCountCommand command, Handler<AsyncResult<Integer>> handler) {
    return send(command, handler, BodyCodecs.integer());
  }

  @Override
  public Bot getChatMember(GetChatMemberCommand command, Handler<AsyncResult<ChatMember>> handler) {
    return send(command, handler, BodyCodecs.dataObject(ChatMember.class));
  }

  @Override
  public Bot setChatStickerSet(SetChatStickerSetCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot deleteChatStickerSet(DeleteChatStickerSetCommand command, Handler<AsyncResult<Void>> handler) {
    return send(command, handler, BodyCodecs.forVoid());
  }

  @Override
  public Bot getUpdates(GetUpdatesCommand command, Handler<AsyncResult<List<Update>>> handler) {
    return send(command, handler, BodyCodecs.dataObjects(Update.class));
  }

  @Override
  public Bot downloadFile(DownloadFileCommand command, Handler<AsyncResult<String>> handler) {
    SingleHelper.<File>toSingle(h -> getFile(command, h))
      .map(file -> file.getFilePath().orElseThrow(() -> new FileNotFoundException(file.getFileId())))
      .flatMap(filePath -> webClient.getAbs(fileUrl + token + "/" + filePath)
        .rxSend()
        .map(HttpResponse::body)
        .flatMap(buffer -> {
            Single<String> fileNameSingle;
            if (command.getFileName().isPresent()) {
              fileNameSingle = Single.just(command.getFileName().get());
            } else {
              fileNameSingle = fileSystem.rxCreateTempFile("telegram", command.getFileId());
            }
            return fileNameSingle.flatMap(fileName -> fileSystem.rxWriteFile(fileName, buffer).andThen(Single.just(fileName)));
          }
        ))
      .subscribe(SingleHelper.toObserver(handler));
    return this;
  }

  @Override
  public void close(Handler<AsyncResult<Void>> completionHandler) {
    webClient.close();
    completionHandler.handle(Future.succeededFuture());
  }

  private static class BodyCodecs {


    static <T> BodyCodec<T> dataObject(Class<T> clazz) {
      return BodyCodec.create(buffer -> {
        JsonObject json = getEntries(buffer);
        JsonObject result = json.getJsonObject("result");
        return createDataObject(clazz, result);
      });
    }

    static <T> BodyCodec<List<T>> dataObjects(Class<T> clazz) {
      return BodyCodec.create(buffer -> {
        JsonObject json = getEntries(buffer);
        JsonArray result = json.getJsonArray("result");
        List<T> list = new ArrayList<>(result.size());
        for (int i = 0; i < result.size(); i++) {
          T dataObject = createDataObject(clazz, result.getJsonObject(i));
          list.add(dataObject);
        }
        return list;
      });
    }

    static BodyCodec<Void> forVoid() {
      return BodyCodec.create(buffer -> {
        JsonObject json = getEntries(buffer);
        Boolean result = json.getBoolean("result", false);
        if (result) {
          return null;
        }
        throw new ErrorResponseException(json);
      });
    }

    public static BodyCodec<String> string() {
      return BodyCodec.create(buffer -> {
        JsonObject json = getEntries(buffer);
        return json.getString("result");
      });
    }

    public static BodyCodec<Integer> integer() {
      return BodyCodec.create(buffer -> {
        JsonObject json = getEntries(buffer);
        return json.getInteger("result");
      });
    }

    private static <T> T createDataObject(Class<T> clazz, JsonObject result) {
      try {
        return clazz.getConstructor(JsonObject.class).newInstance(result);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }

    private static JsonObject getEntries(Buffer buffer) {
      JsonObject json = buffer.toJsonObject();
      System.out.println(json.encodePrettily());
      Boolean ok = json.getBoolean("ok");
      if (!ok) {
        throw new ErrorResponseException(json);
      }
      return json;
    }
  }
}
