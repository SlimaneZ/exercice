package com.caci.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.caci.model.LineItem;
import com.caci.model.Product;
import com.caci.model.ProductType;
import com.caci.model.TaxType;
import com.caci.service.TaxService;
import com.caci.util.PriceUtil;

/**
 * Service pour la gestion des taxes.
 * 
 * @author Slimane
 *
 */
@Service
public class TaxServiceImpl implements TaxService {
	
	// Arrondi aux 5 centimes
	private static final BigDecimal INCCREMENT = new BigDecimal("0.05");

	/**
	 * Obtenir la tax du produit à partir de son type
	 * 
	 * @param product
	 *            le produit
	 */
	@Override
	public double getProductTax(Product product) {	
		double productTax;
		if (product.getProductType().equals(ProductType.FOOD) || product.getProductType().equals(ProductType.MEDICAL) ) {
			productTax = TaxType.NONE.getTax();
		} else if (product.getProductType().equals(ProductType.BOOK)) {
			productTax = TaxType.BOOK.getTax();
		} else {
			productTax = TaxType.OTHERS.getTax();
		}
		if (product.isImported()) {
			productTax = productTax + TaxType.IMPORTED.getTax();
		}
		return productTax;
	}

	
	/**
	 * Obtenir la tax arrondie de la LineItem
	 * 
	 * @param lineItem
	 *            lineItem
	 */
	@Override
	public BigDecimal getSaleTax(LineItem lineItem) {
		BigDecimal quantity = new BigDecimal(String.valueOf(lineItem.getQuantity()));
		BigDecimal totatPht = lineItem.getProduct().getPrice().multiply(quantity);
		return lineItem.getTotalCost().subtract(totatPht);
	}

	/**
	 * Calculer le prix TTC 
	 * 
	 * @param lineItem: lineItem
	 */
	@Override
	public BigDecimal getTotalCostWithTax(LineItem lineItem) {
		Product product = lineItem.getProduct();
		double productTax = getProductTax(lineItem.getProduct());
		product.setTax(productTax);
		BigDecimal taxAmount = product.getPrice().multiply(new BigDecimal(String.valueOf(productTax)));
		BigDecimal quantity = new BigDecimal(String.valueOf(lineItem.getQuantity()));
		BigDecimal totalTax = taxAmount.multiply(quantity);
		BigDecimal roundTotalTax = PriceUtil.round(totalTax,INCCREMENT, RoundingMode.UP);
		BigDecimal totalPht = lineItem.getProduct().getPrice().multiply(quantity);
		BigDecimal roundtotalPht = PriceUtil.round(totalPht, INCCREMENT, RoundingMode.UP);
		return roundtotalPht.add(roundTotalTax);
	}
	
	

}
