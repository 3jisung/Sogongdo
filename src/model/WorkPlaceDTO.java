package model;

public class WorkPlaceDTO {
	private String name;
	private String state;
	private String tel;
	private String admin;
	
	public WorkPlaceDTO(String name, String state, String tel, String admin) {
		super();
		this.name = name;
		this.state = state;
		this.tel = tel;
		this.admin = admin;
	}
	
	public WorkPlaceDTO(String name) {
		super();
		this.name = name;
		this.state = null;
		this.tel = null;
		this.admin = null;
	}

	public WorkPlaceDTO() {

	}

	public String getName() {
		return name;
	}

	public String getState() {
		return state;
	}

	public String getTel() {
		return tel;
	}

	public String getAdmin() {
		return admin;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
}
