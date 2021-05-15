package com.boot.rest.springbootRest;

public class Product {

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String productName, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private int productId;
	private String productName;
	private int price;
}
