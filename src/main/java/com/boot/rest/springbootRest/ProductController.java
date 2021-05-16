package com.boot.rest.springbootRest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.rest.springbootRest.exception.ProductNotFoundException;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productservice;
	
	
	@GetMapping(path="/getByID/{id}")
	public ResponseEntity getEmloyeeById(@PathVariable(value="id") int id) {
		Product product = productservice.getProductById(id);
		if(product == null) {
			throw new ProductNotFoundException();
		}
		
		return new ResponseEntity(product, HttpStatus.OK);
	}

	@GetMapping(path = "/attibutes")
	public ResponseEntity getProductByAttributes(@RequestParam(value ="id",required = false) int id,@RequestParam(value="name",required = false) String name) throws Exception {
		if(id<=0 || null!=name && name.isEmpty()) {
			throw new Exception("atlease one parameter is required to proceed");
		}
		List<Product> filteredProductList =getProductsByAttributes(id,name);
		ResponseEntity entity =null;
		if(filteredProductList!=null && !filteredProductList.isEmpty()) {
			return new ResponseEntity(filteredProductList, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	
	//enhanced get endpoint
	@GetMapping(path = "/attibutes_v1")
	public ResponseEntity getProductByAttributesv1(@RequestParam MultiValueMap<String, String> allParams) throws Exception {
		if(allParams.isEmpty()) {
			throw new Exception("atlease one parameter is required to proceed");
		}
		int id=Integer.parseInt(allParams.getFirst("id"));
		String name =allParams.getFirst("name");
		List<Product> filteredProductList =getProductsByAttributes(id,name);
		ResponseEntity entity =null;
		if(filteredProductList!=null && !filteredProductList.isEmpty()) {
			return new ResponseEntity(filteredProductList, HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.NO_CONTENT);
		
	}
	@GetMapping("/allproducts")
	public ResponseEntity getAllProducts() {
		List<Product> productList =productservice.getProductList();
		ResponseEntity entity = new ResponseEntity(productList, HttpStatus.OK);
		return entity;
	}
	
	public List<Product> saveProduct_v1(){
		return null;
	}
	@PostMapping(path="/saveProduct")
	public ResponseEntity saveProduct(@RequestBody List<Product> productList) {
		List<Product> finalproductList = productservice.saveProduct(productList);
		ResponseEntity entity = new ResponseEntity(finalproductList, HttpStatus.ACCEPTED);
		return entity;
	}
	
	@DeleteMapping(path="/deleteById/{id}")
	public ResponseEntity deleteProductById(@PathVariable(value = "id") int id) throws Exception {
		Product product = productservice.getProductById(id);
		if(product == null) {
			throw new Exception("no product found to delete");
		}
		List<Product> finalproductList= productservice.deleteProductByID(id);
		return new ResponseEntity(finalproductList,HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(path="/updateById/{id}")
	public ResponseEntity updateProductById(@PathVariable(value="id") int id, @RequestBody Product product) throws Exception {
		Product updateproduct = productservice.getProductById(id);
		if(updateproduct == null) {
			throw new Exception("no product found to update");
		}
		
		List<Product> finalproductList = productservice.updateProduct(id, product);
		return new ResponseEntity(finalproductList, HttpStatus.ACCEPTED);
		
	}
	
	@PatchMapping(path="/saveorupdate/{id}")
	public ResponseEntity saveorupdate(@PathVariable(value="id", required = false) int id, @RequestBody Product product) throws Exception {
		List<Product> finalproductList =null;
		Product updateproduct = productservice.getProductById(id);
		if(updateproduct == null) {
			List<Product> productList = new ArrayList<Product>();
			productList.add(product);
			finalproductList = productservice.saveProduct(productList);
			return new ResponseEntity(finalproductList, HttpStatus.ACCEPTED);
		}
		
		finalproductList = productservice.updateProduct(id, new Product(1, "casual shirt", 1000));
		return new ResponseEntity(finalproductList, HttpStatus.ACCEPTED);
		
	}
	
	private List<Product> getProductsByAttributes(int id,String name){
		List<Product> productList =productservice.getProductList();
		return productList.stream().filter(product->product.getProductId()==id||product.getProductName().equals(name)).collect(Collectors.toList());
	}
	
	
	

}
