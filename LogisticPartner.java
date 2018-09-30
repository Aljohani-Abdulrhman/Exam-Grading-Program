/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class LogisticPartner extends Dealer {

	//-------Attribute--------
	
	private double ratePerKG;

	
	//-------Actions--------
	
	public LogisticPartner(int id, String name, String nationality, Date dateOfBirth, char gender, int phone,
			String address, String company, int regNumber, boolean operational, double ratePerKG) {
		super(id, name, nationality, dateOfBirth, gender, phone, address, company, regNumber, operational);
		this.ratePerKG = ratePerKG;
	}


	public double getRatePerKG() {
		return ratePerKG;
	}


	public void setRatePerKG(double ratePerKG) {
		this.ratePerKG = ratePerKG;
	}


	@Override
	public String toString() {
		return super.toString()+ " Logistic Partner rate Per KG= " + this.ratePerKG ;
	}
	
	
	
	
	

}
