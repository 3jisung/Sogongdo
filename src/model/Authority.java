package model;

public class Authority {
	private String target;
	private String action;
	
	public Authority(String target, String action) {
		this.target = target;
		this.action = action;
	}

	public void setTarget(String target) {
		this.target = target;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public String getTarget() {
		return target;
	}
	public String getAction() {
		return action;
	}
}
