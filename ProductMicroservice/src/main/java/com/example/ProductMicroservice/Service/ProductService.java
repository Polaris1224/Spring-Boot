package com.example.ProductMicroservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductMicroservice.Dto.ProductDto;
import com.example.ProductMicroservice.Entity.Category;
import com.example.ProductMicroservice.Entity.Product;
import com.example.ProductMicroservice.Repository.CategoryRepository;
import com.example.ProductMicroservice.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo ;

	@Autowired
	private CategoryRepository categoryRepo ;
	
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productRepo.findAll() ;
	}

	public Product getProductById(Long id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id).get() ;
	}

	public List<Product> getProductByCategoryId(Long categoryId) {
		// TODO Auto-generated method stub
		return productRepo.findByCategoryId(categoryId) ;
	}

	public List<Product> getProductByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		return productRepo.findByCategoryName(categoryName) ;
	}

	public Product createProduct(ProductDto productDto) {
		// TODO Auto-generated method stub
		Category category = categoryRepo.findByName(productDto.getCategory().getName()).get() ;
		Category categoryWithId = Category.builder()
									 	  .id(category.getId())
									 	  .build() ;
		Product product = Product.builder()
								 .name(productDto.getName())
								 .price(productDto.getPrice())
								 .description(productDto.getDescription())
								 .category(categoryWithId)
								 .build() ;
		
		return productRepo.save(product) ;
	}

	public void deleteProductById(Long id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id) ;
	}

	public Product updateProduct(Long id, ProductDto productDto) {
		// TODO Auto-generated method stub
		Category category = categoryRepo.findByName(productDto.getCategory().getName()).get() ;
		Category categoryWithId = Category.builder()
									 	  .id(category.getId())
									 	  .build() ;
		
		Product product = Product.builder()
								 .id(id)
								 .name(productDto.getName())
								 .price(productDto.getPrice())
								 .description(productDto.getDescription())
								 .category(categoryWithId)
								 .build() ;
		
		return productRepo.save(product) ;
	}
}
