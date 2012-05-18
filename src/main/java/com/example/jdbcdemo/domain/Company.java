package com.example.jdbcdemo.domain;

public class Company {
	
	private Long id;
	
	private String name;

	public Company(){
		
	}
	public Company(String name) {
		super();
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
