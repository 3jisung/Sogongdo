package model;

import java.time.LocalDateTime;

public class ProductPayment{

	private String ProductPackage_name;	//상품패키지명
	private String User_id;				//구매한 유저아이디
	private int quantity; 				//팔린상품갯수
	private LocalDateTime saleDate;
	
	public ProductPayment() {}

	public ProductPayment(String ProductPackage_name, String User_id, int quantity, LocalDateTime saleDate) 
	{
		this.ProductPackage_name = ProductPackage_name;
		this.User_id = User_id;
		this.quantity = quantity;
		this.saleDate = saleDate;
	}

	public String getProductPackage_Name() {
		return ProductPackage_name;
	}

	public void setProductPackage_Name(String ProductPackage_name) {
		this.ProductPackage_name = ProductPackage_name;
	}

	public String getUser_id() {
		return User_id;
	}

	public void setUser_id(String User_id) {
		this.User_id = User_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDateTime getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(LocalDateTime saleDate) {
		this.saleDate = saleDate;
	}
	
}
