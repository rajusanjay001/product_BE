package com.product.review.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.product.review.entities.Review;
import com.product.review.repository.ReviewRepo;
import com.product.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepo reviewDao;

	@Override
	public ResponseEntity<Map<String, Object>> addReview(Map<String, Object> review) {
		Map<String, Object> response = new HashMap<>();
		if (!validateRequest(review)) {
			response.put("status", "failed");
			response.put("responseMessage", "Please check the request body");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		Review insertEntity = new Review();
//		Review responseEntity = new Review();
		insertEntity.setNumberOfReviews(Integer.parseInt(review.get("numberOfReviews").toString()));
		String productId = review.get("productId").toString();
		Review IsProductAvailable = reviewDao.findByProductId(productId);

		if (null == IsProductAvailable) {
			insertEntity.setProductId(productId);
			insertEntity.setAverageReviewScore(Float.parseFloat(review.get("averageReviewScore").toString()));
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
	public ResponseEntity<Map<String, Object>> getReviews(String productId) {

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
	public ResponseEntity<Map<String, Object>> updateReview(Map<String, Object> review) {
		Map<String, Object> response = new HashMap<>();
		if (!validateRequest(review)) {
			response.put("status", "failed");
			response.put("responseMessage", "Please check the request body");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		Review ob = new Review();
		ob.setNumberOfReviews(Integer.parseInt(review.get("numberOfReviews").toString()));
		String productId = review.get("productId").toString();

		Review IsProductAvailable = reviewDao.findByProductId(productId);
		if (null != IsProductAvailable) {
			ob.setProductId(productId);
			ob.setAverageReviewScore(Float.parseFloat(review.get("averageReviewScore").toString()));
//			ob.setReviewId(Integer.parseInt(review.get("productId").toString()));
			reviewDao.save(ob);
			response.put("status", "success");
			response.put("responseMessage", "Updated Successfully");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} else {
			response.put("status", "failed");
			response.put("responseMessage", "Review detail is not present for the product");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

	}

	public Boolean validateRequest(Map<String, Object> review) {
		String productId = review.get("productId").toString();
		if (productId.isEmpty())
			return false;
		try {
			Integer.parseInt(review.get("numberOfReviews").toString());
			Float.parseFloat(review.get("averageReviewScore").toString());
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Transactional
	@Override
	public ResponseEntity<Map<String, Object>> deleteReview(String productId) {
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
