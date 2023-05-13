package com.product.review.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.service.ReviewService;

@RestController
@RequestMapping(value = "/review")

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public ResponseEntity<Map<String, Object>> getReview(@RequestParam String productId) {

		Map<String, Object> map = new HashMap<>();
		map.put("data", reviewService.getReviews(productId));
		return new ResponseEntity<>(map, HttpStatus.OK);

	}

	@PutMapping
	public ResponseEntity<Map<String, Object>> updateReview(@RequestBody Map<String, Object> review) {
		return new ResponseEntity<>(reviewService.updateReview(review), HttpStatus.OK);

	}

	@DeleteMapping
	public ResponseEntity<Map<String, Object>> deleteReview(@RequestParam String productId) {
		return new ResponseEntity<>(reviewService.deleteReview(productId), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Map<String, Object>> addReview(@RequestBody Map<String, Object> review) {

		return new ResponseEntity<>(reviewService.addReview(review), HttpStatus.OK);

	}
}
