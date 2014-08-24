package de.dhbw.pictureshow.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 *
 */
@MappedSuperclass
abstract public class PersistentObject {
  @EmbeddedId private UuidId id;

  public PersistentObject() {
    id = new UuidId();
  }

  public UuidId getId() {
    return id;
  }

  public void setId(UuidId id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PersistentObject)) return false;

    PersistentObject that = (PersistentObject) o;

    if (!id.equals(that.id)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
