package com.product.review.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.review.entities.Review;
import com.product.review.repository.ReviewRepo;
import com.product.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewDao;

	@Override
	public Map<String, Object> addReview(Map<String, Object> review) {

		Review insertEntity = new Review();
		Review responseEntity = new Review();

		insertEntity.setNumberOfReviews(Integer.parseInt(review.get("numberOfReviews").toString()));
		insertEntity.setProductId(review.get("productId").toString());
		insertEntity.setAverageReviewScore(Float.parseFloat(review.get("averageScore").toString()));
		responseEntity = reviewDao.save(insertEntity);
		Map<String, Object> response = new HashMap<>();
		response.put("reviewId", responseEntity.getReviewId());

		return response;
	}

	@Override
	public List<Review> getReviews(String productId) {

		if (productId.isEmpty())
			return reviewDao.findAll();
		else
			return reviewDao.findByProductId(productId);
	}

	@Override
	public Map<String, Object> updateReview(Map<String, Object> review) {

		Review ob = new Review();
		ob.setNumberOfReviews(Integer.parseInt(review.get("numberOfReviews").toString()));
		ob.setProductId(review.get("productId").toString());
		ob.setAverageReviewScore(Float.parseFloat(review.get("averageScore").toString()));
		ob.setReviewId(Integer.parseInt(review.get("productId").toString()));
		reviewDao.save(ob);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "success");
		response.put("responseMessage", "Updated Successfully");
		return response;
	}

	@Override
	public Map<String, Object> deleteReview(String productId) {
		reviewDao.deleteByProductId(productId);
		Map<String, Object> response = new HashMap<>();
		response.put("status", "success");
		response.put("responseMessage", "Review deleted Successfully");
		return response;
	}

}
