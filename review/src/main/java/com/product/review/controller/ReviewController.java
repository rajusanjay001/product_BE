package com.product.review.controller;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.service.ReviewService;

@RestController
@RequestMapping(value = "/")//add if in case we need custom path 

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/review/{product_id}")
	public ResponseEntity<Map<String, Object>> getReview(@PathVariable  String product_id) {

		return reviewService.getReviews(product_id);

	}

	@PutMapping("/auth/review")
	public ResponseEntity<Map<String, Object>> updateReview(@RequestBody Map<String, Object> review) {
		return reviewService.updateReview(review);

	}

	@DeleteMapping("/auth/review")
	public ResponseEntity<Map<String, Object>> deleteReview(@RequestParam String productId) {
		return reviewService.deleteReview(productId);
	}

	@PostMapping("/auth/review")
	public ResponseEntity<Map<String, Object>> addReview(@RequestBody Map<String, Object> review) {

		return reviewService.addReview(review);

	}
}
