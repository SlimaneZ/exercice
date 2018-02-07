package com.caci.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.caci.model.Order;
import com.caci.service.PrintService;
import com.caci.util.PrintUtil;

/**
 * Service impression sur console.
 * 
 * @author Slimane
 *
 */
@Service
public class PrintConsoleServiceImpl implements PrintService {
	
	private static final String TITLE = "### OUTPUT\n\n";

	/**
	 * Imprimer une commande sur console 
	 * 
	 * @param order: la commande
	 */
	@Override
	public void orintOrder(Order order) {
		order.getLineItems().forEach(lineItem -> System.out.print(PrintUtil.formatLineItem(lineItem)));
		System.out.print(PrintUtil.formatTotalOrder(order));
	}

	
	/**
	 * Imprimer la liste des commandes sur console 
	 * 
	 * @param order: la commande
	 */
	@Override
	public void printOrders(List<Order> orders) {
		
		int outputIndex = 1;
		System.out.printf(TITLE);
		for (Order order : orders) {
			System.out.print(PrintUtil.formatTitle(outputIndex));
			orintOrder(order);
			outputIndex++;
		}
		
	}

}
