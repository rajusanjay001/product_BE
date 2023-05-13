package com.product.review.service;

import java.util.List;
import java.util.Map;

import com.product.review.entities.Review;

public interface ReviewService {
	public Map<String, Object> addReview(Map<String, Object> review);

	public Map<String, Object> updateReview(Map<String, Object> review);

	public List<Review> getReviews(String productId);

	public Map<String, Object> deleteReview(String productId);

}
