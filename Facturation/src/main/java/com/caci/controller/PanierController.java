package com.caci.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caci.assemblers.OrderAssembler;
import com.caci.dto.OrderDto;
import com.caci.model.Order;
import com.caci.service.OrderService;
import com.caci.service.PrintService;
import com.caci.util.ProductUtil;


@RestController
@RequestMapping(value = "/api/v1/factures")
public class PanierController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private PrintService printService;
	
	@Autowired
	private OrderAssembler orderAssembler;
	
	@GetMapping()
	public List<OrderDto> retrieveAllOrders(){
		List<String> fileNames = ProductUtil.getAllFileNames();
		List<Order> orders = orderService.getOrders(fileNames);
		printService.printOrders(orders);
		return orderAssembler.toOrderDtos(orders);
	}
	
	@GetMapping( value = "{id}")
	public OrderDto retrieveOrdersByFile(@PathVariable Long id){
		StringBuilder sb = new StringBuilder("input");
		sb.append(id).append(".txt");
		Order order = orderService.getOrder(sb.toString());
		printService.orintOrder(order);
		return orderAssembler.toOrderDto(order);
		
	}
	

	
	

}
