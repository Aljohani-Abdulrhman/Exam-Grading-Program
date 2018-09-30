/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class Item {

	// -------Attribute--------

	private int itemID;
	private String itemName;
	private double price;
	private Seller owner;
	private int inStock;

	// -------Actions--------

	public Item(int itemID, String itemName, double price, int inStock, Seller owner) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.price = price;
		this.owner = owner;
		this.inStock = inStock;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Seller getOwner() {
		return owner;
	}

	public void setOwner(Seller owner) {
		this.owner = owner;
	}

	public int getInStock() {
		if (this.inStock == -1) {
			return 0;
		} else {
			return this.inStock;
		}
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Item itemID= " + this.itemID + ", itemName= " + this.itemName + ", price= " + this.price + ", owner= "
				+ this.owner + ", inStock= " + this.inStock;
	}

}
