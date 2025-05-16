package com.product.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.ecommerce.entity.Product;
import com.product.ecommerce.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product b = service.createProduct(product);
		return new ResponseEntity<Product>(b, HttpStatus.OK);
		
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product){
		
		Product b = service.updateProduct(id, product);
		return new ResponseEntity<Product>(b, HttpStatus.OK);
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id){
		boolean isDeleted = service.deleteProduct(id);
		if(isDeleted){
			String responseContent = "Product has been deleted successfully";
			return new ResponseEntity<String>(responseContent,HttpStatus.OK);
		}
		String error = "Error while deleting product from database";
		return new ResponseEntity<String>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts(){
		
		List<Product> products = service.getProducts();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") Integer id){
		Product product = service.getProduct(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
