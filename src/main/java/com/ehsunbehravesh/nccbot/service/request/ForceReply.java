package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class ForceReply {

  @XmlElement(name = "force_reply")
  private boolean forceReply;

  private boolean selective;

  public boolean isForceReply() {
    return forceReply;
  }

  public void setForceReply(boolean forceReply) {
    this.forceReply = forceReply;
  }

  public boolean isSelective() {
    return selective;
  }

  public void setSelective(boolean selective) {
    this.selective = selective;
  }

  
}
