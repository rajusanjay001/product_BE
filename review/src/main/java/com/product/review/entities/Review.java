package com.product.review.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "review")
@Data
@RequiredArgsConstructor
public class Review {
	@Id
	String productId;
	Float averageReviewScore;
	Integer numberOfReviews;

}
