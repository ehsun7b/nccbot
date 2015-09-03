package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class Sticker {

  @XmlElement(name = "file_id")
  private String fileId;

  private Integer width;

  private Integer height;

  private PhotoSize thumb;

  @XmlElement(name = "file_size")
  private Integer file_size;

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

  public PhotoSize getThumb() {
    return thumb;
  }

  public void setThumb(PhotoSize thumb) {
    this.thumb = thumb;
  }

  public Integer getFile_size() {
    return file_size;
  }

  public void setFile_size(Integer file_size) {
    this.file_size = file_size;
  }

  
}
