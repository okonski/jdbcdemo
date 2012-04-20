package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarManagerTest {

	CarManager carManager = new CarManager();
	
	@Test
	public void checkConnection(){
		assertNotNull(carManager.getConnection());
	}
}
