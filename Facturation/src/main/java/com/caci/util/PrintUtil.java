package com.caci.util;

import com.caci.model.LineItem;
import com.caci.model.Order;
/**
 * Classe utilitaire pour formater les sorties
 * 
 * @author slimane
 *
 */
public class PrintUtil {
	
	public static final String LINE_ITEM_PATTERN = "* %s %s à %s€ : %s€ TTC\n";
	public static final String IMPORTED_LINE_ITEM_PATTERN = "* %s %s importé à %s€ : %s€ TTC\n";
	public static final String TOTAL_ORDER_PATTERN = "\nMontant des taxes : %s€\nTotal : %s€\n\n";
	public static final String TITLE_PATTERN = "#### Output %s\n\n";
	
	
	
	
	private PrintUtil(){
		
	}

	/**
	 * Fomater lineItem.
	 * 
	 * @param lineItem: ligne de commande
	 * @return une chaine formatée contenant les détails de lineItem
	 */
	public static String formatLineItem(LineItem lineItem){
		String outPutPattern = lineItem.getProduct().isImported() ? IMPORTED_LINE_ITEM_PATTERN : LINE_ITEM_PATTERN;
		String formatedLineItem = String.format(outPutPattern,lineItem.getQuantity(),
				lineItem.getProduct().getName(),lineItem.getProduct().getPrice(), lineItem.getTotalCost());
		return formatedLineItem;
	}
	
	/**
	 * Fomater Order
	 * @param order: la commande
	 * @return une chaine formatée contenant le montant des taxes et le prix total TTC
	 */
	public static String formatTotalOrder(Order order){
		return String.format(TOTAL_ORDER_PATTERN, order.getTotalTax(),order.getTotalCost());
	}
	
	/**
	 * Formater le titre de l'output.
	 *  
	 * @param titeIndex: indice de l'output
	 * @return le titre formaté
	 */
	public static String formatTitle(int titeIndex){
		return String.format(TITLE_PATTERN,titeIndex);
	}
}
