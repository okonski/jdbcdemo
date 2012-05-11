package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CompanyManagerTest {

	CompanyManager companyManager = new CompanyManager();
	
	@Test
	public void checkConnection(){
		assertNotNull(companyManager.getConnection());
	}
}
