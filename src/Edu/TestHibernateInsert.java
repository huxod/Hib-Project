package Edu;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Created by hubert on 13.11.2017.
 */

public class TestHibernateInsert {


    public static void main(String[] args){

        TestWords test = new TestWords();

        test.setId(2);
        test.setEnglish("btete");
        test.setPolish("nieteteski");

        final Properties persistanceProperties = new Properties();

        Persistence.generateSchema("Edu", persistanceProperties);
        EntityManagerFactory ent = Persistence.createEntityManagerFactory( "Edu" , new HashMap());
        EntityManager entityManager = ent.createEntityManager();
        //Scalar function
/*        javax.persistence.Query query = entityManager.
                createQuery("Select upper(test.english)  from Test test");
        String test = String.valueOf(query.getSingleResult());


            System.out.println("Employee NAME :"+test);*/


        entityManager.getTransaction().begin();
        // Get a List of Students
        test.setId(1);
        test.setEnglish("beetrner");
        test.setPolish("poertjący");
        entityManager.persist(test);
        entityManager.merge(test);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
