package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class Audio {

  @XmlElement(name = "file_id")
  private String fileId;

  private Integer duration;

  @XmlElement(name = "mime_type")
  private String mimeType;

  @XmlElement(name = "file_size")
  private Integer fileSize;

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }

  public Integer getFileSize() {
    return fileSize;
  }

  public void setFileSize(Integer fileSize) {
    this.fileSize = fileSize;
  }
  
  
}
