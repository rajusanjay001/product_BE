package com.product.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Value("${product.detail.url}")
	protected String productDetailUrl;

	@Value("${product.review.url}")
	protected String reviewUrl;

	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Map<String, Object> getProduct(String productId) {
		Map<String, Object> body = new HashMap<>();
		Map<String, Object> data = new HashMap<>();
		
		try {
			URI uri = new URI(productDetailUrl + "/" + productId);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			RequestEntity requestEntity = new RequestEntity("", headers, HttpMethod.GET, uri);

			ResponseEntity<Map> responseEntity = restTemplate.exchange(requestEntity, Map.class);
			body = responseEntity.getBody();
			
		} catch (ResourceAccessException e) {
			body.put("message", "there was a time out for getting the product details");
			logger.error("Exception in getting details for the product", e);
		} catch (URISyntaxException e) {
			body.put("message", "issue in getting product details");
			logger.error("Exception in getting details for the product", e);
		}
		Map<String, Object> review = getReview(productId);
		String status = !review.isEmpty() && review.containsKey("status") && null != review.get("status")
				? review.get("status").toString()
				: "failed";
		if (status.equalsIgnoreCase("success")) {
			data = (Map<String, Object>) review.get("data");
		}
		body.put("review", data);
		return body;
	}

	public Map<String, Object> getReview(String productId) {
		Map<String, Object> body = new HashMap<>();
		try {
			URI uri = new URI(reviewUrl + "/" + productId);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			RequestEntity requestEntity = new RequestEntity("", headers, HttpMethod.GET, uri);

			ResponseEntity<Map> responseEntity = restTemplate.exchange(requestEntity, Map.class);
			body = responseEntity.getBody();
		} catch (Exception e) {
			logger.error("Exception in getting review for the product", e);
		}

		return body;
	}

}
