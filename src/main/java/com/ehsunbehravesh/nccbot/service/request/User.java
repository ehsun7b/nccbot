package com.ehsunbehravesh.nccbot.service.request;

import javax.xml.bind.annotation.XmlElement;

public class User {

  private int id;

  @XmlElement(name = "first_name")
  private String firstName;

  @XmlElement(name = "last_name")
  private String lastName;

  private String username;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  
}
