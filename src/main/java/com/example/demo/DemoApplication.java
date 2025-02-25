package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		testDatabaseConnection();
	}

	private void testDatabaseConnection() {
		try (Connection connection = dataSource.getConnection()) {
			System.out.println("Database connection successful: " + connection.getCatalog());
		} catch (SQLException e) {
			System.err.println("Database connection failed: " + e.getMessage());
		}
	}
}
