package com.caci.dto;



import java.math.BigDecimal;

import com.caci.model.ProductType;

/**
 * Dto pour exposer les données de produit.
 * 
 * @author Slimane
 *
 */
public class ProductDto {
	
	private String name;
	
	private boolean imported;
	
	private BigDecimal price ;
	
	private double tax;
	
	private ProductType productType;
	
	

	public ProductDto() {
	
	}

	public ProductDto(String name, BigDecimal price, double tax, ProductType productType) {
		super();
		this.name = name;
		this.price = price;
		this.tax = tax;
		this.productType = productType;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
