package Final_Project;

import java.util.LinkedList;
//import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.sql.*;



public class JDBC_OrderList {

	public Statement myStat;
	public ResultSet myRs;
	public int intmyRs;
	public int exc;
	public String str;

	Connection conn = Driver.getConnection();

	public boolean SendOrder(int tableNum, String accName,Item[] item){
		String order = "";
		for(int i=0; i<item.length;i++){
			int itemID=item[i].getId();

			if(itemID!=0){
				order+=item[i].getId();
			}
		}

		double total = 0;
		for(int i=0; i<item.length;i++){
			total+=item[i].getItemPrice();
		}
		try{
			//1: Create a statement
			myStat = conn.createStatement();

			//2: Execute SQL
			exc = myStat.executeUpdate("INSERT INTO Orders (Table_Num,Acc_Name,Item_List,Order_Total) VALUES ("+tableNum+",'"+accName+"','"+order+"',"+total+");");

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
	public Order getOrder(int id){
		Order resultOrder = null;

		try{	
			//1: Create a statement 
			myStat = conn.createStatement();
			//2: Execute SQL
			myRs = myStat.executeQuery("select * from orders WHERE Order_Num = "+id+";");
			//3: Process the result set
			while (myRs.next()){
				String itemidslist = myRs.getString("Item_List");
				Item[] finalArr=Order.parseId(itemidslist);

				resultOrder = new Order(myRs.getInt("Table_Num"), myRs.getString("Acc_Name"),finalArr,myRs.getInt("Order_Num"), myRs.getDouble("Order_Total"));
				//itemString = resultItem.toString();
			}
		}
		//catch any exception
		catch(Exception e){
			e.printStackTrace();
		}
		return resultOrder;

	}
	public double applyDiscount(Order order, double percentage){
		double total = order.getTotal();
		int id = order.getOrderNum();
		double ntotal = total -(total*(percentage/100));

		try{	
			//1: Create a statement 
			myStat = conn.createStatement();
			//2: Execute SQL
			intmyRs = myStat.executeUpdate("update orders set Order_Total ="+ntotal+" WHERE Order_Num = "+id+";");

		}
		catch(Exception e){
			e.printStackTrace();
		}

		return ntotal;

	}
	public boolean VoidItem(String item,Order order_num) {
		try{
			String collect="";
			int id=order_num.getOrderNum();
			Statement myStmt = conn.createStatement();//...Create Statement
			myRs = myStat.executeQuery("select * from orders WHERE Order_Num = "+order_num+";");//...Execute SQL query Table chooseing the OrderNum



			for(int i=0;i<order_num.itemList.length;i++)
			{
				if(item.equals(order_num.itemList[i])){
					order_num.itemList[i].setgetId(0); 
					order_num.itemList[i].setItemPrice(0);	
				}
				else{
					collect+=order_num.itemList[i];
				}
			}
			intmyRs = myStat.executeUpdate("update orders set Item_List = '"+collect+"' WHERE Order_Num = "+id+";");
			//if(order_num != 0){//most likely wrong

			//Integer.toString(item);

			//				for(int i=0;i<item.length();i++){
			//
			//
			//					//ids[i]=Character.getNumericValue(str.charAt(i));  access the character using .charAt()
			//					parsedItems[i] = il.selectItem(Character.getNumericValue(str.charAt(i)));
			//				}
			//myRs = myStat.executeQuery("select * from orders WHERE Item_List = "+item+";");
			//myRs.getString("Item_List")== item;
			//String sql ="delete from orders where Item_List = "+ item + ";";
			//}


			//JDBC_ItemList il = new JDBC_ItemList();
			//Item[] parsedItems = new Item[50];
			//create two loops one that looks for 
			//create an if statment that allows true then void item  





			//String sql ="delete from orders where Order_Num ='Item_List'";
			//String sql ="delete from orders where Item_List = "+ item + ";";

			//int rowsAffected = myStmt.executeUpdate(sql);
			//myStmt.executeUpdate(sql);
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

			Queue<String> myQueue = new LinkedList<String>();
			Queue<Integer> myNumbers = new LinkedList<Integer>();
			myQueue.add("");
			myQueue.add("");
			myNumbers.add(1);
			myNumbers.add(2);

			while (myRs.next()){


				order_list += " OrderNumber: \n"+myRs.getInt("Order_Num") + "\n Table Number: \n " + myRs.getInt("Table_Num") +"\n Item List: \n " + myRs.getString("Item_List")+"\n Order Stat: \n "+myRs.getString("Order_Status");

			}

		}
		catch(Exception exc){
			exc.printStackTrace();

		}
		return order_list;



	}
}
