package com.product.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productSetrvice;

	@GetMapping("/{product_id}")
	public Map<String, Object> getProductDetails(@PathVariable  String product_id) {
		return productSetrvice.getProduct(product_id);
		
	}
}
