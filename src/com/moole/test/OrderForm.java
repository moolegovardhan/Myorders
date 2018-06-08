package com.moole.test;

import java.sql.Timestamp;

public class OrderForm{
	private Integer orderId;
	private Integer ProductId ;
	private String Productname;
	private Float  totelCost;
	private Integer quantity;
	private Timestamp creationDate;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getProductId() {
		return ProductId;
	}
	public void setProductId(Integer productId) {
		ProductId = productId;
	}
	public String getProductname() {
		return Productname;
	}
	public void setProductname(String productname) {
		Productname = productname;
	}
	public Float getTotelCost() {
		return totelCost;
	}
	public void setTotelCost(Float totelCost) {
		this.totelCost = totelCost;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "OrderForm [orderId=" + orderId + ", ProductId=" + ProductId
				+ ", Productname=" + Productname + ", totelCost=" + totelCost
				+ ", quantity=" + quantity + ", creationDate=" + creationDate
				+ "]";
	}
	
	

	}
