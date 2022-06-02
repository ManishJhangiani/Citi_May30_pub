package com.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	void saveOrder(OrderVO order) {
		 orderRepository.save(order);
	}
	
	List<OrderVO> getOrders(){
		return orderRepository.findAll();
	}
}
