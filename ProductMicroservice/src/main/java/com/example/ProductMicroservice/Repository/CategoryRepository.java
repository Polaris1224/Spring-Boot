package com.example.ProductMicroservice.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductMicroservice.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	Optional<Category> findByName(String name) ;
}
