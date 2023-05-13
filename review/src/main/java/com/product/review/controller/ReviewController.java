package com.product.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.service.ReviewService;

@RestController
@RequestMapping(value = "/review")

public class ReviewController {

	@Autowired
	private ReviewService reviewService;
}
