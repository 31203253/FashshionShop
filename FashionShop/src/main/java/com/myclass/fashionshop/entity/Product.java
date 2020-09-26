package com.myclass.fashionshop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Product's name cant be whitespace character!")
	private String name;
	private float price;
	private String brand;
	private Long sales;
	private float discount;
	private String description;
	private String status;


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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public Long getSales() {
		return sales;
	}

	public void setSales(Long sales) {
		this.sales = sales;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product() {
	
	}

	public Product(@NotBlank(message = "Product's name cant be whitespace character!") String name, float price,
			String brand, Long sales, float discount, String description, String status) {
		this.name = name;
		this.price = price;
		this.brand = brand;
		this.sales = sales;
		this.discount = discount;
		this.description = description;
		this.status = status;
	}

}
