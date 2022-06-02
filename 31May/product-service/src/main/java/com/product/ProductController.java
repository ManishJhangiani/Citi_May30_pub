package com.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("create")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createProduct(@Valid @RequestBody ProductVO product) {
		
		productService.saveProduct(product);
		
	}
	
	@GetMapping("allproducts")
	List<ProductVO> getAllProducts() {
		return productService.allProducts();
	}
	
//	@GetMapping(path = "/product/path-variable/{id}")
//	Optional<ProductVO> getProduct(@PathVariable int id) {
//		return productService.singleProduct(id);
//	}
//	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(MethodArgumentNotValidException exp){
		
		Map<String, String> errorMessages = new HashMap<>();
		exp.getAllErrors().forEach(error -> {
				String fieldname = ((FieldError)error).getField();
				String message = ((FieldError)error).getDefaultMessage();
				errorMessages.put(fieldname, message);
			}
		);
		return errorMessages;
				
	}
}
