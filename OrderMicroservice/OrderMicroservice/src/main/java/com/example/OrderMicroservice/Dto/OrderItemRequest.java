package com.example.OrderMicroservice.Dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemRequest {
	private long userId ;
	private String address ;
	private String payment ;
}
