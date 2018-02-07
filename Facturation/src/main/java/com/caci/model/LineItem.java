package com.caci.model;

import java.math.BigDecimal;
/**
 * Classe décrivant ligne produits commandés.
 * 
 * @author slimane
 *
 */
public class LineItem {
	
	private Product product;
	
	private int quantity;
	
	private BigDecimal saleTax;
	
	private BigDecimal totalCost;
	
	
	public LineItem(){
		
	}
	
	public LineItem(Product product) {
		super();
		this.product = product;
	}
	
	public LineItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}
	


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(BigDecimal saleTax) {
		this.saleTax = saleTax;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

}
