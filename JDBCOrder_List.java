/* <p>The class JDBCOrder List Contains multiple usecases. Void Item, ViewWaitingOrder, SendOrder, Serve Ticket
 * Void Item will give the user the ability to void an item after the order
 * has been placed. ViewWaitingOrder allows the User to view all incoming orders
 * that need to be fulfilled. SendOrder will add an Order to the OrderList
 * The Order_List (bridge) class will invoke the methods in JDBCOrder_List
 *
 * @author Brian Recuero, Raphael Lopez
 * @version 1.0 Build 1 Nov, 11, 2016
 *
 */

/**
 * Has several different methods
 * Void Item,OrderList,SendOrder, ViewWaitingOrder, ServeTicket
 *
 */
public class JDBCOrder_List {
    /**
     * This method uses aggregation to invoke the void method from the order_List class.
     * Then it well be used to void items after the order has been placed.
     * @param Item, Order  
     * @return will returns true if there are items to void and false if empty
     */
    public boolean VoidItem(Item item, Order order) {

    }

    /**
     * Will Display the list of items in each order from an array list.
     * Invokes the items added in the ViewWaitingOrder method in the Order_list class
     * @return Will return an array list of orders that are added into the system
     *
     */
    public Order[] ViewWaitingOrder(){

    }

    /**
    * This method will used to add a new order to the OrderList
    * @param Order order will be the Order that is being added
    * @return will return a boolean value, if true the order has been successfully sent,
    * if false the order could not be sent
    */
    public boolean SendOrder(Order order) {

    }
/**
    * This method will used to complete an order and remove it from the OrderList
    * @param CompleteOrder will be the OrderNumber that is being removed
    * @return will return a boolean value, true if the order has been completed,
    * false if the order is not completed
    */
    public boolean ServeTicket(Order CompleteOrder) {

	}
    
    /* This method will be used to search for an Order in the JDBCOrderList
     * @param OrderId
     * @return a boolean value, true when the search is successful and false when it is not
    */
    public boolean SearchList(int OrderId){
    	
    }
}

------------------------------------------------------------------------------------------------------------------------------------
	package RAS;

//import java.util.ArrayList;
//import java.util.List;
import java.sql.*;


public class JDBC_OrderList {
	
	public Statement myStat;
	public ResultSet myRs;
	public int exc;
	
	Connection conn = Driver.getConnection();
	
	public boolean SendOrder(int tableNum, String accName,String order){
		
		try{	
			//1: Create a statement 
			myStat = conn.createStatement();
			
			//2: Execute SQL
			exc = myStat.executeUpdate("INSERT INTO Orders (Table_Num,Acc_Name,Item_List,Order_Total) VALUES ("+tableNum+",'"+accName+"','"+order+"',23.23);");
			           
			//3: Process the result set
			/*while (myRs.next()){
				resultStr.add(myRs.getString("first_name")+" "+myRs.getString("last_name"));
			}*/
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}
		

		
		return true;
		
	}

}

-------------------------------------------------------------------------------------------------------------------------------------------------
		package Final_Project;

//import java.util.ArrayList;
		import java.util.List;
		import java.sql.*;



public class JDBC_OrderList {

	public Statement myStat;
	public ResultSet myRs;
	public int exc;

	Connection conn = Driver.getConnection();

	public boolean SendOrder(int tableNum, String accName,String order){

		try{
			//1: Create a statement
			myStat = conn.createStatement();

			//2: Execute SQL
			exc = myStat.executeUpdate("INSERT INTO Orders (Table_Num,Acc_Name,Item_List,Order_Total) VALUES ("+tableNum+",'"+accName+"','"+order+"',23.23);");

			//3: Process the result set
			/*while (myRs.next()){
				resultStr.add(myRs.getString("first_name")+" "+myRs.getString("last_name"));
			}*/
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}



		return true;


	}
	public boolean VoidItem(int item_num) {
		try{

			Statement myStmt = conn.createStatement();//...Create Statement
			ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee


			//String sql ="delete from orders where Order_Num ='Item_List'";
			String sql ="delete from orders" + "where Item_List = item_num";
			int rowsAffected = myStmt.executeUpdate(sql);
			myStmt.executeUpdate(sql);
		}
		catch(Exception exc){
			exc.printStackTrace();

		}
		return true;

	}
	public String veiw_Waiting_Order(){
		String order_list = "";

		try{
			Statement myStmt = conn.createStatement();//...Create Statement
			ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee



			while (myRs.next()){


				order_list = myRs.getInt("Order_Num") + ", " + myRs.getInt("Table_Num") +", " + myRs.getString("Item_List")+", "+myRs.getString("Order_Status");

			}

		}
		catch(Exception exc){
			exc.printStackTrace();

		}
		return order_list;



	}
}
--------------------------------------------------------------------------------------------------------------------------------------------------
		package Final_Project;

//import java.util.ArrayList;
		import java.util.List;
		import java.sql.*;
		import java.util.ArrayList;
		import java.util.Arrays;




public class JDBC_OrderList {

	public Statement myStat;
	public ResultSet myRs;
	public int exc;

	Connection conn = Driver.getConnection();

	public boolean SendOrder(int tableNum, String accName,String order){

		try{
			//1: Create a statement
			myStat = conn.createStatement();

			//2: Execute SQL
			exc = myStat.executeUpdate("INSERT INTO Orders (Table_Num,Acc_Name,Item_List,Order_Total) VALUES ("+tableNum+",'"+accName+"','"+order+"',23.23);");

			//3: Process the result set
			/*while (myRs.next()){
				resultStr.add(myRs.getString("first_name")+" "+myRs.getString("last_name"));
			}*/
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}



		return true;


	}
	public boolean VoidItem(int item_num) {
		try{

			Statement myStmt = conn.createStatement();//...Create Statement
			ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee


			//String sql ="delete from orders where Order_Num ='Item_List'";
			String sql ="delete from orders" + "where Item_List = item_num";
			int rowsAffected = myStmt.executeUpdate(sql);
			myStmt.executeUpdate(sql);
		}
		catch(Exception exc){
			exc.printStackTrace();

		}
		return true;

	}


	public String veiw_Waiting_Order(){
		String order_list = "";

		try{
			Statement myStmt = conn.createStatement();//...Create Statement
			ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee



			List<String> firstCol = new ArrayList<String>();//close
			List<String> secondCol = new ArrayList<String>();
			while(myRs.next()){
				firstCol.add(myRs.getString("Order_Num"));
				secondCol.add(myRs.getString("Table_Num"));
				order_list = myRs.getString("Order_Num");
			}


			//order_list = (firstCol + secondCol);//myRs.getInt("Order_Num") + ", " + myRs.getInt("Table_Num") +", " + myRs.getString("Item_List")+", "+myRs.getString("Order_Status");



		}
		catch(Exception exc){
			exc.printStackTrace();

		}
		return order_list;



	}
}
-----------------------------------------------------------------------------------------------------------------------------------------------------
		package Final_Project;

//import java.util.ArrayList;
		import java.util.List;
		import java.sql.*;
		import java.util.ArrayList;
		import java.util.Arrays;



public class JDBC_OrderList {

	public Statement myStat;
	public ResultSet myRs;
	public int exc;

	Connection conn = Driver.getConnection();

	public boolean SendOrder(int tableNum, String accName,String order){

		try{
			//1: Create a statement
			myStat = conn.createStatement();

			//2: Execute SQL
			exc = myStat.executeUpdate("INSERT INTO Orders (Table_Num,Acc_Name,Item_List,Order_Total) VALUES ("+tableNum+",'"+accName+"','"+order+"',23.23);");

			//3: Process the result set
			/*while (myRs.next()){
				resultStr.add(myRs.getString("first_name")+" "+myRs.getString("last_name"));
			}*/
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}



		return true;


	}


	public boolean VoidItem(int item_num) {
		try{

			Statement myStmt = conn.createStatement();//...Create Statement
			ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee


			//String sql ="delete from orders where Order_Num ='Item_List'";
			String sql ="delete from orders" + "where Item_List = item_num";
			int rowsAffected = myStmt.executeUpdate(sql);
			myStmt.executeUpdate(sql);
		}
		catch(Exception exc){
			exc.printStackTrace();

		}
		return true;

	}


	public String veiw_WaitingOrder(){
		String order_list = "";
		String columnValue="";

		try{
			Statement myStmt = conn.createStatement();//...Create Statement

			ResultSet myRs = myStmt.executeQuery("select * from Orders");//...Execute SQL query Table name is employee
			ResultSetMetaData rsmd = myRs.getMetaData();


			int columnsNumber = rsmd.getColumnCount();

			while (myRs.next()) {
				for (int i = 1; i <= columnsNumber; i++) {
					//  System.out.println(" in for loop above if statement: "+ columnValue);
					if (i > 1)
						columnValue = myRs.getString(i);
					order_list = (rsmd.getColumnName(i) + "\n" +columnValue + myRs.getInt("Order_Num") );
					// System.out.println(" In if statement \n "+"Column value: "+ columnValue +"Coulmn Name:" );
					// order_list = Odr +" " +Tbl +" "+ Items +" "+ Odr_Stat;
					//order_list = myRs.getInt("Order_Num") + ", " + myRs.getInt("Table_Num") +", " + myRs.getString("Item_List")+", "+myRs.getString("Order_Status");
				}
				// System.out.println("out side of for loop"+columnValue);
			}
			System.out.println("columnsNumber: "+columnsNumber);
		}

		catch(Exception exc){
			exc.printStackTrace();

		}
		return order_list;



	}
}
