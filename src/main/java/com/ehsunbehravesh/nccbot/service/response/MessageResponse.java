package com.ehsunbehravesh.nccbot.service.response;

import com.ehsunbehravesh.nccbot.service.request.Message;

public class MessageResponse extends Response<Message> {

  public MessageResponse(boolean ok) {
    this.setOk(ok);
  }

  public MessageResponse(boolean ok, Message message) {
    this.setOk(ok);
    this.setResult(message);
  }
}
