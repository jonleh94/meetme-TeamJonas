package de.dhbw.meetme.servlet;

import de.dhbw.meetme.database.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 */
@Singleton
@Startup
public class StartUpBean {
  private static final Logger log = LoggerFactory.getLogger(StartUpBean.class);

  @Inject UserDao userDao;

  @PostConstruct
  public void init() {
    log.info("MeetMe Server started.");
    // inital code goes here
  }
}
