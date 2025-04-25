package com.example.OrderMicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.OrderMicroservice.Dto.OrderDTO;
import com.example.OrderMicroservice.Dto.OrderItemRequest;
import com.example.OrderMicroservice.Entity.Order;
import com.example.OrderMicroservice.Service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService ;
	
	@PostMapping("/add")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderDTO order) {
		Order orderResponse = orderService.placeOrder(order) ;
		return new ResponseEntity<>(orderResponse, HttpStatus.CREATED) ;
	}
	
	@GetMapping("/get")
	public List<Order> getAllOrders() {
		List<Order> orderList = orderService.getAllOrders() ;
		return orderList ;
	}
	
	@GetMapping("/get/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id) ;
	}
}
