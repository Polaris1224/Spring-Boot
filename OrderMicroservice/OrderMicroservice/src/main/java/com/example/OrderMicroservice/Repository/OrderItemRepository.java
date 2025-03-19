package com.example.OrderMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderMicroservice.Entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
