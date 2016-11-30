package Final_Project;
import java.util.Scanner;

public class testMain {

	private static Scanner input;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		int menu=0;
		
		do{
		
		System.out.println("Please Select choice: \n"+ "1: Enter Order "+ "\n2: Void Item \n"+"3: Veiw waitng orders ");
		menu = input.nextInt();
		
		switch(menu){
		
		case 1:
		System.out.println("Enter Table Number");
		int num = input.nextInt();
		System.out.println("Enter Account Name");
		String name = input.next();
		System.out.println("Enter Items");
		String items = input.next();
		
		JDBC_OrderList jd = new JDBC_OrderList();
		jd.SendOrder(num, name, items);
		break;
		
		
		case 2:
			//System.out.println("Enter item you want to void");
		//	int item_key = input.nextInt();
			
			//JDBC_OrderList j = new JDBC_OrderList();
			//j.VoidItem(item_key);
		
		
		break;
		case 3:
			JDBC_OrderList view = new JDBC_OrderList();
			System.out.println(" "+ view.veiw_Waiting_Order());
			
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
		while (menu!=5);
	}

}
