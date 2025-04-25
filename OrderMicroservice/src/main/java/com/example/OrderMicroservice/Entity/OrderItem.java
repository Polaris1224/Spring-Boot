package com.example.OrderMicroservice.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="order_items")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order ;
	
//	@ManyToOne
//	@JoinColumn(name="product_id")
//  Product Id from Product Service
	private Long productId ;
	
	private int quantity ;
	
	private double price ;
}
