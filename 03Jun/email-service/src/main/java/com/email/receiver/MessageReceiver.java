package com.email.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.order.OrderVO;

@Component
public class MessageReceiver {
	private static final String MESSAGE_QUEUE = "message_queue_order";

	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(OrderVO order) {
		System.out.println("Received " + order);
//		throwexception(product);
	}

	private void throwexception(OrderVO order) {
		if (order.getQuantity() % 2 == 0) {
			throw new RuntimeException();
		}
	}
}
