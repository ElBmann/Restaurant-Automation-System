
//Make sure you have all the SQL Stuff get SQL installer it will download everthing you need DAWG!
//next you need to name your sql database in this instances its called "sample"
//localhost 3306 seems to be the default name of the url
//when setting up the work bench it will ask you to make a user and pass


import java.sql.*;
public class Driver {
	public static void main(String[] args){
		String url="jdbc:mysql://localhost:3306/sample";//the Url name localhost:3306 is deafult for sql workbench.
		String user = "root";//User Name
		String pass = "Cosmo01392";//Password
		
		try{
			Connection myConn=DriverManager.getConnection(url,user,pass);//..Connecton to data base
			
			Statement myStmt = myConn.createStatement();//...Create Statement
			
			String sql ="delete from employee where id ='1'"; 
					
			int rowsAffected = myStmt.executeUpdate(sql);
					
			myStmt.executeUpdate(sql);
			
			System.out.println("Rows affected: "+rowsAffected);
			System.out.println("Delete complete");
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}
}

