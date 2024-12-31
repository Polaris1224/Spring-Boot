package com.example.CartMicroservice.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.CartMicroservice.Dto.CartItemRequest;
import com.example.CartMicroservice.Dto.CartResponse;
import com.example.CartMicroservice.Entity.Cart;
import com.example.CartMicroservice.Entity.CartItem;
import com.example.CartMicroservice.Repository.CartItemRepository;
import com.example.CartMicroservice.Repository.CartRepository;

@Service
public class CartService {
	
	private final RestTemplate template ;
	
	public CartService(RestTemplateBuilder builder) {
		this.template = builder.build() ;
	}
	
	@Autowired
	private CartRepository cartRepo ;
	
	@Autowired
	private CartItemRepository cartItemRepo ;
	
	public void addToCart(CartItemRequest request, Long userId) {
		// TODO Auto-generated method stub
		
		//Confirm Product Id from product service
		
		//Get Cart By UserId
		Cart cart = cartRepo.findByUserId(userId).get() ;
		List<CartItem> items = cart.getList() ;
		CartItem cartItem = CartItem.builder()
									.productId(request.getProductId())
									.quantity(request.getQuantity())
									.price(request.getPrice())
									.cart(cart)
									.build() ;
		
		items.add(cartItem) ;
		cart.setList(items);
		cartRepo.save(cart) ;
	}

	public CartResponse getCart(Long userId) {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findByUserId(userId).get() ;
		return CartResponse.builder()
						   .userId(cart.getUserId())
						   .totalPrice(cart.getTotalPrice())
						   .list(cart.getList())
						   .build() ;
		
	}

	public void deleteCartItemFromCart(Long itemId, Long userId) {
		// TODO Auto-generated method stub
		Cart cart = cartRepo.findByUserId(userId).get() ;
		CartItem cartItem = cartItemRepo.findById(itemId).get() ;
		List<CartItem> list = cart.getList() ;
		list.remove(cartItem) ;
		cart.setList(list) ;
		cartItemRepo.delete(cartItem) ;
		cartRepo.save(cart) ;
	}

	public void updateCartItem(CartItemRequest request) {
		// TODO Auto-generated method stub
		
	}

	public void createCart(Long userId) {
		// TODO Auto-generated method stub

		//Get User By Id
//		String resourseUrl = "http://localhost:8080/application/user/getUser/{userId}" ;
//		Boolean isUserPresent = Boolean.TRUE.equals(template.getForEntity(resourseUrl, Boolean.class, userId).getBody()) ;
		
		Cart cart = Cart.builder()
						.userId(userId)
						.list(new ArrayList<>())
						.build() ;
		
		cartRepo.save(cart) ;
	}

}
