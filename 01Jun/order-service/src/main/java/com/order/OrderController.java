package com.order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

	@Autowired
	OrderService service;
		
	@PostMapping("order")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createOrder(@Valid @RequestBody OrderVO order) {
		
		service.saveOrder(order);
		System.out.println(order.getItem() + " -> " + order.getPrice() + " -> " + order.getQuantity());
	}
	
	@GetMapping("orders")
	public List<OrderVO> getOrders() {
		return service.getOrders();
		
	}
	
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
