package com.niit.jdp.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

class DatabaseServiceTest {
	DatabaseService databaseService;

	@BeforeEach
	void setUp() {
		databaseService = new DatabaseService();
	}

	@AfterEach
	void tearDown() {
		databaseService = null;
	}

	@Test
	void checkDatabaseConnectionSuccess() throws SQLException {
		Assertions.assertTrue(databaseService.connect());
	}
}