package Final_Project;
//Make sure you have all the SQL Stuff get SQL installer it will download everthing you need DAWG!
//next you need to name your sql database in this instances its called "sample"
//localhost 3306 seems to be the default name of the url
//when setting up the work bench it will ask you to make a user and pass


import java.sql.*;
public class Driver {
	public static String url="jdbc:mysql://localhost:3306/ras?autoReconnect=true&useSSL=false";//the Url name localhost:3306 is deafult for sql workbench.
	public static String user = "root";//User Name
	public static String pass = "Cosmo01392";//Password
	public static Connection myConn;

	public static Connection getConnection() {

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			myConn=DriverManager.getConnection(url,user,pass);//..Connecton to data base


		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		return myConn;








		//ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee

		//while(myRs.next()){
		//System.out.println((("\n\n Table Number: ")+myRs.getInt("Table_Num")+("\n Order Number: ")+myRs.getInt("Order_Num")+("\n Items: ")+ myRs.getString("Item_list")));//shows what is in the data base
		//}

		//String sql ="delete from orders where Order_Num='127'"; 

		//int rowsAffected = myStmt.executeUpdate(sql);

		//myStmt.executeUpdate(sql);

		//System.out.println("Rows affected: "+rowsAffected);
		//System.out.println("Delete complete");


		//ResultSet myRs = myStmt.executeQuery( "SELECT distinct "+jTextField.getText()+
		//// " as call from tablename");
		// List<String> results = new ArrayList<String>();
		//while(rs.next()) {
		// results.add(rs.getString(1));
		/**  }
			 while (myRs.next())
             {
				 List rowValues = new ArrayList();
             }
                 contactListNames[1] = myRs.getString(1);
                 System.out.println("" + contactListNames[1]);
		}
		 */


	}
}

