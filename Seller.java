/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class Seller extends Dealer {

	//-------Attribute--------
	
	private int licenseNo;

	//-------Actions--------
	
	public Seller(int id, String name, String nationality, Date dateOfBirth, char gender, int phone, String address,
			String company, int regNumber, boolean operational, int licenseNo) {
		super(id, name, nationality, dateOfBirth, gender, phone, address, company, regNumber, operational);
		this.licenseNo = licenseNo;
	}

	public int getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Override
	public String toString() {
		return super.toString()+ "  Seller license No= " + this.licenseNo ;
	}
	
	
	

	
}
