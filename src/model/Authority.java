package model;

public class Authority {
	private int id;
	private String target;
	private String action;
	
	public Authority(int id, String target, String action) {
		this.id =id;
		this.target = target;
		this.action = action;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	public int getId() {
		return id;
	}
	public String getTarget() {
		return target;
	}
	public String getAction() {
		return action;
	}
}
