package com.example.jdbcdemo.service;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.jdbcdemo.domain.Company;
import com.example.jdbcdemo.domain.Person;

public class CompanyManagerTest {

	CompanyManager companyManager = new CompanyManager();
	PersonManager personManager = new PersonManager();
	
	private final static String NAME = "Johnson & Johnson";
	private final static String NAME_2 = "Orange";
	@Test
	public void checkConnection(){
		assertNotNull(companyManager.getConnection());
	}
	
	@Test
	public void checkAdding(){
		
		Company company = new Company(NAME);
		
		companyManager.clearCompanies();
		assertEquals(1,companyManager.addCompany(company));
		
		List<Company> companies = companyManager.getAllCompanies();
		Company companyRetrieved = companies.get(0);
		
		assertEquals(NAME, companyRetrieved.getName());
		
	}
	
	@Test
	public void checkUpdates(){
		Company company = new Company(NAME);
		
		companyManager.clearCompanies();
		assertEquals(1,companyManager.addCompany(company));
		

		Company companyRetrieved = companyManager.getCompanyByName(NAME);		
		assertEquals(NAME, companyRetrieved.getName());	
		
		companyRetrieved.setName(NAME_2);		
		companyManager.updateCompany(companyRetrieved);
		
		companyRetrieved = companyManager.getCompanyByName(NAME_2);		
		assertNotNull(companyRetrieved);

	}
	@Test
	public void checkAddMultipleWorkers() throws SQLException{
		companyManager.clearCompanies();
		personManager.clearPersons();
		
		Company company = new Company(NAME);		
		assertEquals(1,companyManager.addCompany(company));		
	
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Mariusz", 1921));
		persons.add(new Person("Zenek", 1953));
		persons.add(new Person("Darek", 1973));

		
		companyManager.addWorkers(1, persons);
		List<Person> personsReceived = companyManager.getCompanyWorkers(1);
		
		assertEquals(persons.size(), personsReceived.size());		
	}
	@Test
	public void checkWorkersRelation(){
		
		companyManager.clearCompanies();
		personManager.clearPersons();
		
		Company company = new Company(NAME);		
		Person person = new Person("Marjan", 1965, 1);
		
		assertEquals(1,companyManager.addCompany(company));		
		assertEquals(1,personManager.addPerson(person));
		
		List<Person> persons = companyManager.getCompanyWorkers(1);
		
		assertEquals(1, persons.size());
		
	}	
}
