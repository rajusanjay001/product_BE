package com.product.review.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface ReviewService {
	public ResponseEntity<Map<String, Object>>addReview(Map<String, Object> review);

	public ResponseEntity<Map<String, Object>> updateReview(Map<String, Object> review);

	public ResponseEntity<Map<String, Object>> getReviews(String productId);

	public ResponseEntity<Map<String, Object>> deleteReview(String productId);

}
