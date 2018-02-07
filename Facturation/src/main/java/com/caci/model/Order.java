package com.caci.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe représentant la commande.
 * 
 * @author slimane
 *
 */
public class Order {
	
	private List<LineItem> lineItems = new ArrayList<>();
	
	private BigDecimal totalCost;
	
	private BigDecimal totalTax;
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	

}
