package Edu;


import com.sun.istack.internal.Nullable;
import org.hibernate.cfg.annotations.Nullability;

import javax.persistence.*;

/**
 * Created by hubert on 02.12.2017.
 */
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition = "MEDIUMINT NOT NULL AUTO_INCREMENT")
    private int id ;
    @Column
    private String english;
    @Column
    private String polish;


    //Generate column ID
    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }
    //Generate column english
    public String getEnglish(){return english;}

    public void setEnglish(String english){this.english = english;}

    //Generate column polish
    public String getPolish(){return polish;}

    public void setPolish(String polish){this.polish = polish;}

}
