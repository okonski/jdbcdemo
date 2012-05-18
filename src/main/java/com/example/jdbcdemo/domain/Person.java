package com.example.jdbcdemo.domain;

public class Person {
	
	private long id;
	
	private String name;
	private int yob;
	private long company_id;
	
	public Person() {
	}
	
	public Person(String name, int yob) {
		super();
		this.name = name;
		this.yob = yob;
	}
	public Person(String name, int yob, long company_id) {
		super();
		this.name = name;
		this.yob = yob;
		this.company_id = company_id;
	}
	public long getId() {
		return id;
	}
	public long getCompanyId(){
		return company_id;
	}
	public void setCompanyId(long company_id){
		this.company_id = company_id;  
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYob() {
		return yob;
	}
	public void setYob(int yob) {
		this.yob = yob;
	}
	
}
