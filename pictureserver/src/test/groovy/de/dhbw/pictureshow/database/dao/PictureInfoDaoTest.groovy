package de.dhbw.pictureshow.database.dao

import de.dhbw.pictureshow.domain.PictureInfo
import de.dhbw.pictureshow.domain.User
import spock.lang.Specification

/**
 *
 */
class PictureInfoDaoTest extends Specification {

  @Delegate // a special form of inheritance
  DbTestUtil dbTestUtil = new DbTestUtil()

  private PictureInfo createPictureInfo(PictureInfoDao dao, String name, User owner, String fileName) {
    PictureInfo p = new PictureInfo();
    p.name = name
    p.owner = owner
    p.fileName = fileName
    dao.persist(p);
    p
  }


  def testPersistence() {
    setup:
    PictureInfoDao dao = new PictureInfoDao()

    when:
    dbTestUtil.em.getTransaction().begin();
    dao.entityManager = dbTestUtil.em
    User user = new User()
    user.name = "user1"
    PictureInfo pictureInfo = createPictureInfo(dao, "picture1", user, "fileName" )
    dbTestUtil.em.getTransaction().commit();

    then:
    dbTestUtil.em.contains(pictureInfo)
  }

  def testRead() {
    setup:
    PictureInfoDao dao = new PictureInfoDao()
    dbTestUtil.em.getTransaction().begin();
    dao.entityManager = dbTestUtil.em
    User user = new User()
    user.name = "user1"
    PictureInfo pictureInfo = createPictureInfo(dao, "picture1", user, "fileName" )
    dbTestUtil.em.getTransaction().commit();
    dbTestUtil.em.close()
    dbTestUtil.createEntityManager() // open clean session to avoid side effects
    dao.entityManager = dbTestUtil.em // make sure we use the new one...

    when:
    PictureInfo foundInfo = dao.get(pictureInfo.id)

    then:
    foundInfo
    foundInfo.id == pictureInfo.id
    foundInfo.owner == null
    foundInfo.ownerId == user.id.asString()
  }

}
