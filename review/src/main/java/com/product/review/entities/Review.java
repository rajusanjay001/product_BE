package com.product.review.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Table
@Entity
@Data
@AllArgsConstructor
public class Review {

	Integer productId;
	Float averageReviewScore;
	Integer numberOfReviews;
	
}
