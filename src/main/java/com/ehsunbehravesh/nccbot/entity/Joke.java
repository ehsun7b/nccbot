package com.ehsunbehravesh.nccbot.entity;

import java.util.Date;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
public class Joke {

  private static final String CREATE_TABLE_COMMAND = "";

  private Integer id;
  private String content;
  private String owner;
  private Date date;

  public Joke(String owner, String content) {
    this.content = content;
    this.owner = owner;
    this.date = new Date();
  }

  public Joke() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

}
