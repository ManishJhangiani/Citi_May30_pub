package com.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class OrderVO {

	public Integer getId() {
		return id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@NotBlank(message = "Item name cannot be blank")
	String item;
	@Min(value = 1, message = "Price>=1")
	float price;
	
	int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
