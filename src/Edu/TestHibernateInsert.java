package Edu;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceProvider;
import java.util.HashMap;

/**
 * Created by hubert on 13.11.2017.
 */
public class TestHibernateInsert {

    public static void main(String[] args){
        Users usre = new Users();
        usre.setName("Hubert");
        usre.setEmail("hub@lin.pl");
        usre.setPassword("paswd");

        Users usr = new Users();
        usr.setName("Adam");
        usr.setEmail("ada@lin.pl");
        usr.setPassword("passwdord");

        Users usra = new Users();
        usra.setName("Adam");
        usra.setEmail("ada@lin.pl");
        usra.setPassword("passwdord");

        PersistenceProvider persistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory ent = Persistence.createEntityManagerFactory( "Edu" , new HashMap());
        EntityManager entityManager = ent.createEntityManager();
        entityManager.getTransaction().begin();

        // Get a List of Students
        entityManager.persist(usra);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
