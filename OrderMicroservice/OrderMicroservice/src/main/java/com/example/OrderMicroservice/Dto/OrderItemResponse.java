package com.example.OrderMicroservice.Dto;

import java.util.Date;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {
	private long id ;
	private Date createdDate ;
	private int totalPrice ;
	private String address ;
	private String payment ;
}
