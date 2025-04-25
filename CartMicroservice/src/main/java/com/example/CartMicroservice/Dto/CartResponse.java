package com.example.CartMicroservice.Dto;

import java.math.BigDecimal;
import java.util.List;

import com.example.CartMicroservice.Entity.CartItem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartResponse {

	private Long userId ;
	private BigDecimal totalPrice ;
	private List<CartItem> list ;
}
