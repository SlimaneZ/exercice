package com.caci.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caci.model.LineItem;
import com.caci.model.Order;
import com.caci.service.LineItemService;
import com.caci.service.OrderService;
import com.caci.service.TaxService;

/**
 * Service commande.
 * 
 * @author slimane
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	
	@Autowired
	private LineItemService lineItemService ;
	
	@Autowired
	private TaxService taxService;

	/**
	 * Construire  la commande Order
	 * 
	 * @param fileName: nom de fichier contenant le détail de la commande
	 *            
	 */
	@Override
	public Order getOrder(String fileName) {
		Order order = new Order();
		List<LineItem> lineItems = lineItemService.createLineItems(fileName);
		//calculer le prix ttc et la tax totale pour chaque lineItem
		lineItems.forEach(lineItem -> {
			lineItem.setTotalCost(taxService.getTotalCostWithTax(lineItem));
			lineItem.setSaleTax(taxService.getSaleTax(lineItem));
			order.getLineItems().add(lineItem);
		});

		BigDecimal totalCost = lineItems.stream()
				                        .map(LineItem :: getTotalCost)
				                        .reduce(BigDecimal :: add)
				                        .get();
		
		order.setTotalCost(totalCost);
		
		BigDecimal totaltax = lineItems.stream()
                .map(LineItem :: getSaleTax)
                .reduce(BigDecimal :: add)
                .get();
		
		order.setTotalTax(totaltax);
		return order;
		
	}
	
	


	/**
	 * Construire  la liste des commandes
	 * 
	 * @param fileName: nom de fichier          
	 */
	@Override
	public List<Order> getOrders(List<String> fileNames) {
		List<Order> orders = new ArrayList<>();
		fileNames.forEach(fileName -> orders.add(getOrder(fileName)) );
		return orders ;
	}


	

}
