package com.product.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.review.entities.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

	Review findByProductId(String productId);

	void deleteByProductId(String productId);

}
