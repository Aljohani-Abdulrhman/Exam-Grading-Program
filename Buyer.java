/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class Buyer extends Trader {

	// -------Attribute--------

	private Order[] order;
	private final int MAXIMUM_ALLOWED_ORDERS = 30;
	private int orderCounter;
	private static int orderId = 100;

	// -------Actions--------

	public Buyer(int id, String name, String nationality, Date dateOfBirth, char gender, int phone, String address) {
		super(id, name, nationality, dateOfBirth, gender, phone, address);
		this.order = new Order[MAXIMUM_ALLOWED_ORDERS];
	}

	public Order[] getOrder() {
		return order;
	}

	public Order getOrder(int index) {
		return this.order[index];
	}

	public StringBuilder initalizeOrder(int buyerId, int totItem) {

		StringBuilder result;

		if (orderCounter > MAXIMUM_ALLOWED_ORDERS) {// check if the order more then 30 or not
			result = new StringBuilder("The buyer with id : " + buyerId + " is exceeded the limit for buy\n");
		} else {// if not
			order[orderCounter] = new Order("in proccing", totItem);// create new object
			order[orderCounter].setOrderId(++orderId);// set Order id

			result = new StringBuilder("The order of buyer with id : " + buyerId
					+ " has been initialized with number : " + order[orderCounter].getOrderId());
			orderCounter++;// increment oredrCounter

		}

		return result;

	}

	// to getOrderCounter
	public int getOrderCounter() {
		return this.orderCounter;
	}

	// to getOrderId
	public int getOrderId() {
		return orderId;
	}

}
