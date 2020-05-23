package com.disys.springbootmicropoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.disys.springbootmicropoc.model.ProductModel;
import com.disys.springbootmicropoc.service.ProductService;
import com.disys.springbootmicropoc.serviceImpl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(value = "/getProductDetails", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductModel> getProductDetails() {

		return productService.getProductDetails();
	}

	@GetMapping(value = "/getProductById/{productid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductModel getProductById(@PathVariable(value = "productid") Long productid) {
		return productService.getProductById(productid);
	}

	@PostMapping(value = "/insert", produces = MediaType.ALL_VALUE)
	public String saveProduct(@RequestBody ProductModel product) {
		return "Product inserted Successfully with Product ID : " + productService.insertData(product);

	}

	@DeleteMapping(value = "/delete/{productid}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteProduct(@PathVariable(value = "productid") Long productid) {
		return productService.deleteProduct(productid);
	}
	
	@PutMapping(value = "/update/{productid}", produces = MediaType.ALL_VALUE)
	public String updateProduct(@PathVariable(value = "productid") Long productid,@RequestBody ProductModel product) {
		return "Product updated Successfully with Product ID : " + productService.updateProduct(productid, product);

	}


}
