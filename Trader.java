/*
 * Abdulrhman hani aljohani 
 * 1750624
 * G3
 * 
 */

import java.util.Date;

public class Trader {
	
	//-------Attribute--------
	
	private int id;
	private String name;
	private String nationality;
	private Date dateOfBirth;
	private char gender;
	private int phone;
	private String address;
	private Date regDate;
	
	//-------Actions--------
	
	public Trader(int id, String name, String nationality, Date dateOfBirth, char gender, int phone, String address) {
		this.id = id;
		this.name = name;
		this.nationality = nationality;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phone = phone;
		this.address = address;
	}

	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public String getNationality() {
		return this.nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	@Override
	public String toString() {
		return "Trader id=" + this.id + ", name=" + this.name + ", nationality=" + this.nationality + ", dateOfBirth=" + this.dateOfBirth
				+ ", gender=" + this.gender + ", phone=" + this.phone + ", address=" + this.address + ", regDate=" + this.regDate;
	}
	
	
	
}
