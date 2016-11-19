/**
 * <p>The bridge class Order List contains Void Item & ViewWaitingOrder.
 * Void Item will give the user the ability to void an item after the order
 * has been placed. ViewWaitingOrder allows the User to view all incoming orders
 * that need to be fulfilled.This class will be invoke from the methods in the JDBCOrder_List.
 *
 * @author Brian Recuero
 * @version 1.0 Build 1 Nov, 11, 2016
 *
 */

/**
 * Has several different methods
 * Void Item,OrderList
 *
 */
public class Order_list {
    /**
     * Void items after the order has been placed.
     * @return if true there are items to void and if false nothing to void
     * 
     */
    public boolean VoidItem() {

    }

    /**
     *  
     * using JDBC the items stored in the database will be place in an array and return the list of orders.
     * @return List of items in each order.
     */
    public order[] ViewWaitingOrder(){

    }

}

