package Edu;


import javax.persistence.*;

/**
 * Created by hubert on 02.12.2017.
 */
@Entity
@Table(name = "words")
public class TestWords {
    @Id
    @Column(name = "id", unique=true, nullable = false,insertable = false)
    private int id;
    @Column(name="polish")
    private String english;
    @Column(name="english")
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
