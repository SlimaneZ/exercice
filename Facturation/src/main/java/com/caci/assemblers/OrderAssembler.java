package com.caci.assemblers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.caci.dto.LineItemDto;
import com.caci.dto.OrderDto;
import com.caci.dto.ProductDto;
import com.caci.model.LineItem;
import com.caci.model.Order;
import com.caci.model.Product;

@Component
public class OrderAssembler {

	/**
	 * Convertir l'objet order en OrderDto. 
	 * 
	 * @param order: la commande
	 * @return OrderDto
	 */
	public OrderDto toOrderDto(Order order) {
		OrderDto orderDto = new OrderDto();
		List<LineItemDto> lineItemDtos = new ArrayList<>();
		List<LineItem> lineItems = order.getLineItems();
		for (LineItem lineItem : lineItems) {
			Product product = lineItem.getProduct();
			ProductDto productDto = new ProductDto(product.getName(), product.getPrice(), product.getTax(), product.getProductType());
			productDto.setImported(product.isImported());
			LineItemDto lineItemDto = new LineItemDto(productDto, lineItem.getQuantity(), lineItem.getTotalCost());
			lineItemDto.setProductDto(productDto);
			lineItemDtos.add(lineItemDto);
		}
		orderDto.setLineItemDtos(lineItemDtos);
		orderDto.setTotalCost(order.getTotalCost());
		orderDto.setTotalTax(order.getTotalTax());
		return orderDto;
	}
	
	public List<OrderDto> toOrderDtos(List<Order> orders){
		List<OrderDto> orderDtos = new ArrayList<>();
			orders.forEach(order -> orderDtos.add(toOrderDto(order)));
		return orderDtos;
	}
	
	

}
