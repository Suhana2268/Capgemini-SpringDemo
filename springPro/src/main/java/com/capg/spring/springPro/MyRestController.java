package com.capg.spring.springPro;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MyRestController {
	
	@Autowired
	ProductDAOImpl dao;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	
	
	@PostMapping("/product/{r1}/{r2}")
	public List<Product> getProdutsByRange(@PathVariable int r1, @PathVariable int r2) {
		return dao.getProductsByRange(r1, r2);
	}
	
	@GetMapping("/product/{searchId}")
	public Product getProductById(@PathVariable int searchId) {
		return dao.getProductById(searchId);
	}
	
	@GetMapping("/product/rating/{r1}/{r2}")
	public List<Product> getProductByRating(@PathVariable int r1, @PathVariable int r2) {
		return dao.getProductsByRating(r1, r2);
	}
	
	@PostMapping("/product")
	public List<Product> getProduct() {
		return dao.getAllProducts();
	}
	
	@GetMapping("/product/delete/{searchId}")
	public Product deleteProductById(@PathVariable int searchId) {
		return dao.doDeleteById(searchId);
	}
	
	
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product p) {
		return dao.doProductUpdate(p, p.getProductId());
	}
	
	@PostMapping("/product/add")
	public Product doAddProduct(@RequestBody Product p) {
		
		if(dao.addProduct(p)) {
			return p;
		}
		else 
			return null;
	}
 
}