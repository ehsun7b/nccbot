package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class Document {

  @XmlElement(name = "file_id")
  private String fileId;

  private PhotoSize thumb;

  @XmlElement(name = "file_name")
  private String fileName;

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

  public PhotoSize getThumb() {
    return thumb;
  }

  public void setThumb(PhotoSize thumb) {
    this.thumb = thumb;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
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
