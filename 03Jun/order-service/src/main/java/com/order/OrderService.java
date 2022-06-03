package com.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.user.UserVO;

@Service
public class OrderService {

	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	private static final String MESSAGE_QUEUE = "message_queue_order";
	
	void saveOrder(OrderVO order) {
		 orderRepository.save(order);
//		 UserVO userVO = new UserVO();
//		 userVO.setName("OrderTest");
//		 userVO.setAge(45);
//		 restTemplate.postForEntity("http://localhost:8083/addUser", userVO, Void.class);
		 
		 //restTemplate.getForEntity("http://EMAIL-SERVICE/getEmail", String.class);
		 
		 //restTemplate.postForEntity("http://EMAIL-SERVICE/postEmail", "Order",String.class);
		 
		 System.out.println("order details: " + order);
		 jmsTemplate.convertAndSend(MESSAGE_QUEUE, order);
	}
	
	List<OrderVO> getOrders(){
		return orderRepository.findAll();
	}
}
