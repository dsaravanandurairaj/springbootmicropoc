package com.disys.springbootmicropoc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disys.springbootmicropoc.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{

	
	
}
