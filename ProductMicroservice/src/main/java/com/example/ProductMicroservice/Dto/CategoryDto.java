package com.example.ProductMicroservice.Dto;

import java.util.List;

import com.example.ProductMicroservice.Entity.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryDto {
	private String name ;
	private List<Product> products ;
}
