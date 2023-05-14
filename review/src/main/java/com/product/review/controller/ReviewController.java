package com.product.review.controller;

import java.util.Map;

import javax.validation.Valid;

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

import com.product.review.dto.ReviewDto;
import com.product.review.exception.handler.ReviewNotFoundException;
import com.product.review.service.ReviewService;

@RestController
@RequestMapping(value = "/")

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("/review/{product_id}")
	public ResponseEntity<Map<String, Object>> getReview(@PathVariable  String product_id) throws ReviewNotFoundException {

		return reviewService.getReviews(product_id);

	}

	@PutMapping("/auth/review")
	public ResponseEntity<Map<String, Object>> updateReview(@RequestBody @Valid ReviewDto review) throws ReviewNotFoundException {
		return reviewService.updateReview(review);

	}

	@DeleteMapping("/auth/review")
	public ResponseEntity<Map<String, Object>> deleteReview(@RequestParam String productId) throws ReviewNotFoundException {
		return reviewService.deleteReview(productId);
	}

	@PostMapping("/auth/review")
	public ResponseEntity<Map<String, Object>> addReview(@RequestBody @Valid ReviewDto review) {

		return reviewService.addReview(review);

	}
}
