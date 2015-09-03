package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class ReplyKeyboardMarkup {

  private String[][] keyboard;

  @XmlElement(name = "resize_keyboard")
  private boolean resizeKeyboard;

  @XmlElement(name = "one_time_keyboard")
  private boolean oneTimeKeyboard;

  private boolean selective;

  public String[][] getKeyboard() {
    return keyboard;
  }

  public void setKeyboard(String[][] keyboard) {
    this.keyboard = keyboard;
  }

  public boolean isResizeKeyboard() {
    return resizeKeyboard;
  }

  public void setResizeKeyboard(boolean resizeKeyboard) {
    this.resizeKeyboard = resizeKeyboard;
  }

  public boolean isOneTimeKeyboard() {
    return oneTimeKeyboard;
  }

  public void setOneTimeKeyboard(boolean oneTimeKeyboard) {
    this.oneTimeKeyboard = oneTimeKeyboard;
  }

  public boolean isSelective() {
    return selective;
  }

  public void setSelective(boolean selective) {
    this.selective = selective;
  }
  
  
}
