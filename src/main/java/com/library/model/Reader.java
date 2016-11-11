package com.library.model;

public class Reader {
	private String Name;
	private String Gender;
	private String Address;
	private String Phone;
	private String Id;
	public Reader(){
		
	}
	public Reader (String name, String gender, String address, String phone ,String id) {
		this.Name = name;
		this.Gender = gender;
		this.Address = address;
		this.Phone = phone;
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		this.Phone = phone;
	}
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}
}
