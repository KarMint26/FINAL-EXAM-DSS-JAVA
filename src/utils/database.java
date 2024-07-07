package sipsmea;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public static Connection connectDb() {
        try {

            Class.forName("com.mysql.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://homelaundry.my.id/homelaun_sipsmea", 
                    "homelaun_karel", "26November2003_");
            System.out.println("Success Connected MYSQL Database");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        connectDb();
    }
}
