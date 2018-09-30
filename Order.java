/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class Order {

	// -------Attribute--------
	private static int orderCounter;
	private String orderDesc;
	private int itemCounter;
	private Item[] items;
	private int orderId;
	private double weightOfPackageingKG;
	private LogisticPartner logisticPartner;
	private Date orderDate;
	private double amount =0;

	// -------Actions--------
	public Order(String orderDesc, int totItem) {
		this.orderDesc = orderDesc;
		this.items = new Item[totItem];
		this.orderDate = new Date();
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int getOrderId() {
		return orderId;

	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;

	}

	public double getWeightOfPackageingKG() {
		return weightOfPackageingKG;
	}

	public void setWeightOfPackageingKG(double weightOfPackageingKG) {
		this.weightOfPackageingKG = weightOfPackageingKG;
	}

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}

	public Item[] getItems() {
		return items;
	}

	public void addItems(Item item) {
		// check if the Counter is bigger than items length
		if (itemCounter < items.length) {
			this.items[itemCounter] = item;// if true add item
			items[itemCounter].setInStock(items[itemCounter].getInStock() - 1);// decrement inStock
			this.amount += items[itemCounter].getPrice();
			itemCounter++;// increment item counter
		}
	}

	public static int getOrderCounter() {
		return orderCounter;
	}

	public LogisticPartner getLogisticPartner() {
		return logisticPartner;
	}

	public void setLogisticPartner(LogisticPartner logisticPartner) {
		this.logisticPartner = logisticPartner;
	}

	public int getItemCounter() {
		return itemCounter;
	}

	public void setItemCounter(int itemCounter) {
		this.itemCounter = itemCounter;
	}

	public Item getitem(int index) {
		return this.items[index];
	}


	public double getAmount() {
		return this.amount;
	}


	



	
	
	
	

	
	

	
}
