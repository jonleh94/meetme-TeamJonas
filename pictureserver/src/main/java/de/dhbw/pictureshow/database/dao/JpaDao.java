package de.dhbw.pictureshow.database.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

/**
 *
 */
public abstract class JpaDao<K, E> implements Dao<K, E> {
  protected Class<E> entityClass;

  @PersistenceContext
  protected EntityManager entityManager;

  public JpaDao(Class<E> entityClass) {
    this.entityClass = (Class<E>) entityClass;
  }

  public void persist(E entity) {
    entityManager.persist(entity);
  }

  public void remove(E entity) {
    entityManager.remove(entity);
  }

  public E findById(K id) {
    return entityManager.find(entityClass, id);
  }

  public Collection<E> findAll() {
    Query q = entityManager.createQuery("select e from " + entityClass.getName() + " e");
    return (Collection<E>)q.getResultList();
  }

}
