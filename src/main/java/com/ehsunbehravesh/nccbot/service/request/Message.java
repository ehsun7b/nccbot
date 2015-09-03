package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class Message {

  @XmlElement(name = "message_id")
  private int messageId;

  private User from;

  private int date;

  private User chat;

  @XmlElement(name = "forward_from")
  private User forwardFrom;

  @XmlElement(name = "forward_date")
  private Integer forwardDate;

  @XmlElement(name = "reply_to_message")
  private Message replyToMessage;

  private String text;

  private Audio audio;

  private Document document;

  private PhotoSize[] photo;

  private Sticker sticker;

  private Video video;

  private Contact contact;

  private Location location;

  @XmlElement(name = "new_chat_participant")
  private User newChatParticipant;

  @XmlElement(name = "left_chat_participant")
  private User leftChatParticipant;

  @XmlElement(name = "new_chat_title")
  private String newChatTitle;

  @XmlElement(name = "new_chat_photo")
  private PhotoSize[] newChatPhoto;

  @XmlElement(name = "delete_chat_photo")
  private Boolean deleteChatPhoto;

  @XmlElement(name = "group_chat_created")
  private Boolean groupChatCreated;

  public int getMessageId() {
    return messageId;
  }

  public void setMessageId(int messageId) {
    this.messageId = messageId;
  }

  public User getFrom() {
    return from;
  }

  public void setFrom(User from) {
    this.from = from;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }

  public User getChat() {
    return chat;
  }

  public void setChat(User chat) {
    this.chat = chat;
  }

  public User getForwardFrom() {
    return forwardFrom;
  }

  public void setForwardFrom(User forwardFrom) {
    this.forwardFrom = forwardFrom;
  }

  public Integer getForwardDate() {
    return forwardDate;
  }

  public void setForwardDate(Integer forwardDate) {
    this.forwardDate = forwardDate;
  }

  public Message getReplyToMessage() {
    return replyToMessage;
  }

  public void setReplyToMessage(Message replyToMessage) {
    this.replyToMessage = replyToMessage;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Audio getAudio() {
    return audio;
  }

  public void setAudio(Audio audio) {
    this.audio = audio;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }

  public PhotoSize[] getPhoto() {
    return photo;
  }

  public void setPhoto(PhotoSize[] photo) {
    this.photo = photo;
  }

  public Sticker getSticker() {
    return sticker;
  }

  public void setSticker(Sticker sticker) {
    this.sticker = sticker;
  }

  public Video getVideo() {
    return video;
  }

  public void setVideo(Video video) {
    this.video = video;
  }

  public Contact getContact() {
    return contact;
  }

  public void setContact(Contact contact) {
    this.contact = contact;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public User getNewChatParticipant() {
    return newChatParticipant;
  }

  public void setNewChatParticipant(User newChatParticipant) {
    this.newChatParticipant = newChatParticipant;
  }

  public User getLeftChatParticipant() {
    return leftChatParticipant;
  }

  public void setLeftChatParticipant(User leftChatParticipant) {
    this.leftChatParticipant = leftChatParticipant;
  }

  public String getNewChatTitle() {
    return newChatTitle;
  }

  public void setNewChatTitle(String newChatTitle) {
    this.newChatTitle = newChatTitle;
  }

  public PhotoSize[] getNewChatPhoto() {
    return newChatPhoto;
  }

  public void setNewChatPhoto(PhotoSize[] newChatPhoto) {
    this.newChatPhoto = newChatPhoto;
  }

  public Boolean getDeleteChatPhoto() {
    return deleteChatPhoto;
  }

  public void setDeleteChatPhoto(Boolean deleteChatPhoto) {
    this.deleteChatPhoto = deleteChatPhoto;
  }

  public Boolean getGroupChatCreated() {
    return groupChatCreated;
  }

  public void setGroupChatCreated(Boolean groupChatCreated) {
    this.groupChatCreated = groupChatCreated;
  }
  
  
}
