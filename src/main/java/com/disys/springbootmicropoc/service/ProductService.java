package com.disys.springbootmicropoc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.disys.springbootmicropoc.model.ProductModel;

public interface ProductService {

	public Long insertData(ProductModel product);
	public ProductModel getProductById(Long productid);
	public List<ProductModel> getProductDetails();
	public String deleteProduct(Long productid);
	public String updateProduct(Long productid,ProductModel product);
	
}
