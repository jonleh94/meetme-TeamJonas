package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 */
@ApplicationScoped
public class UserDao extends JpaDao<UuidId,User> {
  public UserDao() {
    super(User.class);
  }
}
