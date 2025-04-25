package com.example.OrderMicroservice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.OrderMicroservice.Dto.OrderDTO;
import com.example.OrderMicroservice.Dto.OrderItemRequest;
import com.example.OrderMicroservice.Entity.Order;
import com.example.OrderMicroservice.Entity.OrderItem;
import com.example.OrderMicroservice.Repository.OrderItemRepository;
import com.example.OrderMicroservice.Repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepo ;
	
	@Autowired
	private OrderItemRepository orderItemRepo ;
	
	//I need to have contact with cart for orders
	//I need to have a contact with notification service for passing on notification
	
	@Transactional
	public Order placeOrder(OrderDTO orderRequest) {
		// Get User Id -> Get cart Item from cart using the userId from cart Microservice
		
		//Placing Order
		Order order = Order.builder()
						   .customerId(orderRequest.getCustomerId())
						   .totalPrice(orderRequest.getTotalPrice())
						   .build() ;
		
		List<OrderItem> orderItemList = new ArrayList<>() ;
		
		//Placing each OrderItem in the inventory
		orderRequest.getItems().stream().forEach(orderItem -> {
			OrderItem item = OrderItem.builder()
									  .order(order)
									  .quantity(orderItem.getQuantity())
									  .productId(orderItem.getProductId()) 
									  .price(orderItem.getPrice())
									  .build() ; 
			orderItemList.add(item) ;
			orderItemRepo.save(item) ;
		}) ;
		
		order.setItems(orderItemList);
		orderRepo.save(order) ;
		//Generate Order Summary
//		User user = userService.getUser() ;
//		String subjectString = "Order placed with ID : " + savedOrder.getId() ;
//		if(user != null) {
//			sendNotification(user.getEmail(), subjectString) ;
//		}
		
		return order ;
	}

	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepo.findAll() ;
	}

	public Order getOrderById(long id) {
		// TODO Auto-generated method stub
		return orderRepo.findById(id).get() ;
	}
}
