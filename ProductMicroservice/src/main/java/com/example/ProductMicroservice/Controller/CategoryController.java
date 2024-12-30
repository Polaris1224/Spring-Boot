package com.example.ProductMicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.ProductMicroservice.Dto.CategoryDto;
import com.example.ProductMicroservice.Entity.Category;
import com.example.ProductMicroservice.Service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService ;
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Category>> getAllCategory() {
		List<Category> list = categoryService.getAllCategory() ;
		return ResponseEntity.status(HttpStatus.OK).body(list) ;
	}
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody CategoryDto categoryDto) {
		Category category = categoryService.addCategory(categoryDto) ;
		return ResponseEntity.status(HttpStatus.CREATED).body(category) ;
	}
	
	@DeleteMapping("/deleteCategory/{categoryName}")
	public ResponseEntity<?> deleteCategoryByName(@PathVariable String categoryName) {
		categoryService.deleteByName(categoryName) ;
		return ResponseEntity.status(HttpStatus.OK).build() ;
	}

}
