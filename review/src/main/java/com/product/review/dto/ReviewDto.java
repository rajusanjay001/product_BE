package com.product.review.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {

	@NotNull(message = "productId shouldn't be null")
	private String productId;
	@NotNull(message = "averageReviewScore shouldn't be null")
	private Float averageReviewScore;
	@NotNull(message = "numberOfReviews shouldn't be null")
	private Integer numberOfReviews;
	
}
