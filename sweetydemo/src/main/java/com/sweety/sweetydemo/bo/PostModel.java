package com.sweety.sweetydemo.bo;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@Data
@JsonFilter("dynamicFilter")
public class PostModel {
	
	private String name;
	
	private int pass;

	public PostModel(String name, int pass) {
		super();
		this.name = name;
		this.pass = pass;
	}
	
	
	
}
