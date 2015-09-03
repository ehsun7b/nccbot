package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class ReplyKeyboardHide {

  @XmlElement(name = "hide_keyboard")
  private boolean hideKeyboard;

  private boolean selective;

  public boolean isHideKeyboard() {
    return hideKeyboard;
  }

  public void setHideKeyboard(boolean hideKeyboard) {
    this.hideKeyboard = hideKeyboard;
  }

  public boolean isSelective() {
    return selective;
  }

  public void setSelective(boolean selective) {
    this.selective = selective;
  }

  
}
