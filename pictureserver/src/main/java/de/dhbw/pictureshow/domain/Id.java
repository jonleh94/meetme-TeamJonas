package de.dhbw.pictureshow.domain;

import java.util.UUID;

/**
 *
 */
public class Id {
  private final UUID id;

  public Id() {
    id = UUID.randomUUID();
  }

  public Id(UUID id) {
    this.id = id;
  }

  public UUID getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Id id1 = (Id) o;

    if (!id.equals(id1.id)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Id{" +
        "id=" + id +
        '}';
  }
}