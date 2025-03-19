package com.example.OrderMicroservice.Dto;

import java.math.BigDecimal;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Long customerId ;
	private List<OrderItemDTO> items ;
	private BigDecimal totalPrice ;
}
