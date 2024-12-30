package com.example.ProductMicroservice.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.dialect.function.array.ArraySliceUnnestFunction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	private String name ;
	
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
	private List<Product> products ;
	
//	public void add(Product tempProduct) {
//		if(tempProduct == null) {
//			products = new ArrayList<Product>() ;
//		}
//		
//		products.add(tempProduct) ;
//		tempProduct.setCategory(this);
//	}
}
