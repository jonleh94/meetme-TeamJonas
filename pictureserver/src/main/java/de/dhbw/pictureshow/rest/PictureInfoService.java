package de.dhbw.pictureshow.rest;

import de.dhbw.pictureshow.database.dao.PictureInfoDao;
import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.PictureInfo;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;
import groovy.lang.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 *
 */
@Path("/api/user")
@Produces({"application/json"})  // mime type
@Singleton
public class PictureInfoService {
  private static final Logger log = LoggerFactory.getLogger(PictureInfoService.class);

  @Inject PictureInfoDao pictureInfoDao;
  @Inject UserDao userDao;

  @Path("/get/{id}")
  @GET
  public PictureInfo get(@PathParam("id") String id) {
    log.debug("Get PictureInfo " + id);
    PictureInfo pictureInfo = pictureInfoDao.get(UuidId.fromString(id));
    User user = userDao.get(UuidId.fromString(pictureInfo.getOwnerId()));
    pictureInfo.setOwner(user);
    return pictureInfo;
  }

  @Path("/delete/{id}")
  @DELETE
  public void delete(@PathParam("id") String id) {
    log.debug("Delete PictureInfo " + id);
    pictureInfoDao.delete(UuidId.fromString(id));
  }

  @Path("/save")
  @PUT
  public void save(@PathParam("pictureInfo") PictureInfo pictureInfo) {
    pictureInfoDao.persist(pictureInfo);
    log.debug("Save PictureInfo " + pictureInfo);
  }

}
