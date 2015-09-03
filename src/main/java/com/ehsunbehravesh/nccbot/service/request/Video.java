package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class Video {

  @XmlElement(name = "file_id")
  private String fileId;

  private Integer width;

  private Integer height;

  private Integer duration;

  private PhotoSize thumb;

  @XmlElement(name = "mime_type")
  private String mimeType;

  @XmlElement(name = "file_size")
  private Integer fileSize;

  private String caption;

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public Integer getWidth() {
    return width;
  }

  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public Integer getDuration() {
    return duration;
  }

  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  public PhotoSize getThumb() {
    return thumb;
  }

  public void setThumb(PhotoSize thumb) {
    this.thumb = thumb;
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

  public String getCaption() {
    return caption;
  }

  public void setCaption(String caption) {
    this.caption = caption;
  }
  
  
}
