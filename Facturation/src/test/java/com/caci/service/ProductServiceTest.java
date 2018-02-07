package com.caci.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caci.SpringBootWebApplication;
import com.caci.model.Product;
import com.caci.model.ProductType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
public class ProductServiceTest {
	
	private static final String[] BOOK_DETAILS = {"2","livres", "à", "12.49€"};
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void updateProductTypeForBook(){
		Product product = new Product();
		product.setName("Livre");
		productService.updateProductType(product);
		Assert.assertEquals(product.getProductType(), ProductType.BOOK);
		
	}
	
	@Test
	public void updateProductTypeForCD(){
		Product product = new Product();
		product.setName("CD");
		productService.updateProductType(product);
		Assert.assertEquals(product.getProductType(), ProductType.OTHER);
	}
	
	@Test
	public void buildProductNameTest(){
		String productName = productService.buildProductName(BOOK_DETAILS, false);
		Assert.assertEquals(BOOK_DETAILS[1], productName);
		
	}
	

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

}
