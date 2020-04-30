package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static final PersistenceUtil instance = new PersistenceUtil();
    private EntityManagerFactory entityManagerFactory;

    public static PersistenceUtil getInstance() {
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }

    private PersistenceUtil(){
        this.entityManagerFactory = Persistence
                .createEntityManagerFactory("MusicAlbumsPU");
    }
}