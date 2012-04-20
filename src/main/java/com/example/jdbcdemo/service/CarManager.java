package com.example.jdbcdemo.service;

import java.sql.*;

import com.example.jdbcdemo.domain.Car;

public class CarManager {

	private Connection connection;
	private Statement statement;
	
	private String url = "jdbc:hsqldb:hsql://localhost/workdb";
	private String createTablePerson = "CREATE TABLE Car(id bigint GENERATED BY DEFAULT AS IDENTITY, model varchar(20),make varchar(20), yop integer)";
	
	private PreparedStatement addCarStmt;
	private PreparedStatement deleteAllCarsStmt;
	private PreparedStatement getAllCarsStmt;
	public CarManager(){
		try{
			
			connection = DriverManager.getConnection(url);
			statement = connection.createStatement();
			
			ResultSet rs = connection.getMetaData().getTables(null, null, null,
					null);
			boolean tableExists = false;
			while (rs.next()) {
				if ("Car".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
					tableExists = true;
					break;
				}
			}

			if (!tableExists)
				statement.executeUpdate(createTablePerson);	
			
			addCarStmt = connection
					.prepareStatement("INSERT INTO Car (model, make, yop) VALUES (?, ?, ?)");
			deleteAllCarsStmt = connection
					.prepareStatement("DELETE FROM Car");
			getAllCarsStmt = connection
					.prepareStatement("SELECT id, model, make, yop FROM Car");
			
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	// Package scope
	Connection getConnection(){
		return connection;
	}
	public int addCar(Car car){
		int count = 0;
		try {
			addCarStmt.setString(1, car.getModel());
			addCarStmt.setString(2, car.getMake());
			addCarStmt.setInt(3, car.getYop());

			count = addCarStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;		
	}
}