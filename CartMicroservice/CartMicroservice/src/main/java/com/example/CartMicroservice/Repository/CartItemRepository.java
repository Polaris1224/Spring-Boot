package com.example.CartMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CartMicroservice.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

}
