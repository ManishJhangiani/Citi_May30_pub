package com.email;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	@GetMapping("getEmail")
	String sendMail() {
		System.out.println("GET --> email sent");
		return "send successfully";
	}
	
	@PostMapping("postEmail")
	String sendMailUsingPost(String email) {
		System.out.println("POST --> email sent --> " + email);
		return "send successfully:  "+ email;
	}

}
