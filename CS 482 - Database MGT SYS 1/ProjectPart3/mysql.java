package ProjectPart3;

// Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class mysql {

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void makeJDBCConnection() {

        //Set information for mySQL
        String url = "jdbc:mysql://localhost:3306/databaseProject";
        String username = "user";                                   
        String password = "sqluser";
                      
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting with Local Host");               // Print 
            connect = DriverManager.getConnection(url, username, password); // Connect to mySQL
            System.out.println("In the Database!");                         // Print
            statement = connect.createStatement();                          // Create new Statement
        }catch(Exception e){                                                // Catch Exceptions
            System.err.println(e);                                          // Print Error
            System.exit(0);                                                 // Exit Program.
        }                                                                   // End Try Catch
    }  
} // End mysql
