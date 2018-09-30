/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class Dealer extends Trader {

	//-------Attribute--------
	
	private String company;
	private int regNumber;
	private boolean operational;

	
	//-------Actions--------
	
	
	public Dealer(int id, String name, String nationality, Date dateOfBirth, char gender, int phone, String address,
			String company, int regNumber, boolean operational) {
		super(id, name, nationality, dateOfBirth, gender, phone, address);
		this.company = company;
		this.regNumber = regNumber;
		this.operational = operational;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public int getRegNumber() {
		return regNumber;
	}


	public void setRegNumber(int regNumber) {
		this.regNumber = regNumber;
	}


	public boolean isOperational() {
		return operational;
	}


	public void setOperational(boolean operational) {
		this.operational = operational;
	}


	@Override
	public String toString() {
		return super.toString()+"  Dealer company=" + this.company + ", regNumber=" + this.regNumber + ", operational=" + this.operational;
	}
	
	
	
	
	
	
	
	
	
	
}
