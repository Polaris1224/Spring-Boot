package com.example.CartMicroservice.Entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="cart-item")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
//	@ManyToOne
	private Long productId ;
	
	private int quantity ;
	private BigDecimal price ;
	
	@ManyToOne
	@JoinColumn(name="cart_id")
	@JsonIgnore
	private Cart cart ;
}
