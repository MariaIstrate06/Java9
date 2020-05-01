package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public static void create(Artist artist){
        EntityManager entityManager = PersistenceUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(artist);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Artist> findByName(Artist artist){
        EntityManager entityManager = PersistenceUtil.getInstance().getEntityManagerFactory().createEntityManager();
        TypedQuery artists = entityManager.createNamedQuery("ArtFindFunction",Album.class).setParameter(1, artist.getName());
        entityManager.close();
        List<Artist> artistList = artists.getResultList();
        return artistList;
    }

}
