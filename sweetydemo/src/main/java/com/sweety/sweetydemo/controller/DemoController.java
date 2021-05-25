package com.sweety.sweetydemo.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.sweety.sweetydemo.bo.PostModel;
import com.sweety.sweetydemo.exception.ExceptionResponse;

@RestController
@RequestMapping("/demo_request")
public class DemoController extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req)
	{
		ExceptionResponse exceptionRes=new ExceptionResponse("Kalesha you have this error: "+ex.getMessage(),req.getDescription(false), new Date());
		return new ResponseEntity<Object>(exceptionRes, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	@GetMapping("/first_demo/{id}")
	public ResponseEntity<?> demoException(@PathVariable("id") Long id) 
	{
	    Long abc=0L;
	    if(id<10)
	    {
	    	abc=id/0;
	    }
		return new ResponseEntity<Long>(abc,HttpStatus.OK);
	}
	
	@GetMapping("/first_demo1/{id}")
	public ResponseEntity<?> demoExceptionNumber(@PathVariable("id") String id) 
	{
		int a = Integer.parseInt(id); 
		
		 return new ResponseEntity<Object>(a,HttpStatus.OK);
	}
	
	@GetMapping("/first_demo/{name}/{id}")
	public ResponseEntity<?> demo(@PathVariable("name") String name,@PathVariable("id") int id) 
	{
		PostModel model=new PostModel(name,id);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name");
		FilterProvider filters=new SimpleFilterProvider().addFilter("dynamicFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(model);
		mapping.setFilters(filters);
		return new ResponseEntity<Object>(mapping, HttpStatus.OK);
	}
	
	@GetMapping("/first_demo1/{name}/{id}")
	public ResponseEntity<?> demo1(@PathVariable("name") String name,@PathVariable("id") int id) 
	{
		PostModel model=new PostModel(name,id);
		SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("pass");
		FilterProvider filters=new SimpleFilterProvider().addFilter("dynamicFilter", filter);
		MappingJacksonValue mapping=new MappingJacksonValue(model);
		mapping.setFilters(filters);
		return new ResponseEntity<Object>(mapping, HttpStatus.OK);
	}
	
	@GetMapping("/first_demo2/{name}/{id}")
	public ResponseEntity<?> demo(@PathVariable("name") String name,@PathVariable("id") byte id) 
	{
		return new ResponseEntity<String>("Hello "+name+"-"+id,HttpStatus.OK);
	}
	
	@PostMapping("/post_demo")
	public ResponseEntity<?> demo_post(@RequestParam("name") String name, @RequestParam("password") String password)
	{
		String name1="kali"; String pwd2="123"; StringBuffer output=new StringBuffer();
		if(name.equals(name1) || name.equalsIgnoreCase(name1) && password.equals(pwd2))
		{
			output.append("Login Success");
			return new ResponseEntity<Object>(output,HttpStatus.OK);
		}
		else
		{
			output.append("Login fail");
			return new ResponseEntity<Object>(output,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/post_demo_model")
	public ResponseEntity<?> demo_post_model(@RequestBody PostModel demo)
	{
		String name=demo.getName();
		return new ResponseEntity<Object>(name,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/jsp")
	public String jsp()
	{
		return "demo";
	}
	
	
}
