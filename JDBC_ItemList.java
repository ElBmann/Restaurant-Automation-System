package Final_Project;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class JDBC_ItemList {

	public Statement myStat;
	public ResultSet myRs;
	Connection conn = Driver.getConnection();

	//returns all current items in the db
	public List<String> getItems(){

		List<String> resultStr = new ArrayList<String>();

		try{	
			//1: Create a statement 
			myStat = conn.createStatement();

			//2: Execute SQL
			myRs = myStat.executeQuery("select * from Item_List");

			//3: Process the result set
			while (myRs.next()){
				resultStr.add(myRs.getString("Item_ID")+" "+myRs.getString("Item_Name"));
			}
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}
		return resultStr;

	}

	//this function returns a item from the db table Item_List
	public Item selectItem(int id){
		Item resultItem = null;
		try{	
			//1: Create a statement 
			myStat = conn.createStatement();

			//2: Execute SQL
			myRs = myStat.executeQuery("select * from Item_List WHERE Item_ID = "+id+";");

			//3: Process the result set
			while (myRs.next()){
				resultItem = new Item(myRs.getInt("Item_ID"), myRs.getString("Item_Name"), myRs.getString("Item_Type"), myRs.getDouble("Item_Price"));
				//itemString = resultItem.toString();
			}
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}
		return resultItem;

	}

}
