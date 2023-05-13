//package com.product.service.impl;
//
//import java.util.Map;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//public class test {
//
//	public static void main(String[] args) {
//		getProduct("BB5476");
//	
//	}
//	
//	static void getProduct(String productId) {
//		
//		String productDetailUrl = "https://www.adidas.co.uk/api/products";
//		
//		RestTemplate restTemplate = new RestTemplate();
//		
//		
//
//		
//		ResponseEntity<Map> response
//		  = restTemplate.getForEntity(productDetailUrl + "/"+productId, Map.class);
//		
//		
//		System.out.println("");
//		response.getBody();
//		response.getStatusCode();
////		Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
//		
//	}
//}
