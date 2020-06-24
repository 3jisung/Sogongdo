package model;

public class Reservation {
	String id;
	String userID;
	String facilityID;
	String paymentID;
	String startDate;
	String endDate;
	String people;
	String registerDate;
	String cancelDate;
			
	public Reservation(String id, String userID, String facilityID, String paymentID, String startDate,
			String endDate, String people, String registerDate, String cancelDate) {
		super();
		this.id = id;
		this.userID = userID;
		this.facilityID = facilityID;
		this.paymentID = paymentID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.people = people;
		this.registerDate = registerDate;
		this.cancelDate = cancelDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	public String getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(String cancelDate) {
		this.cancelDate = cancelDate;
	}
}
