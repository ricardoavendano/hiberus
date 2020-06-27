package com.hiberus.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.hiberus.order.domain.Product;

@Component
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	@Query("SELECT u FROM Product u WHERE u.clientIdPK.clientId = :clientId")
	List<Product> productList(@Param("clientId") Long clientId);
}