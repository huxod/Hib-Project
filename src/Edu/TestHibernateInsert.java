package Edu;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by hubert on 13.11.2017.
 */
public class TestHibernateInsert {

    SessionFactory sessionFactory;
    public static void main(String[] args){
        EduUsersEntity usr = new EduUsersEntity();
        usr.setName("John");
        usr.setEmail("John@lin.pl");
        usr.setPassword("paswd");

        EntityManagerFactory ent = Persistence.createEntityManagerFactory( "NewPersistenceUnit");
        EntityManager entityManager = ent.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(usr);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
