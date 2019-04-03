package io.github.eutkin.telegram.bot;

import io.github.eutkin.telegram.model.*;
import io.github.eutkin.telegram.request.*;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyClose;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Closeable;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.file.AsyncFile;
import io.vertx.reactivex.SingleHelper;
import io.vertx.serviceproxy.ServiceProxyBuilder;

import java.util.List;

@VertxGen
@ProxyGen
public interface Bot extends Closeable {

  static void create(Vertx vertx, TelegramOptions options, Handler<AsyncResult<Bot>> completionHandler) {
    BotImpl.create(vertx, options).subscribe(SingleHelper.toObserver(completionHandler));
  }

  static Bot createProxy(Vertx vertx) {
    return new ServiceProxyBuilder(vertx).setAddress("bot").build(Bot.class);
  }

  @Fluent
  Bot getMe(Handler<AsyncResult<User>> handler);


  @Fluent
  Bot sendMessage(SendMessageCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot forwardMessage(ForwardMessageCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendPhoto(SendPhotoCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendAudio(SendAudioCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendDocument(SendDocumentCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendAnimation(SendAnimationCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendVoice(SendVoiceCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendVideo(SendVideoCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendVideoNote(SendVideoNoteCommand command, Handler<AsyncResult<ChatMessage>> handler);

//  @Fluent
//  Bot sendMediaGroup(SendMediaGroupCommand command, Handler<AsyncResult<List<ChatMessage>>> handler);

  @Fluent
  Bot sendLocation(SendLocationCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot editMessageLiveLocation(EditMessageLiveLocationCommand command, Handler<AsyncResult<ChatMessage>> handler);

  /**
   * <a href="https://core.telegram.org/bots/api#stopmessagelivelocation">Api Docs</a>
   */
  @Fluent
  Bot stopMessageLiveLocationFromMessage(StopMessageLiveLocationMessageCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot stopMessageLiveLocationFromInline(StopMessageLiveLocationInlineCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot sendVenue(SendVenueCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendContact(SendContactCommand command, Handler<AsyncResult<ChatMessage>> handler);

  @Fluent
  Bot sendChatAction(SendChatActionCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot addStickerToSet(AddStickerToSetCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot answerCallbackQuery(AnswerCallbackQueryCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot getUserProfilePhotos(GetUserProfilePhotosCommand command, Handler<AsyncResult<UserProfilePhotos>> handler);

  @Fluent
  Bot getFile(GetFileCommand command, Handler<AsyncResult<File>> handler);

  @Fluent
  Bot kickChatMember(KickChatMemberCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot unbanChatMember(UnbanChatMemberCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot restrictChatMember(RestrictChatMemberCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot promoteChatMember(PromoteChatMemberCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot exportChatInviteLink(ExportChatInviteLinkCommand command, Handler<AsyncResult<String>> handler);

  @Fluent
  Bot setChatPhoto(SetChatPhotoCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot deleteChatPhoto(DeleteChatPhotoCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot setChatTitle(SetChatTitleCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot setChatDescription(SetChatDescriptionCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot pinChatMessage(PinChatMessageCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot unpinChatMessage(UnpinChatMessageCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot leaveChat(LeaveChatCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot getChat(GetChatCommand command, Handler<AsyncResult<Chat>> handler);

  @Fluent
  Bot getChatAdministrators(GetChatAdministratorsCommand command, Handler<AsyncResult<List<ChatMember>>> handler);

  @Fluent
  Bot getChatMembersCount(GetChatMembersCountCommand command, Handler<AsyncResult<Integer>> handler);

  @Fluent
  Bot getChatMember(GetChatMemberCommand command, Handler<AsyncResult<ChatMember>> handler);

  @Fluent
  Bot setChatStickerSet(SetChatStickerSetCommand command, Handler<AsyncResult<Void>> handler);

  @Fluent
  Bot deleteChatStickerSet(DeleteChatStickerSetCommand command, Handler<AsyncResult<Void>> handler);


  @Fluent
  Bot getUpdates(GetUpdatesCommand command, Handler<AsyncResult<List<Update>>> handler);

  @Fluent
  Bot downloadFile(DownloadFileCommand command, Handler<AsyncResult<String>> handler);

  @ProxyClose
  @Override
  void close(Handler<AsyncResult<Void>> completionHandler);
}
