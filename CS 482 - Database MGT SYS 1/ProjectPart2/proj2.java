package ProjectPart2;

import java.util.Scanner;
import java.sql.*;

public class proj2 {
	public static void main(String[] args) {
		boolean status = true;
		Scanner sc = new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/databaseProject";
        String username = "user";
        String password = "sqluser";
		
		
		
		
		while(status == true) {
			System.out.println("Please enter:");
			String all = sc.nextLine();
			String proj = all.substring(0, 6);
			String indexString = all.substring(7, 8);
			
			
			String param = "";
			if(all.length() > 8) {
				param = all.substring(9);
			}
			
			
			
			int index = Integer.parseInt(indexString);
			
			
			
			
			if(proj.equals("./proj") == true) {
				
			
			    switch(index) {
			        //proj1 ok!! 
			        case 1:
			        	
			        	try {
			        		
			        		
			        		Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT siteCode, type, address, phone FROM Site WHERE Site.address = '" + param + "';";
			        		Statement stmt = con.createStatement();
			                ResultSet rs = stmt.executeQuery(query);
			                
			                while(rs.next()) {
			                	//Site (siteCode: integer, type: varchar (16), address: varchar(100), phone: varchar(16)) 
			                	int siteCode = rs.getInt("siteCode");
			                	String type = rs.getString("type");
			                	String address = rs.getString("address");
			                	String phone = rs.getString("phone");
			                	
			                	System.out.println(siteCode + ", " + type + ", " + address + ", " + phone);
			                }
			        		
			        		
			        				
			        	}
			        	catch(SQLException e) {
			        		System.out.println("Oops, sorry!");
			                e.printStackTrace();
			        		
			        	}
			        	System.out.println("");
			    	    
			        break;
			        
			        //proj2 ok!!
			        case 2:
			        	try {
			        		Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT d.serialNo, d.modelNo, t.name FROM DigitalDisplay AS d, TechnicalSupport AS t, Specializes AS s WHERE d.modelNo = s.modelNo AND s.empId  = t.empId AND d.schedulerSystem = '" + param + "';";
			        		Statement stmt = con.createStatement();
			                ResultSet rs = stmt.executeQuery(query);
			                
			                while(rs.next()) {
			                	//Specializes (empId: integer, modelNo: char(10)) 
			                	//DigitalDisplay (serialNo: char(10), schedulerSystem: char(10), modelNo: char(10)) 
			                	//TechnicalSupport (empId: integer, name: varchar (40), gender: char (1))
			                	int serialNo = rs.getInt("d.serialNo");
			                	String modelNo = rs.getString("d.modelNo");
			                	String name = rs.getString("t.name");
			                	
			                	System.out.println(serialNo + ", " + modelNo + ", " + name);
			                }
			        		
			        	}
			        	catch(SQLException e) {
			        		System.out.println("Oops, sorry!");
			                e.printStackTrace();
			        		
			        	}
			        	System.out.println("");
			        	
			    	    
			        break;
			        
			        //proj3 FIXED IT! Partial finished
			        case 3:
			        	try {
			        		Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT Salesman.name, COUNT(Salesman.name)  FROM Salesman\n" 
			        				+ "WHERE Salesman.name IS NOT NULL GROUP BY Salesman.name;";
			        		Statement stmt = con.createStatement();
			                ResultSet rs = stmt.executeQuery(query);
			        		System.out.println("Name             cnt");
			                System.out.println("------------------");
			                    while(rs.next()){
			                        int scnt = rs.getInt("count(Salesman.name)");
			                        String name = rs.getString(1);

			                
			                        System.out.print(name + "        " + scnt);
			                        if(scnt > 1){
			                            String s = "SELECT * FROM Salesman WHERE Salesman.name = '" + name + "'";
			                            Statement state =  con.createStatement();
			                            rs = state.executeQuery(s);
			                            ResultSetMetaData meta = rs.getMetaData();
			                            int col = meta.getColumnCount();
			                            while(rs.next()){
			                                System.out.print("(");
			                                for(int j = 1; j <= col; j++){
			                                System.out.print(rs.getString(j) + " ");
			                                }
			                                System.out.print(")");
			                            }      
			                    
			                        }//End if 
			                        System.out.print("\n");
			                     }
			        		
			        	}
			        	catch(SQLException e){
			        		System.out.println("Oops, sorry!");
			                e.printStackTrace();
			        		
			        	}
			        	System.out.println("");
			    	    
				    break;
				    
				     //proj4
			        case 4:
			        	try {
			            	Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT name from Client WHERE phone = '" + param + "';";
			                Statement stmt = con.createStatement();
			                ResultSet rs = stmt.executeQuery(query);
			                
			                while(rs.next()) {
			                	
			                	String name = rs.getString("name");
			                	
			                	System.out.println(name);
			                		
			                		
			                }
			                }
			                catch (SQLException e){
			            	System.out.println("Oops, sorry!");
			                e.printStackTrace();
			            	
			            }
			        	System.out.println("");
			        	
			        break;
			        
			        //proj5 OK!!
			        case 5:
			        	try {
			            	Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT h.empId, m.name, h.hours FROM AdmWorkHours AS h, Administrator\n"
			                		+ "AS m WHERE h.empId = m.empId ORDER BY h.hours ASC;";
			                Statement stmt = con.createStatement();
			                ResultSet rs = stmt.executeQuery(query);
			                
			                while(rs.next()) {
			                	int empId = rs.getInt("h.empId");
			                	String name = rs.getString("m.name");
			                	float hours = rs.getFloat("h.hours");
			                	System.out.println(empId + ", " + name + ", " + hours);
			                		
			                		
			                }
			                }
			                catch (SQLException e){
			            	System.out.println("Oops, sorry!");
			                e.printStackTrace();
			            	
			            }
			        	System.out.println("");
			        
			        break;
			        
			        //proj6 ok!!
			        case 6:
			        	try {
			        		Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT t.name FROM TechnicalSupport AS t, Specializes AS s WHERE t.empId\n"
			        				+ "= S.empId AND s.modelNo = '" + param + "';";
			                  Statement stmt = con.createStatement();
			                  ResultSet rs = stmt.executeQuery(query);
			                  	
			                  while(rs.next()) {
			                  	
			                  	String name = rs.getString("t.name");
			                  	
			                  	System.out.println(name);
			                  		
			                  		
			                  }
			        		
			        	}
			        	catch (SQLException e) {
			        		System.out.println("Oops, sorry!");
			                e.printStackTrace();
			        		
			        	}
			        	System.out.println("");
			        	
			        break;
			        
			        //proj7 OK!
			        case 7:
			        	try {
			        		Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT s.name, AVG(p.commissionRate) AS avg_commissionRate FROM Salesman\n"
			                  	  +	"AS s, Purchases AS p WHERE s.empId = p.empId GROUP BY s.empId ORDER BY avg_commissionRate DESC;";
			                  Statement stmt = con.createStatement();
			                  ResultSet rs = stmt.executeQuery(query);
			                  	
			                  while(rs.next()) {
			                  	
			                  	String name = rs.getString("s.name");
			                  	float avg = rs.getFloat("avg_commissionRate");
			                  	System.out.println(name + ", " + avg);
			                  		
			                  		
			                  }
			        		
			        	}
			        	catch (SQLException e) {
			        		System.out.println("Oops, sorry!");
			                e.printStackTrace();
			        		
			        	}
			        	System.out.println("");
			        break;
			        
			        //proj8 OK!
			        case 8:
			        	try {
			            	Connection con = DriverManager.getConnection(url, username, password);
			        		String query = "SELECT count(a.empId), count(s.empId), count(t.empId) FROM Administrator\n"
			                		+ "AS a, Salesman AS s, TechnicalSupport AS t;";
			                Statement stmt = con.createStatement();
			                ResultSet rs = stmt.executeQuery(query);
			                
			                while(rs.next())
			                {
			                int acnt = rs.getInt("count(a.empId)");
			                int scnt = rs.getInt("count(s.empId)");
			                int tcnt = rs.getInt("count(t.empId)");
			                
			                System.out.println("Role             cnt");
			                System.out.println("------------------");
			                System.out.println("Administrator   " + acnt);
			                System.out.println("Salesmen        " + scnt);
			                System.out.println("Technicians     " + tcnt);
			                }
			                }
			                catch (SQLException e){
			            	System.out.println("Oops, sorry!");
			                e.printStackTrace();
			            	
			            }
			        	System.out.println("");
			        break;
			        
				    
			    }
			}
			
		}
		
		sc.close();
		
		
		
		
		
		
	}

}
