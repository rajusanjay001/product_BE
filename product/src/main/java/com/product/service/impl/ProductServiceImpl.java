package com.product.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

//	@Value("${product.detail.url}")
//	protected String productDetailUrl;

	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Map<String, Object> getProduct(String productId) {
	String productDetailUrl = "https://www.adidas.co.uk/api/products";
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response
		  = restTemplate.getForEntity(productDetailUrl + "/"+productId, String.class);
		
		response.getBody();
		response.getStatusCode();
//		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		return new HashMap<>();
	}

}
