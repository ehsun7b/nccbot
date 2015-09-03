package com.ehsunbehravesh.nccbot.service.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public abstract class Response<T> {

  private boolean ok;
  private T result;

  public boolean isOk() {
    return ok;
  }

  public void setOk(boolean ok) {
    this.ok = ok;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }
}
