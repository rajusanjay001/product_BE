package com.product.review.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.review.dto.ReviewDto;
import com.product.review.entities.Review;
import com.product.review.exception.handler.ReviewNotFoundException;
import com.product.review.repository.ReviewRepo;
import com.product.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewDao;

	@Override
	public ResponseEntity<Map<String, Object>> addReview(ReviewDto review) {
		Map<String, Object> response = new HashMap<>();

		Review insertEntity = new Review();
//		Review responseEntity = new Review();
		insertEntity.setNumberOfReviews(review.getNumberOfReviews());
		String productId = review.getProductId();
		Review IsProductAvailable = reviewDao.findByProductId(productId);

		if (null == IsProductAvailable) {
			insertEntity.setProductId(productId);
			insertEntity.setAverageReviewScore(review.getAverageReviewScore());
			reviewDao.save(insertEntity);
			response.put("status", "success");
			response.put("responseMessage", "Review added successfully");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		} else {
			response.put("status", "failed");
			response.put("responseMessage", "Review details already exists for the product");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@Override
	public ResponseEntity<Map<String, Object>> getReviews(String productId) throws ReviewNotFoundException{

		if (productId.isEmpty()) {

			List<Review> list = reviewDao.findAll();
			Map<String, Object> response = new HashMap<>();
			response.put("data", list);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			Review data = reviewDao.findByProductId(productId);
			Map<String, Object> response = new HashMap<>();
			if (data == null) {
				response.put("status", "failed");
				response.put("responseMessage", "No reviews available for the product");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			} else {
				response.put("status", "success");
				response.put("data", data);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
			}

		}

	}

	@Override
	public ResponseEntity<Map<String, Object>> updateReview(ReviewDto review) throws ReviewNotFoundException{
		Map<String, Object> response = new HashMap<>();

		Review ob = new Review();

		String productId = review.getProductId();

		Review IsProductAvailable = reviewDao.findByProductId(productId);
		if (null != IsProductAvailable) {
			ob.setNumberOfReviews(review.getNumberOfReviews());
			ob.setProductId(productId);
			ob.setAverageReviewScore(review.getAverageReviewScore());
			reviewDao.save(ob);
			response.put("status", "success");
			response.put("responseMessage", "Updated Successfully");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			response.put("status", "failed");
			response.put("responseMessage", "Review detail is not present for the product");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

	}

//	public Boolean validateRequest(Map<String, Object> review) {
//		String productId = review.get("productId").toString();
//		if (productId.isEmpty())
//			return false;
//		try {
//			Integer.parseInt(review.get("numberOfReviews").toString());
//			Float.parseFloat(review.get("averageReviewScore").toString());
//		} catch (Exception e) {
//			return false;
//		}
//
//		return true;
//	}

	@Transactional
	@Override
	public ResponseEntity<Map<String, Object>> deleteReview(String productId)throws ReviewNotFoundException {
		Review IsProductAvailable = reviewDao.findByProductId(productId);
		if (null != IsProductAvailable) {
			reviewDao.deleteByProductId(productId);
			Map<String, Object> response = new HashMap<>();
			response.put("status", "success");
			response.put("responseMessage", "Review deleted Successfully");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			Map<String, Object> response = new HashMap<>();
			response.put("status", "failed");
			response.put("responseMessage", "no review found for the product");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

	}

}
