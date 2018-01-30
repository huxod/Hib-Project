package Edu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

/**
 * Created by hubert on 06.01.2018.
 */
public class HibernateToll {
    public HibernateToll(String table){
        this.table = table;
        this.check = checked(table);
        System.out.println("System sprawdzający zainicjalizowany nazwa tabeli to " + this.getTable()+" exist " +this.check );
    }

    private Object table;
    private Boolean check;

    public Object  getTable() {return table;}
    public Boolean getCheck() {return check;}

    public static boolean checked(String tableName) {
        final Properties persistanceProperties = new Properties();
        Persistence.generateSchema("Edu", persistanceProperties);
        EntityManagerFactory ent = Persistence.createEntityManagerFactory( "Edu" , new HashMap());
        EntityManager entityManager = ent.createEntityManager();

        try {
            List<Object[]> tabels;
            tabels = entityManager.createNativeQuery(
                    "SELECT * FROM "+tableName+"")
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            persistanceProperties.setProperty(org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "update");
            Persistence.generateSchema("Edu", persistanceProperties);
            EntityManagerFactory enta = Persistence.createEntityManagerFactory( "Edu" , new HashMap());
            EntityManager entaityManager = enta.createEntityManager();
            entaityManager.getTransaction().begin();
            entaityManager.persist(tableName);
            entaityManager.close();
            return true;

        }
        persistanceProperties.setProperty(org.hibernate.cfg.AvailableSettings.HBM2DDL_AUTO, "none");
        return true;
    }
}
