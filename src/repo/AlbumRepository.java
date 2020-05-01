package repo;

import entity.Album;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

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
    public static void create(Album album){
        EntityManager entityManager = PersistenceUtil.getInstance().getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(album);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static List<Album> findByName (Album album){
        EntityManager entityManager = PersistenceUtil.getInstance().getEntityManagerFactory().createEntityManager();
        TypedQuery albums = entityManager.createNamedQuery("AlbFindFunction",Album.class).setParameter(1, album.getName());
        entityManager.close();
        List<Album> albumList = albums.getResultList();
        return albumList;
    }

}
