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