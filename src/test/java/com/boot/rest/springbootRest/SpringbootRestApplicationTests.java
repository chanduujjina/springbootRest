package com.boot.rest.springbootRest;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

@SpringBootTest
public class SpringbootRestApplicationTests {
	
	RestTemplate restTemplate = null;
	HttpEntity <String> entity =null;
	HttpHeaders headers = null;
	
	
	@Before
	
	public void setUP() {
		 restTemplate = new RestTemplate();
		 headers = new HttpHeaders();
		 headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		 entity = new HttpEntity<String>(headers);
	}

	
	
	@Test
	public void testGetAllProducts() {
		
	    ResponseEntity<List> response=restTemplate.exchange( "http://localhost:8080/product-manage/product/allproducts", HttpMethod.GET, entity, List.class);
		List<Product> productList =response.getBody();
		Assert.assertEquals(3, productList.size());
		
	}
	
	@Test
	public void testGetEmloyeeById() {
		
		ResponseEntity<Product> response=restTemplate.exchange( "http://localhost:8080/product-manage/product/getByID/2", HttpMethod.GET, entity, Product.class);
		Product product =response.getBody();
		Assert.assertEquals(2, product.getProductId());
		
}
	
	@Test
	public void testGetProductByAttributes() {
		 ResponseEntity<List> response=restTemplate.exchange( "http://localhost:8080/product-manage/product/attibutes?id=1 & name =pant", HttpMethod.GET, entity, List.class);
			List<Product> productList =response.getBody();
			Assert.assertEquals(1, productList.size());
	}
	
	
	@Test
	public void testSaveProduct() throws JsonProcessingException {
		List<Product> productList = getProductListAsString();
		HttpEntity <List>  entity = new HttpEntity<List>(productList, headers);
		ResponseEntity<List> responseEntity = restTemplate.exchange("http://localhost:8080/product-manage/product/saveProduct", HttpMethod.POST,entity, List.class);
		System.out.println(responseEntity.getBody());
	}
	
	@Test
	public void testupdateProduct() throws JsonProcessingException {
		Product product = new Product(3, "jeans Pant", 30000);
		HttpEntity <Product>  entity = new HttpEntity<Product>(product, headers);
		ResponseEntity<List> responseEntity = restTemplate.exchange("http://localhost:8080/product-manage/product/updateById/3", HttpMethod.PUT,entity, List.class);
		System.out.println(responseEntity.getBody());
	}
	
	private List<Product> getProductListAsString() throws JsonProcessingException{
		
		ObjectMapper mapper = new ObjectMapper();
		List<Product> productList = new ArrayList();
		productList.add(new Product(1, "shirt", 500));
		productList.add(new Product(2, "pant", 900));
		productList.add(new Product(1, "watch", 1500));
		productList.add(new Product(1, "ring", 15000));
		
		return productList;
		
	}
	
	
	

}
