package com.product.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ecommerce.dao.ProductRepository;
import com.product.ecommerce.entity.Product;

@Service
public class ProductService  {

	@Autowired
	private ProductRepository repo;


	public List<Product> getProducts() {
		return repo.findAll();
	}


	public Product createProduct(Product product) {
		return repo.save(product);
	}


	public Product updateProduct(int id, Product product) {
		Optional<Product> existingproduct= repo.findById(id);

		if(existingproduct.isPresent())
		{
			repo.save(product); 
			return product;
		}
		return null;
	}


	public Product getProduct(int productId) {
		Optional<Product> existingproductOpt = repo.findById(productId);

		if(existingproductOpt.isPresent())
		{
			Product existingproduct=existingproductOpt.get();
			return existingproduct;
		}
		return null;
	}


	public boolean deleteProduct(int productId) {
		Optional<Product> existingproductOpt = repo.findById(productId);

		if(existingproductOpt.isPresent())
		{
			repo.deleteById(productId);
			return true;
		}

		return false;
	}

}
