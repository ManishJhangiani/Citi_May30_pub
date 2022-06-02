package com.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

//@Entity
public class UserVO {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	Integer id;
//	@NotBlank (message = "User Name cannot be blank")
	String name;
//	@Min(value = 18, message = "Age cannot be less than 18")
//	@Max(value = 99, message = "Age cannot be more than 99")
	Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
//	public Integer getId() {
//		return id;
//	}

}
