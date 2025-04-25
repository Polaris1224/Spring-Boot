package com.example.CartMicroservice.Dto;

import java.math.BigDecimal;

import com.example.CartMicroservice.Entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemRequest {
	private Long productId ;
	private int quantity ;
	private BigDecimal price ;
}
