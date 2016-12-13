//package Final_Project;
//import java.util.Scanner;
//import java.util.Iterator;
//import Final_Project.Driver;
//import java.sql.*;
//
//public class testMain {
//
//	private static Scanner input = new Scanner(System.in);
//
//	public static void main(String[] args) {		
//		AccountList AccountList = new AccountList();
//		Account AccountPlaceHolder = new Account();
//		JDBCAccountList JDBCAccountList = new JDBCAccountList();
//		JDBC_OrderList jd = new JDBC_OrderList();
//		JDBC_ItemList it = new JDBC_ItemList();
//		JDBC_Floor fl = new JDBC_Floor();
//		Orders odr= new Orders();
//
//
//
//
//	//	jd.veiw_Waiting_Order();
//
//
//
//		//Temporary Login Function
//		//Does not divide up menus yet
//		System.out.println("WELCOME TO RAS\n\nLogin: ");
//
//		boolean LoginLoop = true;
//		String LoginPin = "";
//		Account Account = null;
//
//		while (LoginLoop){
//			Scanner input = new Scanner(System.in); //Prevents infinite loop
//			LoginPin = input.next();
//			if (JDBCAccountList.PinChecker(LoginPin)){ //Checks if pin is in the system and if it matches
//				Account = new Account();
//				Account.setPin(LoginPin);
//				System.out.println("Login successful.\n");
//				LoginLoop = false;
//			}
//			else{
//				System.out.println("Incorrect Pin. Try again.\nLogin: ");
//			}
//		}
//		//End Temporary Login Function
//
//		input = new Scanner(System.in);
//		int menu=0;
//		
//		
//		do{
//
//			System.out.println("Select an option:\n1: Add Employee\n2: Remove Employee\n3: Edit Employee"
//					+ "\n4: View Daily Sales \n5: Add Order \n6: Logout\n10: VoidItem \n6: Logout \n11: viewWaitingOrder \n12: Quit\n");
//			menu = input.nextInt();
//
//			switch(menu){
//
//			case 1: //AddEmployee
//				String newName = "";
//				String newPin = "";
//				String newPosition = "";
//				Double newSales = 0.0;
//
//				boolean SalesLoop = true;
//				boolean NameLoop = true;
//				boolean PositionLoop = true;
//				boolean PinLoop = true;
//
//				while (NameLoop){
//					System.out.println("Enter a Name: ");
//					Scanner input = new Scanner(System.in); //Prevents infinite loop
//					if(ValidName(newName = input.next()) ){ //Checks for numbers
//						NameLoop = false;
//					}
//					else{
//						System.out.println("No numbers allowed.");
//					}
//				}
//
//				while (PinLoop){
//					System.out.println("Enter a Pin: ");
//					Scanner input = new Scanner(System.in); //Prevents infinite loop
//					newPin = input.next();
//					if (!duplicate(newPin)){ //Checks if it is duplicate
//						PinLoop = false;
//					}
//					else{
//						System.out.println("Duplicate Pin. Try again.");
//					}
//				}
//
//				while (PositionLoop)
//				{
//					System.out.println("--------\nManager \nServer \nBusboy \nWaiter \nKitchen \nCook\n--------");
//					System.out.println("Enter one of the above position terms: ");
//					Scanner input = new Scanner(System.in); //Prevents infinite loop
//					//Checks for numbers and if there are matching terms
//					if(ValidName(newPosition = input.next()) & (newPosition.equals("Manager")||
//							newPosition.equals("Server")||newPosition.equals("Busboy")||
//							newPosition.equals("Waiter")|| newPosition.equals("Kitchen")
//							||newPosition.equals("Cook")) ){ 
//						PositionLoop = false;
//					}
//					else{
//						System.out.println("Submission must match one of the position terms.");
//					}
//				}
//				//Realistically we don't set sales when creating employee
//				while(SalesLoop){
//					try{
//						SalesLoop = false;
//						Scanner input = new Scanner(System.in); //Prevents infinite loop
//						System.out.println("Enter Sales: ");
//						newSales = input.nextDouble();
//					}
//					catch(Exception e){
//						System.out.println("Invalid submission. Input a number for sales: ");
//						SalesLoop = true;
//					}
//				}
//
//				try{
//					AccountList.AddEmployee(newName, newPin, newPosition, 0.0);
//					System.out.println("Employee is successfully added.");}
//				catch(Exception e){}
//				//Add Employee to ArrayList AccountList
//				break;
//
//
//			case 2: //RemoveEmployee
//				int ID = -1;
//				boolean Loop = true;
//
//				while(Loop){
//					try{
//						Loop = false;
//						Scanner input = new Scanner(System.in); //Prevents infinite loop
//						System.out.println("Enter ID of Employee to remove: ");
//						ID = input.nextInt();
//					}
//					catch(Exception e){
//						System.out.println("Invalid submission. Input an ID number: ");
//						Loop = true;
//					}
//				}
//				try{
//					AccountList.RemoveEmployee(ID);
//					System.out.println("Employee is removed.");
//
//					//Shows the account to the user one last time using toString.
//				}
//				catch(Exception e){}
//				break;
//
//			case 3: //Edit Employee
//
//				boolean editLoop = true;
//				int newID = -999;
//				int currentID = -999;
//				String currentPin = "";
//				String currentName = "";
//				String currentPosition = "";
//				double currentHours = 0.0;
//				double currentSales = 0.0;
//				double currentPayRate = 0.0;
//
//				//ID
//				do{ //Loop keeps happening if there's an invalid 
//					//submission or if there's no existing ID.
//					try{
//						editLoop = false;
//						Scanner input = new Scanner(System.in); //Prevents infinite loop
//						System.out.println("Enter a valid existing ID of an employee to be edited: ");
//						newID = input.nextInt();
//						currentPin = JDBCAccountList.JDBCgetPin(newID);
//						currentName = JDBCAccountList.JDBCgetName(Account.getPin());
//						currentPosition = JDBCAccountList.JDBCgetPosition(Account.getPin());
//					}
//					catch(Exception e){
//						System.out.println("");
//						editLoop = true;
//					}
//				}
//				while(editLoop & !IDduplicate(newID));
//
//				//Collect all current variables
//				Iterator<Account> iterator = AccountList.AccountList.iterator();
//				while (iterator.hasNext()) {//Goes through the ArrayList
//					AccountPlaceHolder.setEqualTo((Account)iterator.next());
//					//setEqualTo method will set the AccountPlaceHolder values 
//					//to be equal to the iterator ones
//					int CheckID = AccountPlaceHolder.getID();
//					if(CheckID == newID){
//						currentID = newID;
//						currentPin = JDBCAccountList.JDBCgetPin(newID);
//						currentName = JDBCAccountList.JDBCgetName(Account.getPin());
//						currentPosition = JDBCAccountList.JDBCgetPosition(Account.getPin());
//						currentHours = AccountPlaceHolder.getHours();
//						currentSales = AccountPlaceHolder.getSales();
//						currentPayRate = AccountPlaceHolder.getPayRate();
//					}
//				}
//
//				//Name
//				boolean QuestionLoop = true;
//				String AnswerQuestion = "";
//
//				while (QuestionLoop){
//					System.out.println("Change Name? (Yes or No): ");
//					Scanner input = new Scanner(System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(ValidName(AnswerQuestion) & (AnswerQuestion.equals("Yes") || 
//							AnswerQuestion.equals("No"))){ //Checks for numbers and for Yes or No
//						QuestionLoop = false;
//					}
//				}
//				if(AnswerQuestion.equals("Yes")){
//					QuestionLoop = true;
//					while(QuestionLoop){
//						System.out.println("Enter new Name: ");
//						Scanner input = new Scanner(System.in); //Prevents infinite loop
//						if(ValidName(AnswerQuestion = input.next())){		
//							QuestionLoop = false;
//						}
//					}
//					currentName = AnswerQuestion;
//				}
//
//				//Pin 
//				QuestionLoop = true;
//				AnswerQuestion = "";
//
//				while(QuestionLoop){
//					System.out.println("Change Pin? (Yes or No): ");
//					Scanner input = new Scanner(System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(AnswerQuestion.equals("Yes") || AnswerQuestion.equals("No")) {
//						QuestionLoop = false;
//					}
//				}
//				if(AnswerQuestion.equals("Yes")){
//					QuestionLoop = true;
//					while(QuestionLoop){
//						System.out.println("Enter new Pin: ");
//						Scanner input = new Scanner(System.in); //Prevents infinite loop
//						if(!duplicate(AnswerQuestion=input.next())){
//							QuestionLoop = false;
//						}
//					}
//					currentPin = AnswerQuestion;
//				}
//
//				//Position
//				QuestionLoop = true;
//				AnswerQuestion = "";
//
//				while(QuestionLoop){
//					System.out.println("Change Position? (Yes or No): ");
//					Scanner input = new Scanner (System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(AnswerQuestion.equals("Yes") || AnswerQuestion.equals("No")) {
//						QuestionLoop = false;
//					}					
//				}
//				if(AnswerQuestion.equals("Yes")){
//					QuestionLoop = true;
//					while(QuestionLoop){
//						System.out.println("Enter new Position: ");
//						Scanner input = new Scanner(System.in); //Prevents infinite loop
//						AnswerQuestion = input.next();
//						if(AnswerQuestion.equals("Manager") || AnswerQuestion.equals("Server") || AnswerQuestion.equals("Waiter")
//								||AnswerQuestion.equals("Busboy") ||AnswerQuestion.equals("Kitchen") ||AnswerQuestion.equals("Cook")){
//							QuestionLoop = false;
//						}
//					}
//					currentPosition= AnswerQuestion;
//				}
//
//				//Hours
//				QuestionLoop = true;
//				double AnswerQuestionDouble = 0.0;
//				AnswerQuestion = "";
//
//				while(QuestionLoop){
//					System.out.println("Change Hours? (Yes or No): ");
//					Scanner input = new Scanner (System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(AnswerQuestion.equals("Yes") || AnswerQuestion.equals("No")) {
//						QuestionLoop = false;
//					}	
//				}
//
//				if(AnswerQuestion.equals("Yes")){
//					QuestionLoop = true;
//					while(QuestionLoop){
//						System.out.println("Enter new Hours (at least 0.0): ");
//						Scanner input = new Scanner (System.in); //Prevents infinite loop
//						try{
//							AnswerQuestionDouble = input.nextDouble();
//							if(AnswerQuestionDouble >= 0.0){
//								QuestionLoop = false;
//							}
//						}
//						catch(Exception e){System.out.println("Must be a number.");}
//					}
//					currentHours = AnswerQuestionDouble;
//				}
//
//				//Sales
//				QuestionLoop = true;
//				AnswerQuestionDouble = 0.0;
//				AnswerQuestion = "";
//
//				while(QuestionLoop){
//					System.out.println("Change Sales? (Yes or No): ");
//					Scanner input = new Scanner (System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(AnswerQuestion.equals("Yes") || AnswerQuestion.equals("No")) {
//						QuestionLoop = false;
//					}	
//				}
//
//				if(AnswerQuestion.equals("Yes")){
//					QuestionLoop = true;
//					while(QuestionLoop){
//						System.out.println("Enter new Sales (at least 0.0): ");
//						Scanner input = new Scanner (System.in); //Prevents infinite loop
//						try{
//							AnswerQuestionDouble = input.nextDouble();
//							if(AnswerQuestionDouble >= 0.0){
//								QuestionLoop = false;
//							}
//						}
//						catch(Exception e){System.out.println("Must be a number.");}
//					}
//					currentSales = AnswerQuestionDouble;
//				}
//
//				//PayRate
//				QuestionLoop = true;
//				AnswerQuestionDouble = 0.0;
//				AnswerQuestion = "";
//
//				while(QuestionLoop){
//					System.out.println("Change PayRate? (Yes or No): ");
//					Scanner input = new Scanner (System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(AnswerQuestion.equals("Yes") || AnswerQuestion.equals("No")) {
//						QuestionLoop = false;
//					}	
//				}
//
//				if(AnswerQuestion.equals("Yes")){
//					QuestionLoop = true;
//					while(QuestionLoop){
//						System.out.println("Enter new PayRate (at least 7.0): ");
//						Scanner input = new Scanner (System.in); //Prevents infinite loop
//						try{
//							AnswerQuestionDouble = input.nextDouble();
//							if(AnswerQuestionDouble >= 7.0){
//								QuestionLoop = false;
//							}
//						}
//						catch(Exception e){System.out.println("Must be a number.");}
//					}
//					currentPayRate = AnswerQuestionDouble;
//				}
//
//				//Call the AccountList EditEmployee function
//				try{AccountList.EditEmployee(newID, currentPin, currentName, currentPosition, currentHours, currentSales, currentPayRate);
//				System.out.println("Employee edited successfully.");}
//				catch(Exception e){}
//
//				break;				
//			case 4:
//				System.out.println(it.getItems()); 
//				break;
//			case 5://Send Order
//				System.out.println(it.getItems());
//				System.out.println("Select 3 items and add to array");
//				Item[] items = new Item[3];
//
//				for(int i=0; i<items.length;i++){
//					items[i] = it.selectItem(input.nextInt()); 
//				}
//
//				System.out.println("Enter Table Number");
//				int num = input.nextInt();
//				System.out.println("Enter Account Name");
//				String name = input.next();
//				boolean test =jd.SendOrder(num, name, items);
//				if(test = true){
//					System.out.print("Order Successfully Sent\n");;
//				}
//				else
//					System.out.print("Whoops Something Went Wrong!\n");
//				break;
//			case 6:
//				System.out.println("1. 10%   2. 25%\n"+
//						"3. 50%   4. 100%\n\n"
//						+ "Select a discount rate");
//				int p = input.nextInt();
//				if(p==1)
//					p=10;
//				if(p==2)
//					p=25;
//				if(p==3)
//					p=50;
//				if(p==4)
//					p=100;
//				System.out.println("Select an OrderNum");
//				int id=input.nextInt();
//				String s = jd.getOrder(id).altString();
//				System.out.print(s+"\n");
//				Orders o=jd.getOrder(id);
//				double d =jd.applyDiscount(o, p);
//				System.out.println("New Total "+d);
//				//System.out.println(o.toString()+"\n");
//				break;
//
//			case 7:
//				System.out.println("-----------------------------------------------");
//				System.out.println("Add Table: Enter Table Number");
//				int num1 =input.nextInt();
//				System.out.println("Add Table: Enter Table Size");
//				int size = input.nextInt();
//				boolean test1 = fl.addTable(num1,size);
//				if(test1==true)
//					System.out.println("Table #"+num1+" successfully added");
//				else
//					System.out.println("Table #"+num1+" already exists");
//				System.out.println("-----------------------------------------------");
//				break;
//			case 8:
//				System.out.println("-----------------------------------------------");
//				System.out.println("Remove Table: Enter Table Number");
//				int numDel =input.nextInt();
//				Table r = fl.removeTable(numDel);
//				if(r==null)
//					System.out.println("Table #"+numDel+" was not found");
//				else
//				{
//					System.out.println("The following Table was removed:");
//					System.out.println(r.toString());
//				}
//				System.out.println("-----------------------------------------------");
//				break;
//			case 9:
//				System.out.println("-----------------------------------------------");
//				System.out.print(fl.toString());
//				System.out.println("-----------------------------------------------");
//				break;
//
//			case 10://void Item
//				boolean	Question = true;
//				AnswerQuestion = "";
//				int order_num = 0;
//				int item=0;
//				while(Question){
//					System.out.println("Would you Like to Void Item? (Yes or No): ");
//					Scanner input = new Scanner (System.in); //Prevents infinite loop
//					AnswerQuestion = input.next();
//					if(AnswerQuestion.equals("Yes") || AnswerQuestion.equals("No")||AnswerQuestion.equals("yes")|| AnswerQuestion.equals("no")
//							||AnswerQuestion.equals("YES")|| AnswerQuestion.equals("NO")) {
//						Question = false;
//					}	
//				}
//
//				if(AnswerQuestion.equals("Yes")||AnswerQuestion.equals("yes")||AnswerQuestion.equals("YES")){
//					Question = true;
//
//					while(Question){
//
//
//
//						Scanner input = new Scanner (System.in); //Prevents infinite loop
//						try{
//							System.out.println("Enter Order Number\n");
//							order_num = input.nextInt();//issue
//
//							System.out.println(" Enter Item ");
//							item=input.nextInt();
//							Question=false;
//
//						}
//						catch(Exception e){System.out.println("Must be a number.");}
//					}
//					try{
//						if(odr.VoidItem(item,order_num)){
//							System.out.println("Item Voided");
//
//						}
//						else{
//
//							System.out.println("Item Voided");
//
//						}
//					}
//					catch(Exception e){System.out.println("Must be a number.");}
//				}
//
//				break;
//
//			case 11:	//viewWaitng Order
//                System.out.println("You have selected: View Wating Orders");
//				jd.veiw_Waiting_Order();
//				break;
//			case 12:	//Quit
//
//				System.out.println("RAS is now offline.");
//				break;
//			}	
//		}
//		while (menu!=11);
//	}
//	//Checks for numbers in Name inputs
//	public static boolean ValidName(String name)
//	{
//		if (name.matches(".*[0-9].*")){ 
//
//			return false;
//		} 
//		return true;
//	}//End ValidName
//
//	//Duplicate Pin Checker
//	public static boolean duplicate(String Pin){
//		Iterator iterator = AccountList.AccountList.iterator();
//		while(iterator.hasNext()){
//			if(((Account) iterator.next()).getPin().equals(Pin)){return true;}
//		}
//		return false; //Returning false means that there are no duplicates
//
//	}//End duplicateChecker
//
//	//Duplicate ID Checker
//	public static boolean IDduplicate(int ID){
//		Iterator iterator = AccountList.AccountList.iterator();
//		while(iterator.hasNext()){
//			if(((Account) iterator.next()).getID() == ID){return true;}
//		}
//		return false; //Returning false means that there are no duplicates
//
//	}//End IDChecker
//
//
//
//}//End Class
//
//
//
//
//
