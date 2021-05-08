
/*package com.boot.rest.springbootRest;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.github.benmanes.caffeine.cache.AsyncCache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class ProductInfoClient {
	
	  private static final int REI_PREFERRED_SIM_SKU_REFRESH_INTERVAL_HOURS = 24;

	  public static final AsyncCache<String, String> SIM_SKU_CACHE = Caffeine.newBuilder()
	                                                                     .expireAfterWrite(REI_PREFERRED_SIM_SKU_REFRESH_INTERVAL_HOURS, TimeUnit.HOURS)
	                                                                     .buildAsync();

	
	@Test
	public void testAllProducts() {
		
		RestTemplate restTemplate = new RestTemplate();
		String url
		  = "http://localhost:8080/product/allproducts";
		List<Product> productList
		  = restTemplate.getForObject(url, List.class);
		//Assert.assertEquals(productList.size(), 3);
		System.out.println(productList);
	}
	@Test
	public void testProductByAttributes() {
		RestTemplate restTemplate = new RestTemplate();
		String url
		  = "http://localhost:8080/product/attibutes?id=1&&name=pant";
		List<Product> productList
		  = restTemplate.getForObject(url, List.class);
		Assert.assertEquals(productList.size(), 2);
		System.out.println(productList);
	}
	
	@Test
	public void testSaveProduct() {
		RestTemplate restTemplate = new RestTemplate();
		String url= "http://localhost:8080/product/saveProduct";
		List<Product> productList =getProductList();
		List<Product> finalproductList=restTemplate.postForObject(url, productList, List.class);
		System.out.println(finalproductList);
	}
	private List<Product> getProductList() {
		List<Product> productList = new ArrayList();
		productList.add(new Product(4, "night pant", 500));
		productList.add(new Product(2, "branded jeans", 1000));
		
		return productList;
	}
	
	@Test
	public void testdeleteProductById() {
		RestTemplate restTemplate = new RestTemplate();
		String url= "http://localhost:8080/product/deleteById/1";
		restTemplate.delete(url);
	}
	
	
	

}*/

/*
 * package com.boot.rest.springbootRest;
 * 
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.junit.Assert; import org.junit.Test; import
 * org.springframework.http.HttpEntity; import
 * org.springframework.web.client.RestTemplate;
 * 
 * public class ProductInfoClient {
 * 
 * @Test public void testAllProducts() {
 * 
 * RestTemplate restTemplate = new RestTemplate(); String url =
 * "http://localhost:8080/product/allproducts"; List<Product> productList =
 * restTemplate.getForObject(url, List.class);
 * Assert.assertEquals(productList.size(), 3); System.out.println(productList);
 * }
 * 
 * @Test public void testProductByAttributes() { RestTemplate restTemplate = new
 * RestTemplate(); String url =
 * "http://localhost:8080/product/attibutes?id=1&&name=pant"; List<Product>
 * productList = restTemplate.getForObject(url, List.class);
 * Assert.assertEquals(productList.size(), 2); System.out.println(productList);
 * }
 * 
 * @Test public void testSaveProduct() { RestTemplate restTemplate = new
 * RestTemplate(); String url= "http://localhost:8080/product/saveProduct";
 * List<Product> productList =getProductList(); List<Product>
 * finalproductList=restTemplate.postForObject(url, productList, List.class);
 * System.out.println(finalproductList); } private List<Product>
 * getProductList() { List<Product> productList = new ArrayList();
 * productList.add(new Product(4, "night pant", 500)); productList.add(new
 * Product(2, "branded jeans", 1000));
 * 
 * return productList; }
 * 
 * @Test public void testdeleteProductById() { RestTemplate restTemplate = new
 * RestTemplate(); String url= "http://localhost:8080/product/deleteById/1";
 * restTemplate.delete(url); }
 * 
 * 
 * }
 */

