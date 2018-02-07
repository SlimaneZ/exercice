package com.caci.service;

import java.util.List;

import com.caci.model.Order;

public interface PrintService {
	
	public void orintOrder(Order order);
	
	public void printOrders(List<Order> orders);

}
