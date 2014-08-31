package de.dhbw.pictureshow.domain;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity // also add to persistence.xml !!
@XmlRootElement // needed for REST JSON marshalling
public class PictureInfo extends  PersistentObject{
  private String name;
  @Transient private User owner;  // just store the id below
  String ownerId;
  private String fileName;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
    this.ownerId = owner.id.asString();
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public void setOwnerId(String ownerId) {
    this.ownerId = ownerId;
  }

  @Override
  public String toString() {
    return "PictureInfo{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", owner=" + owner +
        ", fileName='" + fileName + '\'' +
        '}';
  }
}
