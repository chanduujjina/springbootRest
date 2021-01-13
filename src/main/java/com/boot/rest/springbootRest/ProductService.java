package com.boot.rest.springbootRest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
@Service
public class ProductService {
	
	private static List<Product> productList = new ArrayList();
	
	static {
		productList.add(new Product(1, "casual shirt", 500));
		productList.add(new Product(2, "tea shirt", 500));
		productList.add(new Product(3, "pant", 1000));
	}
	
	public  List<Product> getProductList(){
		return productList;
	}
	
	public List<Product> saveProduct(List<Product> addedproductList){
		 addedproductList.forEach(product->{
			 productList.add(product);
		 });
		return productList;
	}
	
	public List<Product> deleteProductByID(int id){
		 return productList.stream().filter(product->product.getProductId()!=id).collect(Collectors.toList());
	}
	
	public Product getProductById(int id) {
		 Optional<Product> optionalProduct=productList.stream().filter(product->product.getProductId()==id).findFirst();
		 if(optionalProduct.isPresent()) {
			return  optionalProduct.get();
		 }
		 else {
			 return null;
		 }
	}
	
	public List<Product> updateProduct(int id,Product updateProduct){
		List<Product> finalList=productList.stream().filter(product->product.getProductId()!=id).collect(Collectors.toList());
		finalList.add(updateProduct);
		return finalList;
	}
	
	  

}
