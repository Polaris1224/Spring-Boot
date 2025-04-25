package com.example.ProductMicroservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductMicroservice.Dto.CategoryDto;
import com.example.ProductMicroservice.Entity.Category;
import com.example.ProductMicroservice.Repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo ;
	
	public Category addCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		Category category = Category.builder()
									.name(categoryDto.getName())
									.products(categoryDto.getProducts())
									.build() ;
		return categoryRepo.save(category) ;
	}

	public void deleteByName(String categoryName) {
		// TODO Auto-generated method stub
		Category category = categoryRepo.findByName(categoryName).get() ;
		categoryRepo.deleteById(category.getId()) ;
	}

	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoryRepo.findAll() ;
	}

}
