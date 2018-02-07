package com.caci.service;

import java.util.List;

import com.caci.model.Order;

public interface OrderService {
	
	public Order getOrder(String fileName);
	
	public List<Order> getOrders(List<String> fileNames);

}
