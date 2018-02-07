package com.caci.service;

import java.math.BigDecimal;

import com.caci.model.LineItem;
import com.caci.model.Product;

public interface TaxService {
	
	public double getProductTax(Product product);
	
	public BigDecimal getSaleTax(LineItem lineItem);
	
	public BigDecimal getTotalCostWithTax(LineItem lineItem);

}
