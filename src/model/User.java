package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
	private String id;
	private String password;
	private String name;
	private String address;
	private LocalDate birth;
	private LocalDateTime registerDate;
	private String phoneNumber;
	private String eMail;
	private int userTypeCode_code;
	
	public User(String id, String password, String name, String address, LocalDate birth, LocalDateTime registerDate,
			String phoneNumber, String eMail) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.address = address;
		this.birth = birth;
		this.registerDate = registerDate;
		this.phoneNumber = phoneNumber;
		this.eMail = eMail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return eMail;
	}

	public void setEmail(String eMail) {
		this.eMail = eMail;
	}
	
	public int getUserTypeCode_code() {
		return userTypeCode_code;
	}
	
	public void setUserTypeCode_code(int userTypeCode_code) {
		this.userTypeCode_code = userTypeCode_code;
	}
}
