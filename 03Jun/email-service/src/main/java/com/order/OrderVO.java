package com.order;

import java.io.Serializable;

public class OrderVO implements Serializable{

	public Integer getId() {
		return id;
	}
	Integer id;
	
	String item;
	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", item=" + item + ", price=" + price + ", quantity=" + quantity + "]";
	}
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
