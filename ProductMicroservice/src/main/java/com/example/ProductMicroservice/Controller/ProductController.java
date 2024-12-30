package com.example.ProductMicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProductMicroservice.Dto.ProductDto;
import com.example.ProductMicroservice.Entity.Product;
import com.example.ProductMicroservice.Service.ProductService;


@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService prodService ;
	
	@GetMapping("/getAll")
	public List<Product> getAllProducts() {
		return prodService.getAllProduct() ;
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable Long id) {
		return prodService.getProductById(id) ;
	}
	
	@GetMapping("/getProductsByCategoryId/{categoryId}")
	public List<Product> getProductByCategoryId(@PathVariable Long categoryId) {
		return prodService.getProductByCategoryId(categoryId) ;
	}
	
	@GetMapping("/getProductsByCategoryName/{categoryName}")
	public List<Product> getProductByCategoryName(@PathVariable String categoryName) {
		return prodService.getProductByCategoryName(categoryName) ;
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> createProduct(@RequestBody ProductDto product) {
		Product savedProduct = prodService.createProduct(product) ;
		return ResponseEntity.status(HttpStatus.CREATED)
							 .body(savedProduct) ;
	}
	
	@DeleteMapping("/deleteProductById/{id}")
	public ResponseEntity<Void> deleteProductById(@PathVariable Long id) { 
		prodService.deleteProductById(id) ;
		return ResponseEntity.status(HttpStatus.OK)
							 .build() ;
	}
	
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) {
		Product updatedProduct = prodService.updateProduct(id, product) ;
		if(updatedProduct != null) {
			return ResponseEntity.status(HttpStatus.OK)
					    		 .body(updatedProduct) ;
		}
		return ResponseEntity.notFound()
							 .build() ;
	}
}
