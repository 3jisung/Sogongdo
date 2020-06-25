package model;


public class FacilityDTO {
	private String facilityID;
	private String name;
	private String workplace;
	private String classification;
	private String state;
	private String manager_id;
	private String phone;
	private int cost;
	private String business_name;
	
	public String getFacilityID() {
		return facilityID;
	}
	public void setFacilityID(String facilityID) {
		this.facilityID = facilityID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	
}
