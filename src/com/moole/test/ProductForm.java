package com.moole.test;

import java.sql.Timestamp;

public class ProductForm {
	

private Integer productId;
private String productName;
private Float productprice;
private Integer availableCount;
private Timestamp creationDate;
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Float getProductprice() {
	return productprice;
}
public void setProductprice(Float productprice) {
	this.productprice = productprice;
}
public Integer getAvailableCount() {
	return availableCount;
}
public void setAvailableCount(Integer availableCount) {
	this.availableCount = availableCount;
}
public Timestamp getCreationDate() {
	return creationDate;
}
public void setCreationDate(Timestamp creationDate) {
	this.creationDate = creationDate;
}
@Override
public String toString() {
	return "ProductForm [productId=" + productId + ", productName="
			+ productName + ", productprice=" + productprice
			+ ", availableCount=" + availableCount + ", creationDate="
			+ creationDate + "]";
}

	
}


