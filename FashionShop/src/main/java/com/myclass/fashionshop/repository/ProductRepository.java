package com.myclass.fashionshop.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myclass.fashionshop.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByStatus(String status);
	@Query("SELECT p FROM Product p")
	Page<Product> getAllProducts(Pageable pageable);

	@Query(value = "SELECT * FROM product ORDER BY ((1-discount)*PRICE) DESC", nativeQuery = true)
	Page<Product> descPrice(Pageable pageable);

	@Query(value = "SELECT * FROM product ORDER BY ((1-discount)*PRICE) ASC", nativeQuery = true)
	Page<Product> ascPrice(Pageable pageable);
	
	@Query(value = "SELECT * FROM fashionshop.product ORDER BY (sales/quantity) DESC", nativeQuery = true)
	Page<Product> bestSelling(Pageable pageable);
}
