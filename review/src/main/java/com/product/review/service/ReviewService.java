package com.product.review.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.product.review.dto.ReviewDto;
import com.product.review.exception.handler.ReviewNotFoundException;

public interface ReviewService {
	public ResponseEntity<Map<String, Object>>addReview(ReviewDto review);

	public ResponseEntity<Map<String, Object>> updateReview(ReviewDto review) throws ReviewNotFoundException;

	public ResponseEntity<Map<String, Object>> getReviews(String productId) throws ReviewNotFoundException;

	public ResponseEntity<Map<String, Object>> deleteReview(String productId) throws ReviewNotFoundException;

}
