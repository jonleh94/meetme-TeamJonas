package de.dhbw.pictureshow.domain;

/**
 *
 */
public class PersistentObject {
  private final Id id;

  public PersistentObject() {
    id = new Id();
  }

  public PersistentObject(Id id) {
    this.id = id;
  }

  public Id getId() {
    return id;
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
