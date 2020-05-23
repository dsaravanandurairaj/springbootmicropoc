package com.disys.springbootmicropoc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disys.springbootmicropoc.exceptions.ProductNotFoundException;
import com.disys.springbootmicropoc.model.ProductModel;
import com.disys.springbootmicropoc.repository.ProductRepository;
import com.disys.springbootmicropoc.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Long insertData(ProductModel product) {
		return productRepository.save(product).getProductid();
	}

	@Override
	public ProductModel getProductById(Long productid) {

		
	return productRepository.findById(productid).orElseThrow(() -> new ProductNotFoundException(productid, "Product Not found"));
			 
	}

	@Override
	public List<ProductModel> getProductDetails() {
		
		return productRepository.findAll();
	}

	@Override
	public String deleteProduct(Long productid) {
		
		
		productRepository.delete(getProductById(productid));
		
		return "Product Deleted Successfully" ;
	}

	public String updateProduct(Long productid, ProductModel product) {
		
		ProductModel product1=getProductById(productid);
		product1.setProductid(product.getProductid());
		product1.setProname(product.getProname());
		product1.setProcategory(product.getProcategory());
		product1.setProductbrand(product.getProductbrand());
		product1.setProductprice(product.getProductprice());
		productRepository.save(product1);
		return "Product Updated Successfully";
	}

	
}
