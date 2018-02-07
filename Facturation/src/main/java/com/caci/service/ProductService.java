package com.caci.service;

import com.caci.model.Product;

public interface ProductService {

	public void updateProductType(Product product);
	
	public String buildProductName(String[] breakString, boolean imported);
	
	
}
