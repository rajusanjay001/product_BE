package com.product.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.review.entities.Review;

public interface ReviewRepo extends JpaRepository<Long, Review> {

}
