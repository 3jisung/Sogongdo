package model;

public class ProductPackage {

	private String name;		//상품패키지명
	private int price;			//가격
	
	public ProductPackage() {}
	
	public ProductPackage(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
