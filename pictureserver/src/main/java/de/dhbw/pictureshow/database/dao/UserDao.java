package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;
import java.util.Collection;

/**
 *
 */
@ApplicationScoped
public class UserDao extends JpaDao<UuidId,User> {
  public UserDao() {
    super(User.class);
  }

  Collection<User> findByName(String name) {
    Query query = entityManager.createQuery("from User u where u.name = :name");
    query.setParameter("name", name);
    return (Collection<User>)query.getResultList();
  }
}
