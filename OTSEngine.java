/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.awt.ItemSelectable;
import java.awt.event.ItemEvent;
import java.util.Date;

public class OTSEngine {

	private Item[] items;
	private Buyer[] buyers;
	private Seller[] sellers;
	private LogisticPartner[] logisticPartners;
	private int itemCounter;
	private int buyersCounter;
	private int sellersCounter;
	private int logisticPartnersCounter;

	public OTSEngine(int numberOfItems, int numberOfBuyers, int numberOfSellers, int numberOflogisticPartner) {
		this.items = new Item[numberOfItems];
		this.buyers = new Buyer[numberOfBuyers];
		this.sellers = new Seller[numberOfSellers];
		this.logisticPartners = new LogisticPartner[numberOflogisticPartner];
	}

	public StringBuilder addItem(int itemId, String itemName, double price, int inStock, int sellerId) {

		boolean check = false;// use check to determine is id in the system or not
		int index2 = 0;

		int index = 0;// to save index of id in sellers object
		for (int i = 0; i < sellersCounter; i++) {
			if (sellerId == sellers[i].getId()) {// check if the sellerId equals the id sellers in the system
				index = i;// if true assign the index of this sellers id object which is i to index
			}
		}

		if (itemCounter == 0) {
			// sellers[index] means the sellers object with this Specific(index) relate with
			// this item object
			items[itemCounter] = new Item(itemId, itemName, price, inStock, sellers[index]);
			itemCounter++;
		}

		// check about id is there in system or not
		for (int i = 0; i < itemCounter; i++) {
			if (items[i].getItemID() == itemId) {
				if (i == 0) {// here i want to jump number 0 because is there in system
					return new StringBuilder("The item : " + items[i].getItemID() + " has been added to the System ");

				} else {

					check = true;
				}
			}
		}

		// means the id not in the System
		if (check == false) {
			items[itemCounter] = new Item(itemId, itemName, price, inStock, sellers[index]);
			itemCounter++;
		} else {// means the id is there
			return new StringBuilder("The item : " + itemId + " already exists\n");
		}

		return new StringBuilder(
				"The item : " + itemId + " has been added to the System " + sellers[index].getId() + "\n");
	}

	public StringBuilder addSeller(int id, String name, String nationality, Date dateOfBirth, int year, int month,
			int day, char gender, int licenseNo, String company, int regNumber, boolean operational, int phone,
			String address) {

		boolean check = false;// use check to determine is id in the system or not

		if (sellersCounter == 0) {
			sellers[sellersCounter] = new Seller(id, name, nationality, dateOfBirth, gender, phone, address, company,
					regNumber, operational, licenseNo);
			sellersCounter++;
		}

		// check about id is there in system or not
		for (int i = 0; i < sellersCounter; i++) {
			if (sellers[i].getId() == id) {
				if (i == 0) {// here i want to jump number 0 because is there in system
					return new StringBuilder(
							"The seller with id : " + sellers[i].getId() + " has been added to the System\n");
				} else {
					check = true;
				}
			}
		}

		// means the id not in the System
		if (check == false) {
			sellers[sellersCounter] = new Seller(id, name, nationality, dateOfBirth, gender, phone, address, company,
					regNumber, operational, licenseNo);
			sellersCounter++;
		} else {// means the id is there
			return new StringBuilder("The seller with id : " + id + " already exists\n");
		}

		return new StringBuilder("The seller with id : " + id + " has been added to the System\n");
	}

	public StringBuilder addBuyer(int id, String name, String nationality, Date dateOfBirth, int year, int month,
			int day, char gender, int phone, String address) {

		boolean check = false;// use check to determine is id in the system or not

		if (buyersCounter == 0) {
			buyers[buyersCounter] = new Buyer(id, name, nationality, dateOfBirth, gender, phone, address);
			buyersCounter++;
		}

		// check about id is there in system or not
		for (int i = 0; i < buyersCounter; i++) {
			if (buyers[i].getId() == id) {
				if (i == 0) {// here i want to jump number 0 because is there in system
					return new StringBuilder(
							"The buyer with id : " + buyers[i].getId() + " has been added to the System\n");
				} else {
					check = true;
				}
			}
		}

		// means the id not in the System
		if (check == false) {
			buyers[buyersCounter] = new Buyer(id, name, nationality, dateOfBirth, gender, phone, address);
			buyersCounter++;
		} else {// means the id is there
			return new StringBuilder("The buyer with id : " + id + " already exists\n");
		}

		return new StringBuilder("The buyer with id : " + id + " has been added to the System\n");
	}

	public StringBuilder addLogisticPartner(int id, String name, String nationality, Date dateOfBirth, int year,
			int month, int day, char gender, String company, int regNumber, boolean operational, double ratePerKG,
			int Phone, String address) {
		boolean check = false;// use check to determine is id in the system or not

		// here i use this approach to create at least on object of logisticPartners so
		// i can compare it with other id
		if (logisticPartnersCounter == 0) {
			logisticPartners[logisticPartnersCounter] = new LogisticPartner(id, name, nationality, dateOfBirth, gender,
					Phone, address, company, regNumber, operational, ratePerKG);
			logisticPartnersCounter++;
		}

		// check about id is there in system or not
		for (int i = 0; i < logisticPartnersCounter; i++) {
			if (logisticPartners[i].getId() == id) {
				if (i == 0) {// here i want to jump number 0 because is there in system
					return new StringBuilder("The LogisticPartner with id : " + logisticPartners[i].getId()
							+ " has been added to the System\n");
				} else {
					check = true;
				}
			}
		}

		// means the id not in the System
		if (check == false) {
			logisticPartners[logisticPartnersCounter] = new LogisticPartner(id, name, nationality, dateOfBirth, gender,
					Phone, address, company, regNumber, operational, ratePerKG);
			logisticPartnersCounter++;
		} else {// means the id is there

			return new StringBuilder("The LogisticPartner with id : " + id + " already exists\n");
		}

		return new StringBuilder("The LogisticPartner with id : " + id + " has been added to the System\n");
	}

	public StringBuilder initializeOrder(int buyerId, int totItem) {

		StringBuilder result;
		boolean check = false;// create variable to check if id is in the system or not
		int indexOfbuyer = 0;
		for (int i = 0; i < buyersCounter; i++) {
			if (buyerId == buyers[i].getId()) {// if the id from the file is == id there in system
				check = true;
				indexOfbuyer = i;
			}
		}

		if (check == false) {
			result = new StringBuilder("There is no buyer with id : " + buyerId + "\n");
		} else {
			result = buyers[indexOfbuyer].initalizeOrder(buyers[indexOfbuyer].getId(), totItem);// relate the buyer an
																								// order using
																								// indexOfbuyer

		}

		return result;
	}

	public StringBuilder addItemToOrder(int orderId, int buyerId, int itemId) {

		int indexOfOrderId = 0;
		int indexOfbuyerId = 0;
		int indexofitemId = 0;
		boolean checkOfbuyer = false;
		boolean checkOfitem = false;

		// take the index of item id;
		for (int i = 0; i < itemCounter; i++) {
			if (itemId == items[i].getItemID()) {
				indexofitemId = i;
				checkOfitem = true;
			}

		}

		if (checkOfitem == false) {
			return new StringBuilder("The item with id " + itemId + " is not in the system" + "\n");
		}

		// take the index of buyer id;
		for (int j = 0; j < buyersCounter; j++) {
			if (buyerId == buyers[j].getId()) {
				indexOfbuyerId = j;
				checkOfbuyer = true;
			}
		}

		if (checkOfbuyer == false) {
			return new StringBuilder("There is no buyer with id : " + buyerId + "\n");
		}

		// take the index of order id;
		for (int k = 0; k < buyers[indexOfbuyerId].getOrderCounter(); k++) {
			if (orderId == buyers[k].getOrderId()) {
				indexOfOrderId = k;
			}
		}

		// check counter
		if (buyers[indexOfbuyerId].getOrder(indexOfOrderId).getItemCounter() == 0) {
			buyers[indexOfbuyerId].getOrder(indexOfOrderId).addItems(items[indexofitemId]);
			return new StringBuilder("The item with id : " + items[indexofitemId].getItemID()
					+ " has been added to the orderId: " + buyers[indexOfbuyerId].getOrderId() + "\n");
		}

		// get itemStock
		int itemStock = items[indexofitemId].getInStock();
		if (itemStock == 0) {
			return new StringBuilder("The item with " + itemId + " is out of stock\n");
		} else {
			buyers[indexOfbuyerId].getOrder(indexOfOrderId).addItems(items[indexofitemId]);
			return new StringBuilder("The item with id : " + items[indexofitemId].getItemID()
					+ " has been added to the orderId: " + buyers[indexOfbuyerId].getOrderId() + "\n");
		}

	}

	public StringBuilder associateLogisticPartnerToOrder(int orderId, int logisticPartnerId,
			double weightOfPackageInKG) {

		boolean checkOfLogisticID = false;
		boolean checkOfOrderID = false;
		boolean checkOfbuyer = false;
		int indexOforderId = 0;
		int indexOfLogisticPartnerId = 0;
		int indexOfbuyerId = 0;
		int buyer = 0;

		// get index Of orderId
		for (int i = 0; i < buyersCounter; i++) {
			for (int j = 0; j < buyers[i].getOrderCounter(); j++) {
				if (buyers[j].getOrderId() == orderId) {
					indexOforderId = j;
					indexOfbuyerId = i;
					checkOfOrderID = true;
				}
			}
		}

		// getIndex of logsitcId
		for (int i = 0; i < logisticPartnersCounter; i++) {
			if (logisticPartnerId == logisticPartners[i].getId()) {
				indexOfLogisticPartnerId = i;
				checkOfLogisticID = true;
			}

		}

		// check if the buyer in the system
		for (int i = 0; i < buyersCounter; i++) {
			if (buyers[i].getId() == buyers[indexOfbuyerId].getId()) {
				checkOfbuyer = true;
			}
		}

		if (buyers[indexOfbuyerId].getOrder(indexOforderId).getItemCounter() == 0) {
			return new StringBuilder("There is no item added for the id " + orderId + "\n");
		}

		if (checkOfLogisticID == false) {
			return new StringBuilder("There is no logisticPartner with id : " + logisticPartnerId + "\n");
		}

		if (checkOfOrderID == false) {
			return new StringBuilder("There is no order with id : " + orderId + "\n");
		}

		if (buyers[indexOfbuyerId].getOrder(indexOforderId).getItems().length == 0) {
			return new StringBuilder("There is no item added for the id " + orderId + "\n");
		}

		if (checkOfbuyer == false) {
			return new StringBuilder("There is no buyer with id : " + buyers[buyer].getId() + "\n");
		}

		// realate the logistec with order
		buyers[indexOfbuyerId].getOrder(indexOforderId).setLogisticPartner(logisticPartners[indexOfLogisticPartnerId]);
		buyers[indexOfbuyerId].getOrder(indexOforderId).setWeightOfPackageingKG(weightOfPackageInKG);
		return new StringBuilder("The order with id " + buyers[indexOfbuyerId].getOrderId()
				+ " has been shipped by the logistic Partner " + logisticPartners[indexOfLogisticPartnerId].getId()
				+ "\n");

	}

	public StringBuilder updateOrderStatus(int orderId, String orderDesc) {
		boolean checkOrderId = false;
		int indexOforderId = 0;
		int indexOfbuyerrId = 0;

		// get index Of orderId
		for (int i = 0; i < buyersCounter; i++) {
			for (int j = 0; j < buyers[i].getOrderCounter(); j++) {
				if (orderId == buyers[j].getOrderId()) {
					indexOforderId = j;
					indexOfbuyerrId = i;
					checkOrderId = true;

				}
			}
		}

		// if check id false
		if (checkOrderId == false) {
			return new StringBuilder("There is no order with id : " + orderId + "\n");
		} else {
			buyers[indexOfbuyerrId].getOrder(indexOforderId).setOrderDesc(orderDesc);
			return new StringBuilder("The status of the order with id " + orderId + " has been chanaged to "
					+ buyers[indexOfbuyerrId].getOrder(indexOforderId).getOrderDesc() + "\n");
		}

	}

	public StringBuilder printOrderOfBuyer(int buyerId, int orderId) {
		StringBuilder results = new StringBuilder();

		int indexOfbuyerId = 0;

		// get index of buyer Id
		for (int i = 0; i < buyersCounter; i++) {
			if (buyerId == buyers[i].getId()) {
				indexOfbuyerId = i;
			}
		}

		int indexofOrderID = 0;

		// get index of Order Id
		for (int i = 0; i < buyers[indexOfbuyerId].getOrderCounter(); i++) {
			if (orderId == buyers[indexOfbuyerId].getOrder(i).getOrderId()) {
				indexofOrderID = i;
			}
		}

		int indexOfitem = 0;

		// array of object to get all item in it
		Item[] itemArray = buyers[indexOfbuyerId].getOrder(indexofOrderID).getItems();

		// get index of item
		for (int i = 0; i < itemArray.length; i++) {
			if (itemArray[i].getItemID() == buyers[indexOfbuyerId].getOrder(indexofOrderID).getitem(i).getItemID()) {
				indexOfitem = i;
			}
		}

		// print
		results.append("\n OrderId : " + buyers[indexOfbuyerId].getOrder(indexofOrderID).getOrderId() + "\n");
		results.append(" Order date : " + buyers[indexOfbuyerId].getDateOfBirth() + "\n");
		results.append(String.format(" %-31s%-41d%-25s%s%n", "Buyer Id : ", buyers[indexOfbuyerId].getId(),
				"Buyer Name: ", buyers[indexOfbuyerId].getName()));
		results.append(String.format(" %-31s%-41d%-25s%s%n", "Seller Id : ",
				buyers[indexOfbuyerId].getOrder(indexofOrderID).getitem(indexOfitem).getOwner().getId(),
				"Seller Name: ",
				buyers[indexOfbuyerId].getOrder(indexofOrderID).getitem(indexOfitem).getOwner().getName()));
		results.append(String.format(" %-31s%-41d%-25s%s%n", "logistic Partner Id : ",
				buyers[indexOfbuyerId].getOrder(indexofOrderID).getLogisticPartner().getId(), "logistic Partner name: ",
				buyers[indexOfbuyerId].getOrder(indexofOrderID).getLogisticPartner().getName()));

		double ShippingCost = buyers[indexOfbuyerId].getOrder(indexofOrderID).getWeightOfPackageingKG()
				* buyers[indexOfbuyerId].getOrder(indexofOrderID).getLogisticPartner().getRatePerKG();

		results.append(String.format(" Shipping cost : %.2f%n", ShippingCost));
		results.append(
				" The status of the Order : " + buyers[indexOfbuyerId].getOrder(indexofOrderID).getOrderDesc() + "\n");
		results.append(
				"----------------------------------------------------------------------------------------------------------------------\n");
		results.append(String.format("%7s%34s%37s%n", "ItemId", "Item name", "price"));
		results.append(
				"----------------------------------------------------------------------------------------------------------------------\n");

		double totalprice = 0;

		// print items
		for (int i = 0; i < itemArray.length; i++) {
			totalprice += itemArray[i].getPrice();
			results.append(String.format(" %-31d%-41s%.2f%n", itemArray[i].getItemID(), itemArray[i].getItemName(),
					itemArray[i].getPrice()));
		}

		results.append(
				"----------------------------------------------------------------------------------------------------------------------\n");

		results.append(String.format(" Total : %.2f%n", totalprice));

		return results;
	}

	public StringBuilder printSpecificItemsForSeller(int sellerId) {
		StringBuilder results = new StringBuilder();

		int indexOfseller = 0;

		// get seller index
		for (int i = 0; i < sellersCounter; i++) {
			if (sellerId == sellers[i].getId()) {
				indexOfseller = i;
			}
		}

		// print
		results.append(String.format("%n %-31s%-41d%-25s%s%n", "Seller Id : ", sellers[indexOfseller].getId(),
				"Seller Name: ", sellers[indexOfseller].getName()));
		results.append(
				"----------------------------------------------------------------------------------------------------------------------\n");
		results.append(String.format("%7s%34s%37s%25s%n", "ItemId", "Item name", "In Stock", "Price"));
		results.append(
				"----------------------------------------------------------------------------------------------------------------------\n");

		// check of item and print item
		for (int i = 0; i < itemCounter; i++) {
			if (sellers[indexOfseller].getId() == items[i].getOwner().getId()) {
				results.append(String.format(" %-31d%-38s%-28d%.2f%n", items[i].getItemID(), items[i].getItemName(),
						items[i].getInStock(), items[i].getPrice()));
			}
		}

		return results.append("\n");
	}

	public StringBuilder printTransactionsOfSeller(int sellerId) {

		StringBuilder results = new StringBuilder();

		int indexOfseller = 0;
		int indexOfbuyerId = 0;
		int indexOfOrderId = 0;
		int indexOfItemId = 0;

		// get seller index
		for (int i = 0; i < sellersCounter; i++) {
			if (sellerId == sellers[i].getId()) {
				indexOfseller = i;
			}
		}

		results.append(String.format("%n %-31s%-41d%-25s%s%n", "Seller Id : ", sellers[indexOfseller].getId(),
				"Seller Name: ", sellers[indexOfseller].getName()));
		results.append(
				"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		results.append(String.format("%7s%33s%37s%35s%28s%n", " Buyer Id", "Buyer name", "orederId", "Purchase date",
				"Amount"));
		results.append(
				"------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		double total = 0;

		// get all indexes and check the seller id with item owner
		for (int i = 0; i < buyersCounter; i++) {
			for (int j = 0; j < buyers[i].getOrderCounter(); j++) {
				Item[] items = buyers[i].getOrder(j).getItems();
				for (int k = 0; k < items.length; k++) {
					if (items[k].getOwner().getId() == sellers[indexOfseller].getId()) {
						indexOfbuyerId = i;
						indexOfOrderId = j;
						total += items[k].getPrice();
					}

				}
				results.append(String.format(" %-31d%-41s%-29d%-35s%.2f%n", buyers[indexOfbuyerId].getId(),
						buyers[indexOfbuyerId].getName(), buyers[indexOfbuyerId].getOrder(indexOfOrderId).getOrderId(),
						buyers[indexOfbuyerId].getOrder(indexOfOrderId).getOrderDate(),
						buyers[indexOfbuyerId].getOrder(indexOfOrderId).getAmount()));
			}

		}

		results.append(
				"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		results.append(String.format(" Total : %.2f%n", total));

		return results;
	}

	public StringBuilder printTransactionsOfBuyer(int buyerId) {
		StringBuilder results = new StringBuilder();

		int indexOfbuyerID = 0;

		// get buyer index
		for (int i = 0; i < buyersCounter; i++) {
			if (buyers[i].getId() == buyerId) {
				indexOfbuyerID = i;
			}
		}

		results.append(String.format(" %n%-31s%-41d%-25s%s%n", " Buyer Id : ", buyers[indexOfbuyerID].getId(),
				" Buyer Name: ", buyers[indexOfbuyerID].getName()));
		results.append(
				"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		results.append(String.format("%7s%33s%37s%35s%28s%n", " Seller Id", "Seller name", "orederId", "Purchase date",
				"Amount"));
		results.append(
				"------------------------------------------------------------------------------------------------------------------------------------------------------\n");

		int indexOfOrder = 0;
		double totalprice = 0;

		// get all indexes and check with item with buyer and print
		for (int j = 0; j < buyers[indexOfbuyerID].getOrderCounter(); j++) {
			Item[] item = buyers[indexOfbuyerID].getOrder(j).getItems();
			for (int i = 0; i < buyers[indexOfbuyerID].getOrder(j).getItemCounter(); i++) {
				totalprice += item[i].getPrice();
				indexOfOrder = i;
			}
			results.append(String.format(" %-31d%-41s%-29d%-35s%.2f%n", item[indexOfOrder].getOwner().getId(),
					item[indexOfOrder].getOwner().getName(), buyers[indexOfbuyerID].getOrder(j).getOrderId(),
					buyers[indexOfbuyerID].getOrder(j).getOrderDate(), buyers[indexOfbuyerID].getOrder(j).getAmount()));
		}

		results.append(
				"------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		results.append(String.format(" Total : %.2f%n", totalprice));

		return results;
	}
}