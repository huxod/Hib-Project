package Edu;

/**
 * Created by hubert on 06.01.2018.
 */
public class Testother {
    public static void main(String[] arg){
        HibernateToll testujemy = new HibernateToll("test");

        System.out.println("Prawda czy falsz "+testujemy.getCheck() );
        if(testujemy.getCheck().equals(true)){
            System.out.println("No prawda");
        }
    }

}
