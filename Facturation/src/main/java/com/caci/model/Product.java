package com.caci.model;

import java.math.BigDecimal;
/**
 * Classe qui represente le produit. 
 * 
 * @author slimane
 *
 */
public class Product {
	
	private String name;
		
	private boolean imported;
	
	// le prix hors taxe
	private BigDecimal price ;
	
	
	private double tax;
	
	private ProductType productType;
	
	public Product() {
		
	}

	public Product(ProductType productType) {
		super();
		this.productType = productType;
	}
	
	public Product(ProductType productType, BigDecimal price) {
		super();
		this.productType = productType;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public boolean isImported() {
		return imported;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	
	
	

}
