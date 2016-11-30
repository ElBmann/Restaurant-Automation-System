package Final_Project;

public class Order {
	
	public int tableNum;
	public String UserName;
	public Item[] itemList;
	public int OrderNum;
	public double total;
	
	public Order(int tableNum,  String UserName, Item[] itemList, int OrderNum, double total){
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

	
}