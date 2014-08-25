package de.dhbw.pictureshow.rest;

import de.dhbw.pictureshow.database.dao.UserDao;
import de.dhbw.pictureshow.domain.User;
import de.dhbw.pictureshow.domain.UuidId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.Collection;

/**
 *
 */
@Path("/rest/user")
public class UserService {
  private static final Logger log = LoggerFactory.getLogger(UserService.class);

  @EJB
  UserDao userDao;

  @Path("/list")
  @GET
  public Collection<User> list(){
    log.debug("List users");
    return userDao.list();
  }

  @Path("/get/{id}")
  @GET
  public User getUser(@PathParam("id") String id){
    return userDao.findById(UuidId.fromString(id));
  }
}
