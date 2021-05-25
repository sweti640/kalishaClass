package com.sweety.sweetydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@Controller
public class SweetydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetydemoApplication.class, args);
	}
	
	@RequestMapping(value = "/jsp1", method = RequestMethod.GET)
	public String demo()
	{
		System.out.println("222222222222");
		return "demo";
	}

}
