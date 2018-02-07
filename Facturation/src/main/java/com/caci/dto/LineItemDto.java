package com.caci.dto;

import java.math.BigDecimal;

/**
 * Dto pour exposer les données de LineItem.
 * 
 * @author Slimane
 *
 */
public class LineItemDto {
	
    private ProductDto productDto;
    
    public LineItemDto() {
		
	}

	public LineItemDto(ProductDto productDto, int quantity, BigDecimal totalCost) {
		super();
		this.productDto = productDto;
		this.quantity = quantity;
		this.totalCost = totalCost;
	}

	private int quantity;
	
	private BigDecimal totalCost;

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}

}
