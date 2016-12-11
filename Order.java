package Final_Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import org.apache.commons.lang3.ArrayUtils;



public class Orders {
	public Statement myStat;
	public ResultSet myRs;
	public int intmyRs;
	public int exc;
	public String str;
	public int tableNum;
	public String UserName;
	public Item[] itemList;
	public int OrderNum;
	public double total;
	
	public Orders(){}//default constructor
	Connection conn = Driver.getConnection();
	
	public Orders(int tableNum,  String UserName, Item[] itemList, int OrderNum, double total){
		this.tableNum = tableNum;
		this.UserName = UserName;
		this.itemList = itemList;
		this.OrderNum = OrderNum;
		this.total = total;
	}


	public int getTableNum() {
		return tableNum;
	}

	public void setTableNum(int tableNum) {
		this.tableNum = tableNum;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Item[] getItemList() {
		return itemList;
	}

	public void setItemList(Item[] itemList) {
		this.itemList = itemList;
	}

	public int getOrderNum() {
		return OrderNum;
	}

	public void setOrderNum(int orderNum) {
		OrderNum = orderNum;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	

	public static Item[] parseId(String str){
		
		JDBC_ItemList il = new JDBC_ItemList();
		Item[] parsedItems = new Item[50];
		for(int i=0;i<str.length();i++){
			//ids[i]=Character.getNumericValue(str.charAt(i));  access the character using .charAt()
			parsedItems[i] = il.selectItem(Character.getNumericValue(str.charAt(i)));
		}
		return parsedItems;
	}
	
//	public Item[] deleteItem(Order order,int itemID){
//		Item[] list = order.getItemList();
//		for(int i=0;i<list.length;i++){
//			if(list[i].getId()==itemID){
//				list = ArrayUtils.remove(list, i);
//		}
//		
//	}
//		return list;
//	}
	public boolean VoidItem(int item,int id) {
		try{
			String collect="";

			Statement myStmt = conn.createStatement();//...Create Statement
			myRs = myStmt.executeQuery("select * from orders WHERE Order_Num = "+id+";");//...Execute SQL query Table chooseing the OrderNum

			while (myRs.next()){
				collect=myRs.getString("Item_List");

				StringBuilder bulid = new StringBuilder(collect);
				
				for(int i=0;i<collect.length();i++)
				{
					int compare=Character.getNumericValue(collect.charAt(i));
					
					if(compare==item){//go through each charater and compare item that integer thats input
						
						bulid.deleteCharAt(i); 
						collect=bulid.toString();
						intmyRs = myStmt.executeUpdate("update orders set Item_List = '"+collect+"' WHERE Order_Num = "+id+";");		
					}
					//else
					//	System.out.println("nothing in here");
				}


			}
		}
		catch(Exception exc){
			
			return false;

		}
		return true;

	}

	
	public String toString(){
		String displayItems ="";
		for(int i=0;i<itemList.length;i++){
			displayItems += itemList[i].getItemName()+" ";
		}
		String orderToString = "Order: "+OrderNum+"\n"+"Table No: "+tableNum +"\n"+ "User: "+UserName +"\n"+"Total: "+ total+ "\n"
				+ "Items: "+ displayItems;
			
		
		return orderToString;
	}
	
	public String altString(){
		String orderToString = "Order: "+OrderNum+"\n"+"Table No: "+tableNum +"\n"+ "User: "+UserName +"\n"+"Total: "+ total;
			
		return orderToString;
		
	}
}
