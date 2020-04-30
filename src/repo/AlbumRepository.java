package repo;

import entity.Album;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class AlbumRepository {
    public static Album findByID(int ID){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        Album lookFor = new Album();
        lookFor.setId(ID);
        Album album = entityManager.find(Album.class, lookFor.getId());

        entityManager.close();

        return album;
    }

}
