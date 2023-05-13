package com.product.review.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.service.ReviewService;

@RestController
@RequestMapping(value = "/review")

public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping
	public Map<String, Object> getReview(@RequestBody Map<String, Object> review) {
		return null;

	}

	@PutMapping
	public Map<String, Object> updateReview(@RequestBody Map<String, Object> review) {
		return null;

	}

	@DeleteMapping
	public Map<String, Object> deleteReview(@RequestBody Map<String, Object> review) {
		return null;

	}

	@PostMapping
	public Map<String, Object> addReview(@RequestBody Map<String, Object> review) {
		return null;

	}
}
