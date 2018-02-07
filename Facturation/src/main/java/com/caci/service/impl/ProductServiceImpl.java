package com.caci.service.impl;

import static com.caci.util.Constante.FOOD_PRODUCTS_SET;
import static com.caci.util.Constante.MEDICAL_PRODUCTS_SET;
import static com.caci.util.Constante.SPACE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.caci.util.Constante.BOOK_PRODUCTS_SET;
import com.caci.model.Product;
import com.caci.model.ProductType;
import com.caci.service.MessageService;
import com.caci.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private MessageService messageService;

	/**
	 * Mettre à jour le type de produit 
	 * 
	 * @param product: le produit
	 */
	@Override
	public void updateProductType(Product product) {
		String productName = product.getName().toUpperCase();
		boolean foodType = FOOD_PRODUCTS_SET.stream()
				                            .anyMatch(productName::contains);
		if(foodType){
			product.setProductType(ProductType.FOOD);	
		}
		boolean medicalType = MEDICAL_PRODUCTS_SET.stream()
				                                  .anyMatch(productName::contains);
		if(medicalType){
			product.setProductType(ProductType.MEDICAL);	
		}
		boolean bookType = BOOK_PRODUCTS_SET.stream()
				                            .anyMatch(productName::contains);
		if(bookType){
			product.setProductType(ProductType.BOOK);	
		}		
		if(product.getProductType() == null){
			product.setProductType(ProductType.OTHER);
		}
	}
	
	
	/**
	 * Obtenir le nom du  produit 
	 * 
	 * @param productDetails: les détails de produit
	 * @param imported: improrté
	 */
	@Override
	public  String buildProductName(String[] productDetails, boolean imported){
		if(productDetails == null || productDetails.length < 4 ){
			 throw new IllegalArgumentException(messageService.getMessage("product.details.size"));
		}
		StringBuilder productNameBuilder = new StringBuilder();
		int size = imported ? productDetails.length-3 : productDetails.length-2;
		for (int i = 1; i < size; i++) {
			productNameBuilder.append(productDetails[i]).append(SPACE);
		}
		return productNameBuilder.toString().trim();
	}

}
