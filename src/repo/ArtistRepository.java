package repo;

import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;

public class ArtistRepository {
    public static Artist findByID(int ID){
        EntityManager entityManager = PersistenceUtil
                .getInstance()
                .getEntityManagerFactory()
                .createEntityManager();

        Artist lookFor = new Artist();
        lookFor.setId(ID);
        Artist artist = entityManager.find(Artist.class, lookFor.getId());

        entityManager.close();

        return artist;
    }

}
