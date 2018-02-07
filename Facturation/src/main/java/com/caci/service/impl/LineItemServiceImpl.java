package com.caci.service.impl;

import static com.caci.util.Constante.IMPORT;
import static com.caci.util.Constante.SPACE;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caci.dao.ProductDao;
import com.caci.model.LineItem;
import com.caci.model.Product;
import com.caci.service.LineItemService;
import com.caci.service.MessageService;
import com.caci.service.ProductService;
import com.caci.util.ProductUtil;

/**
 * Service LineItem.
 * @author slimane
 *
 */
@Service
public class LineItemServiceImpl implements LineItemService{
	
	
	 private static final Logger logger = LogManager.getLogger(LineItemServiceImpl.class);
	
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MessageService messageService;

	/**
	 * Construire  la liste de LineItem
	 * 
	 * @param fileName:  nom de fichier contenant le détail de la commande         
	 */
	@Override
	public List<LineItem> createLineItems(String fileName) {
		List<LineItem> lineItems = new ArrayList<>();
		List<String> productRows = productDao.readProducts(fileName);
		
		for (String string : productRows) {
			Product product = new Product();
			LineItem lineItem = new LineItem(product);
			String[] productDetails = string.split(SPACE);
			try{
				lineItem.setQuantity(Integer.parseInt(productDetails[0]));
			}catch(NumberFormatException nfe){
				logger.error(messageService.getMessage("product.quantity"), nfe);
			}
			String price = ProductUtil.cutOffEnd(productDetails[productDetails.length - 1], 1);
			//s'assurer de la validité de donnée double
			double parseDouble = Double.parseDouble(price);
			product.setPrice(new BigDecimal(String.valueOf(parseDouble)));
			if(productDetails[productDetails.length - 3].toUpperCase().startsWith(IMPORT)){
				product.setImported(true);
			}
			product.setName(productService.buildProductName(productDetails,product.isImported()));
			productService.updateProductType(product);
			lineItems.add(lineItem);
		}
		return lineItems;
	}


	
	
	

	
}
