package de.dhbw.pictureshow.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

/**
 *
 */
@Embeddable
public class UuidId implements Serializable {
  @Column(length = 2048)
  private UUID id;

  public UuidId() {
    id = UUID.randomUUID();
  }

  public String getId() {
    return id.toString();
  }

  public void setId(String id) {
    this.id = UUID.fromString(id);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UuidId id1 = (UuidId) o;

    if (!id.equals(id1.id)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "UuidId{" +
        "id=" + id +
        '}';
  }
}