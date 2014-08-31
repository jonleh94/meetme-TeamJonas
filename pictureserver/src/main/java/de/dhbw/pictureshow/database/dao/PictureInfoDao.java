package de.dhbw.pictureshow.database.dao;

import de.dhbw.pictureshow.domain.PictureInfo;
import de.dhbw.pictureshow.domain.UuidId;

import javax.enterprise.context.ApplicationScoped;

/**
 *
 */
@ApplicationScoped
public class PictureInfoDao extends JpaDao<UuidId, PictureInfo> {

  public PictureInfoDao() {
    super(PictureInfo.class);
  }
}
