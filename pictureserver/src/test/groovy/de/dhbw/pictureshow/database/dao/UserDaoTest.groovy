package de.dhbw.pictureshow.database.dao

import de.dhbw.pictureshow.domain.User
import de.dhbw.pictureshow.domain.UuidId
import spock.lang.Specification

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 */
class UserDaoTest extends Specification {

  @Delegate DbTestUtil dbTestUtil = new DbTestUtil()


  def testPersistence() {
    when:
    dbTestUtil.em.getTransaction().begin();
    UserDao dao = new UserDao()
    dao.entityManager = dbTestUtil.em
    User u = new User();
    u.name = "YOP"
    dao.persist(u);
    dbTestUtil.em.getTransaction().commit();

    then:
    dbTestUtil.em.contains(u)
  }

  def testRead() {
    when:
    dbTestUtil.em.getTransaction().begin();
    UserDao dao = new UserDao()
    dao.entityManager = dbTestUtil.em
    User u = new User();
    u.name = "YOP"
    dao.persist(u);
    UuidId id = u.id
    dbTestUtil.em.getTransaction().commit();
    dbTestUtil.em.close()
    dbTestUtil.createEntityManager() // open clean session to avoid side effects

    dao.entityManager = dbTestUtil.em // make sure we use the new one...
    User validateUser = dao.findById(id)

    then:
    validateUser
    validateUser.id == id
    validateUser.name == "YOP"
  }
}
