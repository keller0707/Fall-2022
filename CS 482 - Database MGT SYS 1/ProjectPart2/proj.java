/*
 * Name     : Keller Sedillo, Meng Yang Tseng
 * Date     : 10/13/2022
 * Input    : The problem number and its needed parameter.
 * Output   : Expect SQL result. 
 * 
 * References:
 * https://www.youtube.com/watch?v=duEkh8ZsFGs
 * https://www.vogella.com/tutorials/MySQLJava/article.html
*/
package ProjectPart2;

// Libraries
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSetMetaData;

public class proj {
    // Inital Var.
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String[] info;
    private String[] table;
    private String[] condition;

    public static void main(String[] args) {

        // Check if argument is given
        if(args.length < 1){
            System.err.println("Error: Input NEEDED");
            System.exit(0);
        }// End if

        // Create object for calling functions.
        proj sql = new proj();

        // Check user desired case
        switch(Integer.parseInt(args[0])){
            case 1:
                // Create Query
                String[] info1      = {"*"};                                
                String[] table1     = {"Site"};                             
                String[] condition1 = {"Site.address = '" + args[1] + "'"};
                
                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info1, table1, condition1);
                sql.runQuery();
                sql.closeConnection();
                break;
            case 2:
                // Create Query
                String[] info2     = {"DigitalDisplay.serialNo",
                                     "DigitalDisplay.modelNo",
                                     "TechnicalSupport.name"};
                String[] table2    = {"DigitalDisplay", 
                                     "TechnicalSupport",
                                     "Specializes"};
                String[] condition2 = {"DigitalDisplay.schedulerSystem = '" + args[0] + "' ",
                                      "AND DigitalDisplay.modelNo = Specializes.modelNo ",
                                      "AND Specializes.empId = TechnicalSupport.empId "};
                
                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info2, table2, condition2);
                sql.runQuery();
                sql.closeConnection();      
                break;
            case 3:
                // Create Query
                String[] info3      = {"Salesman.name", "COUNT(Salesman.name)"};
                String[] table3     = {"Salesman"};
                String[] condition3 = {"GROUP BY Salesman.name"};

                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info3, table3, condition3);
                sql.runQuery3();
                sql.closeConnection();
                break;
            case 4:
                // Create Query
                String[] info4      = {"Client.name"};
                String[] table4     = {"Client"};
                String[] condition4 = {"Client.phone = " + "'" + args[1] + "'"};

                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info4, table4, condition4);
                sql.runQuery();
                sql.closeConnection();  
                break;
            case 5:
                // Create Query
                String[] info5      = {"h.empId", "m.name", "h.hours"};
                String[] table5     = {"AdmWorkHours AS h", "Administrator AS m"};
                String[] condition5 = {"h.empId = m.empId", "ORDER BY h.hours ASC"};

                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info5, table5, condition5);
                sql.runQuery();
                sql.closeConnection();
                break;
            case 6:
                // Create Query
                String[] info6      = {"t.name"};
                String[] table6     = {"TechnicalSupport AS t", "Specializes AS s"};
                String[] condition6 = {"t.empId = s.empId", "AND s.modelNo = '" + args[1] + "'"};

                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info6, table6, condition6);
                sql.runQuery();
                sql.closeConnection();
                break;
            case 7:
                // Create Query
                String[] info7     = {"s.name", "AVG(p.commissionRate)"};
                String[] table7    = {"Salesman AS s", "Purchases AS p"};
                String[] condition7 = {"s.empId = p.empId", "GROUP BY s.empId", "ORDER BY AVG(p.commissionRate) DESC"};

                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info7, table7, condition7);
                sql.runQuery();
                sql.closeConnection();
                break;
            case 8:
                // Create Query
                String[] info8      = {"count(a.empId)", "count(s.empId)", " count(t.empId)"};
                String[] table8     = {"Administrator AS a", "Salesman AS s", "TechnicalSupport AS t"};
                String[] condition8 = {};

                // Build and Output Query 
                sql.makeJDBCConnection();
                sql.setQuery(info8, table8, condition8);
                sql.runQuery8();
                sql.closeConnection();
                break;
        }// End switchCase
    }// End Main    

    /**
    * Create connection with mySQL Server
    *
    * @throws      SQLException If connection is bad/invalid 
    */
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
        }catch(Exception e){                                             // Catch Exceptions
            System.err.println(e);                                          // Print Error
            System.exit(0);                                                 // Exit Program.
        }                                                                   // End Try Catch
    }                                                                       // End readDataBase

    /**
    * Set the global variables for the query.
    *
    * @param  info      The String[] of informaion we want to print.
    * @param  table     The String[] of Table we are accessing. 
    * @param  condition The String[] of conditions we want to add.
    */
    public void setQuery(String[] info, String[] table, String[] condition){
        this.info = info;           // Update Info
        this.table = table;         // Update Table
        this.condition = condition; // Update Condition
    }//end setQuery

    /**
    * Processes and runs the Query we inputed
    *
    */
    public void runQuery(){
        try{
            checkConnection();         // Check Connection
            resultSet = buildQuery();  // Build the Query
            writeResultSet(resultSet); // Write out Output    
        }catch(Exception e){           // Catch 
            System.err.println(e);     // Print Error
            System.exit(0);            // Exit Program
        }                              // End tryCatch
    }                                  // End runQuery

    /**
    * Specialized run Query function to help 
    * solve problem #3
    */
    public void runQuery3(){
        try{
            checkConnection();          // Check Connection
            resultSet = buildQuery();   // Build the Query
            writeResultSet3(resultSet); // Write out Output    
        }catch(Exception e){            // Catch 
            System.err.println(e);      // Print Error
            System.exit(0);             // Exit Program
        }                               // End tryCatch
    }                                   // End runQuery

    /**
    * Specialized run Query function to help 
    * solve problem #8
    */
    public void runQuery8(){
        try{
            checkConnection();          // Check Connection
            resultSet = buildQuery();   // Build the Query
            writeResultSet8(resultSet); // Write out Output    
        }catch(Exception e){            // Catch 
            System.err.println(e);      // Print Error
            System.exit(0);             // Exit Program
        }                               // End tryCatch
    }                                   // End runQuery

    
    /**
    * Builds the query requests with the given inputs.
    *
    * @return      The Result Set from the given query
    * @throws      Exception if given Query is invalid or empty
    */
    private ResultSet buildQuery() throws Exception{
        // Check if info[] or table[] are empty
        if(info.length == 0 || table.length == 0) throw new Exception("ERROR: Info or table array is empty!");

        // Create SELECT Query
        String query = "SELECT ";
        for (int i = 0; i < info.length; i++){           // Loop through info[]
            query = query + info[i];                     // Add String to Query
            if(i+1 != info.length) query = query + ", "; // Add ',' 
        }                                                // End For

        // Create FROM Query
        query = query + " FROM ";
        for (int i = 0; i < table.length; i++){           // Loop through table[]
            query = query + table[i];                     // Add String to Query
            if(i+1 != table.length) query = query + ", "; // Add ','
        }                                                 // End For
        
        // Check if Condition[] is empty
        if(condition.length == 0){ 
            System.out.println(query + ";");            // Print Complete Query
            return statement.executeQuery(query + ";"); // Return Query
        }// End if

        //Create WHERE Query
        if(!condition[0].startsWith("GROUP BY")) query = query + " WHERE ";
        else  query = query + " ";
        
       
        for (int i = 0; i < condition.length; i++){ // Loop through condition[]
            query = query + condition[i] + " ";     // Add String to Query
        }                                           // End For

        System.out.println(query + ";");            // Print Complete Query
        return statement.executeQuery(query + ";"); // Return Query
    }//end 

    /**
    * Checks if connected to mySQL Server
    *
    * @throws      Exception If not connected to Server
    * @see         Image
    */
    private void checkConnection() throws Exception{
        if(connect == null) throw new Exception("ERROR: Not Connected to My SQL");
    }//end isConnected

    
    /**
    * Close the connection to the mySQL server
    *
    */
    public void closeConnection(){
        try{
            connect.close();                         // Close Connection
            System.out.println("Connection Closed"); // Print Close
        }catch (Exception e){                        // Catch Error
            System.err.println(e);                   // Print Error
        }                                            // End tryCatch
    }                                                // End closeConnection
    
    /**
    * Prints out the result set specifically 
    * for problem #8
    *
    * @param    resultSet    The set of results from the query
    * @throws   SQLException Invalid query
    */
    public void writeResultSet3(ResultSet resultSet) throws Exception{
        //Print Headers
        System.out.println("Name             cnt");
        System.out.println("------------------");

        while(resultSet.next()){                                 // Loop through Result set
            int scnt = resultSet.getInt("count(Salesman.name)"); // Get Count
            String name = resultSet.getString(1);                // Get Name
            System.out.print(name + "        " + scnt);          // Print Name and Count

            if(scnt > 1){                                                                 // Check if there is more than 1 Salesman with same name.
                String s = "SELECT * FROM Salesman WHERE Salesman.name = '" + name + "'"; // Save query into string
                Statement state =  connect.createStatement();                             // Create new Statement
                ResultSet rs = state.executeQuery(s);                                     // Execute Query and save results 
                ResultSetMetaData meta = rs.getMetaData();                                // Get MetaData 
                int col = meta.getColumnCount();                                          // Get Columns
                while(rs.next()){                                                         // Loop through results
                    System.out.print("(");                                                // Print (
                    for(int j = 1; j <= col; j++){                                        // Loop through Salesman
                        System.out.print(rs.getString(j) + " ");                          // Print Salesman Info
                    }                                                                     // End For
                    System.out.print(")");                                                // Print )
                }                                                                         // End While
            }                                                                             // End if 
            System.out.print("\n");                                                       // Print 
        }                                                                                 // End while
    }// end writeResultSet8

    /**
    * Prints out the result set specifically 
    * for problem #8
    *
    * @param    resultSet    The set of results from the query
    * @throws   SQLException Invalid query
    */
    public void writeResultSet8(ResultSet resultSet) throws Exception{

        while(resultSet.next()){                           // While we still have next String
            int acnt = resultSet.getInt("count(a.empId)"); // Administrator Count
            int scnt = resultSet.getInt("count(s.empId)"); // Salesmen Count
            int tcnt = resultSet.getInt("count(t.empId)"); // Technicians Count
                                                           // 
            System.out.println("Role             cnt");    // Print Header
            System.out.println("------------------");      // Print Line
            System.out.println("Administrator   " + acnt); // Print Count
            System.out.println("Salesmen        " + scnt); // Print Count
            System.out.println("Technicians     " + tcnt); // Print Count
        }                                                  // End While
    }// End writeResultSet8

    /**
    * Prints out the result set 
    *
    * @param    resultSet    The set of results from the query
    * @throws   SQLException Invalid query
    */
    private void writeResultSet(ResultSet resultSet) throws SQLException {
        //Find # of col and print out headers
        ResultSetMetaData meta = resultSet.getMetaData();   // Get meta data
        int col = meta.getColumnCount();                    // Get # of columns
        for(int i = 1; i <= col; i++){                      // Loop through columns
            System.out.print(meta.getColumnName(i) + " |"); // Print out Column name
        }                                                   // End For

        //Print Line
        System.out.print("\n=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        
        while (resultSet.next()) {                               // While we still have next String
            for(int i = 1; i <= col; i++){                       // Loop through Columns
                System.out.print(resultSet.getString(i) + " |"); // Print String
            }                                                    // End For
            System.out.print("\n");                              // Print Space
        }                                                        // End While
    }// End writeResultSet 
}// End proj
