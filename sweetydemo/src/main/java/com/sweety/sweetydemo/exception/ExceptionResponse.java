package com.sweety.sweetydemo.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class ExceptionResponse {

	private String message;
	
	private String description;
	
	private Date date;

	public ExceptionResponse(String message, String description, Date date) {
		super();
		this.message = message;
		this.description = description;
		this.date = date;
	}
	
	
	
	
}
