package com.caci.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * Dto pour exposer les données de Order.
 * 
 * @author Slimane
 *
 */
public class OrderDto {

	private List<LineItemDto> lineItemDtos = new ArrayList<>();

	private BigDecimal totalTax;
	
	private BigDecimal totalCost;


	public BigDecimal getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(BigDecimal totalTax) {
		this.totalTax = totalTax;
	}

	public List<LineItemDto> getLineItemDtos() {
		return lineItemDtos;
	}

	public void setLineItemDtos(List<LineItemDto> lineItemDtos) {
		this.lineItemDtos = lineItemDtos;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

	

}
