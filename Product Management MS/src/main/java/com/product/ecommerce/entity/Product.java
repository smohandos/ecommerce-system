package com.product.ecommerce.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
    private int id;
    private String prodName;
    private String prodDesc;
    private String prodCat;
    private String make;
    private int availableQty;
    private Double price;
    private String uom;
    private double prodRating;
    private String imageUrl;
    private LocalDate dateOfManufacture;
    
    
    
	public Product() {
		super();
	}



	public Product(int id, String prodName, String prodDesc, String prodCat, String make, int availableQty,
			Double price, String uom, double prodRating, String imageUrl, LocalDate dateOfManufacture) {
		super();
		this.id = id;
		this.prodName = prodName;
		this.prodDesc = prodDesc;
		this.prodCat = prodCat;
		this.make = make;
		this.availableQty = availableQty;
		this.price = price;
		this.uom = uom;
		this.prodRating = prodRating;
		this.imageUrl = imageUrl;
		this.dateOfManufacture = dateOfManufacture;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getProdName() {
		return prodName;
	}



	public void setProdName(String prodName) {
		this.prodName = prodName;
	}



	public String getProdDesc() {
		return prodDesc;
	}



	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}



	public String getProdCat() {
		return prodCat;
	}



	public void setProdCat(String prodCat) {
		this.prodCat = prodCat;
	}



	public String getMake() {
		return make;
	}



	public void setMake(String make) {
		this.make = make;
	}



	public int getAvailableQty() {
		return availableQty;
	}



	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public String getUom() {
		return uom;
	}



	public void setUom(String uom) {
		this.uom = uom;
	}



	public double getProdRating() {
		return prodRating;
	}



	public void setProdRating(double prodRating) {
		this.prodRating = prodRating;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}



	public LocalDate getDateOfManufacture() {
		return dateOfManufacture;
	}



	public void setDateOfManufacture(LocalDate dateOfManufacture) {
		this.dateOfManufacture = dateOfManufacture;
	}

	
	
    
    
}