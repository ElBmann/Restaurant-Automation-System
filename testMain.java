package Final_Project;
import java.util.Scanner;

import Final_Project.Driver;

import java.sql.*;
public class testMain {

	private static Scanner input;
	public static Statement myStat;
	public static ResultSet myRs;
	public int intmyRs;
	public int exc;
	 static Connection conn = Driver.getConnection();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		JDBC_OrderList jd = new JDBC_OrderList();
		JDBC_ItemList it = new JDBC_ItemList();
		int menu=0;
		do{

			System.out.println("Please Select choice: \n"+ "1:ViewMenu "+ "\n2:CreateOrder \n"+
					"3:viewwaitngOrder"+"\n4:ApplyDiscount" +" \n5:Void Item"+"\n6:Exit");
			menu = input.nextInt();

			switch(menu){

			case 1:
				System.out.println(it.getItems()); 
				break;


			case 2:
				System.out.println(it.getItems());
				System.out.println("Select 3 items and add to array");
				Item[] items = new Item[3];

				for(int i=0; i<items.length;i++){
					items[i] = it.selectItem(input.nextInt()); 
				}

				System.out.println("Enter Table Number");
				int num = input.nextInt();
				System.out.println("Enter Account Name");
				String name = input.next();
				boolean test =jd.SendOrder(num, name, items);
				if(test = true){
					System.out.print("Order Successfully Sent\n");;
				}
				else
					System.out.print("Whoops Something Went Wrong!\n");
				break;


			case 3:
				JDBC_OrderList view = new JDBC_OrderList();
				System.out.println("  "+ view.veiw_Waiting_Order());

				break;
			case 4:
				System.out.println("1. 10%   2. 25%\n"+
						"3. 50%   4. 100%\n\n"
						+ "Select a discount rate");
				int p = input.nextInt();
				if(p==1)
					p=10;
				if(p==2)
					p=25;
				if(p==3)
					p=50;
				if(p==4)
					p=100;
				System.out.println("Select an OrderNum");
				int id=input.nextInt();
				String s = jd.getOrder(id).toString();
				System.out.print(s+"\n");
				Order o=jd.getOrder(id);
				double d =jd.applyDiscount(o, p);
				System.out.println("New Amount "+d);
				break;
		
			case 5://void Item
				   JDBC_OrderList JDBC_OrderList = new JDBC_OrderList();//make sure to change this up later Object
				System.out.println("Enter Order Number ");
				Order order_num = input.nextInt();//issue
				System.out.println("Enter Item you want removed");
				String item=input.next();
				
				Statement myStmt = conn.createStatement();//...Create Statement
				myRs = myStat.executeQuery("select Table_Num  from orders WHERE Order_Num = "+order_num+";");//...Execute SQL query Table chooseing the OrderNum
				myRs = myStat.executeQuery("select Acc_Name from orders WHERE Order_Num = "+order_num+";");
				myRs = myStat.executeQuery("select Order_Status from orders WHERE Order_Num = "+order_num+";");
				myRs = myStat.executeQuery("select Order_Date from orders WHERE Order_Num = "+order_num+";");
				JDBC_OrderList.VoidItem(item, order_num);///im having an issue here! 
			case 6:
				System.out.println("You have chosen to exit Peace out");
				break;


			default:

				System.out.println("You Failed to pick the right option");
			}

			/*JDBC_ItemList it = new JDBC_ItemList(); 		
		System.out.println(it.getItems()); */

			//Tests out selecting an item from the db and creating an object
			/*JDBC_ItemList it = new JDBC_ItemList();
		System.out.println(it.getItems());
		System.out.println("Enter an integer");
		int num1 = input.nextInt();
		System.out.println(it.selectItem(num1).toString());*/


		}
		while (menu!=6);
	}

}
