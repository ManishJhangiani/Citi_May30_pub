package com.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	void saveProduct(ProductVO product) {
		
		productRepository.save(product);
		restTemplate.postForEntity("http://EMAIL-SERVICE/postEmail", "Product created",String.class);
	}
	
	List<ProductVO> allProducts(){
		restTemplate.postForEntity("http://EMAIL-SERVICE/postEmail", "All Product retrieved",String.class);
		return productRepository.findAll();
	}
	
	Optional<ProductVO> singleProduct(Integer id) {
		restTemplate.getForEntity("http://EMAIL-SERVICE/getEmail", String.class);
		return productRepository.findById(id);
	}
	
//	Optional<ProductVO> likeProduct(Integer id){
//		Example<Integer> i = id; 
//		return productRepository.findAll(example)
//	}
}
