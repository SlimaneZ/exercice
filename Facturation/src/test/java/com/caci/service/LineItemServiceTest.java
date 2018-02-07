package com.caci.service;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.caci.dao.ProductDao;
import com.caci.model.LineItem;
import com.caci.service.impl.LineItemServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class LineItemServiceTest {
	
	
	@Mock
	private ProductDao productDao;
	
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private LineItemServiceImpl lineItemServiceImpl;
	
	private static final List<String> PRODUCT_ROWS = Arrays.asList("2 livres à 12.49€");
	private static final String[] PRODUCT_DETAILS = {"2","livres", "à", "12.49€"};
	private static final BigDecimal BOOK_PRICE = new BigDecimal("12.49");
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void createLineItemsTest(){
		Mockito.when(productDao.readProducts(Mockito.any(String.class))).thenReturn(PRODUCT_ROWS);
		Mockito.when(productService.buildProductName(Mockito.any(String[].class), Mockito.anyBoolean())).thenReturn("Livre");
		List<LineItem>  lineItems = lineItemServiceImpl.createLineItems("input1");
		verify(productDao).readProducts("input1");
		verify(productService).buildProductName(PRODUCT_DETAILS, false);
		Assert.assertEquals(1, lineItems.size());
		Assert.assertEquals(2, lineItems.get(0).getQuantity());
		Assert.assertTrue(lineItems.get(0).getProduct().getPrice().compareTo(BOOK_PRICE) == 0);
	}

}
