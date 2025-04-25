package com.example.OrderMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OrderMicroservice.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
