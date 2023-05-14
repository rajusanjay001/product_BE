package com.product.service.impl;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

//	@Value("${product.detail.url}")
//	protected String productDetailUrl;
@Autowired
private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Override
	public Map<String, Object> getProduct(String productId) {
	String productDetailUrl = "https://www.adidas.co.uk/api/products";
//	ResponseEntity<Object> response;
	try {	
	URI uri = new URI(productDetailUrl+"/"+productId);
//		response
//		  = restTemplate.exchange(uri, HttpMethod.GET, null,Object.class);
//		response.getBody();
//		response.getStatusCode();
	HttpHeaders headers = new HttpHeaders(); 
	headers.setContentType(MediaType.APPLICATION_JSON); 
	RequestEntity requestEntity = new RequestEntity("", headers, HttpMethod.GET, 
			URI.create("https://api.publicapis.org/entries")); 
	
	ResponseEntity<String> responseEntity = 
	restTemplate.exchange(requestEntity, String.class); 
	responseEntity.getBody();
//		(URI url, HttpMethod method, @Nullable HttpEntity<?> requestEntity,
//				Class<T> responseType)
	}catch(Exception e) {
		
	}
		
//		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
		
		return new HashMap<>();
	}

}
