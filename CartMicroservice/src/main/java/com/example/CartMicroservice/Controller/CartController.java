package com.example.CartMicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CartMicroservice.Dto.CartItemRequest;
import com.example.CartMicroservice.Dto.CartResponse;
import com.example.CartMicroservice.Service.CartService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService ;
	
//	@Autowired
//	private ProductService productService ;
	
	//Called When new User is Created by User Service...
	@PostMapping("/createCart")
	public ResponseEntity<?> createCart(@RequestHeader("userId") Long userId) {
		cartService.createCart(userId) ;
		return ResponseEntity.ok().build() ;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addToCart(@RequestBody CartItemRequest request, @RequestHeader("userId") Long userId) {
		cartService.addToCart(request, userId) ;
		return ResponseEntity.ok().build() ;
	}
	
	@GetMapping("/get")
	public ResponseEntity<CartResponse> getCartByUserId(@RequestHeader("userId") Long userId) {
		CartResponse cart = cartService.getCart(userId) ;
		return ResponseEntity.ok().body(cart) ;
	}
	
	@DeleteMapping("/delete/{cartItemId}")
	public ResponseEntity<?> deleteCartItem(@PathVariable("cartItemId") Long itemId, @RequestHeader("userId") Long userId) {
		cartService.deleteCartItemFromCart(itemId, userId) ;
		return ResponseEntity.ok().build() ;
	}
	
//	@PutMapping("/update/{cartItemId}")
//	public ResponseEntity<?> updateCartItem(@RequestBody @Valid CartItemRequest request) {
//		Optional<ProductDto> optionalProduct = productService.getProduct(request.getCartId()) ;
//		if(optionalProduct.isEmpty()) {
//			return ResponseEntity.notFound().build() ;
//		}
//		
//a		cartService.updateCartItem(request, request.getUserId(), optionalProduct.get()) ;
//		cartService.updateCartItem(request) ;
//		return ResponseEntity.ok().build() ;
//	}
}
