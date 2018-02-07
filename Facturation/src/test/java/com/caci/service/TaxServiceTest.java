package com.caci.service;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.caci.SpringBootWebApplication;
import com.caci.model.LineItem;
import com.caci.model.Product;
import com.caci.model.ProductType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringBootWebApplication.class)
public class TaxServiceTest {
	
	private static final double PRECISION = 0.001;
	private static final BigDecimal BOOK_PRICE = new BigDecimal("12.49");

	@Autowired
	private TaxService taxService;

	@Test
	public void testGetProductTaxForBook() {
		Product product = new Product(ProductType.BOOK);
		double bookTax = taxService.getProductTax(product);
		Assert.assertEquals(0.1, bookTax, PRECISION);
	}
	
	@Test
	public void testGetProductTaxForFood() {
		Product product = new Product(ProductType.FOOD);
		double foodTax = taxService.getProductTax(product);
		Assert.assertEquals(0.0, foodTax, PRECISION);
	}
	
	@Test
	public void testGetProductTaxForMedical() {
		Product product = new Product(ProductType.MEDICAL);
		double medicalTax = taxService.getProductTax(product);
		Assert.assertEquals(0.0, medicalTax, PRECISION);
	}
	
	@Test
	public void testGetProductTaxForOthers() {
		Product product = new Product(ProductType.OTHER);
		double otherTax = taxService.getProductTax(product);
		Assert.assertEquals(0.2, otherTax, PRECISION);
	}
	
		
	@Test
	public void testGetProductTaxForImportedBook() {
		Product product = new Product(ProductType.BOOK);
		product.setImported(true);
		double foodTax = taxService.getProductTax(product);
		Assert.assertEquals(0.15, foodTax, PRECISION);
	}
	
	@Test
	public void testGetProductTaxForImportedFood() {
		Product product = new Product(ProductType.FOOD);
		product.setImported(true);
		double foodTax = taxService.getProductTax(product);
		Assert.assertEquals(0.05, foodTax, PRECISION);
	}
	
	
	@Test
	public void testGetProductTaxForImportedMedical() {
		Product product = new Product(ProductType.FOOD);
		product.setImported(true);
		double medicaTax = taxService.getProductTax(product);
		Assert.assertEquals(0.05, medicaTax, PRECISION);
	}
	
	@Test
	public void testGetProductTaxForImportedOthers() {
		Product product = new Product(ProductType.OTHER);
		product.setImported(true);
		double otherTax = taxService.getProductTax(product);
		Assert.assertEquals(0.25, otherTax, PRECISION);
	}
	
	@Test
	public void testTotalCostWithTaxForTwoBooks() {
		Product product = new Product(ProductType.BOOK, BOOK_PRICE);
		LineItem lineItem = new LineItem(product,2);
		BigDecimal totalCostWithTax = taxService.getTotalCostWithTax(lineItem);
	    Assert.assertTrue(totalCostWithTax.compareTo(new BigDecimal("27.50")) == 0);
	}

	@Test
	public void testGetSaleTaxForTwoBooks() {
		Product product = new Product(ProductType.BOOK, BOOK_PRICE);
		LineItem lineItem = new LineItem(product,2);
		lineItem.setTotalCost(taxService.getTotalCostWithTax(lineItem));
		BigDecimal totalCostWithTax = taxService.getSaleTax(lineItem);
	    Assert.assertTrue(totalCostWithTax.compareTo(new BigDecimal("2.52")) == 0);
	}

	
	
	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}

}
