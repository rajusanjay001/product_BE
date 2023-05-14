package com.product.service.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
		getReview(productId);
//		String productDetailUrl = "https://www.adidas.co.uk/api/products";
//		try {
//			URI uri = new URI(productDetailUrl + "/" + productId);
//
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_JSON);
//			RequestEntity requestEntity = new RequestEntity("", headers, HttpMethod.GET,
//					URI.create("https://api.publicapis.org/entries"));
//
//			ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);
//			responseEntity.getBody();
//		} catch (Exception e) {
//
//		}

		return new HashMap<>();
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
