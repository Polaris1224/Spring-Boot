package com.example.ProductMicroservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductMicroservice.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByCategoryId(Long categoryId) ;
	List<Product> findByCategoryName(String categoryName) ;
	
}
