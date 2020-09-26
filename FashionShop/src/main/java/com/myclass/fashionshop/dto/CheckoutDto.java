package com.myclass.fashionshop.dto;

public class CheckoutDto {
	private Long id;
	private String name;
	private int quantity;
	private float price;
	private float discount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public CheckoutDto(String name, int quantity, float price, float discount) {
		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
	}

	public CheckoutDto() {

	}

}
