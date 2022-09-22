package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongRepositoryTest {
	DatabaseService databaseService;
	Connection connection;
	SongRepository songRepository;
	Song song;

	@BeforeEach
	void setUp() throws SQLException {
		databaseService = new DatabaseService();
		databaseService.connect();
		connection = databaseService.getConnection();
		songRepository = new SongRepository();
		song = new Song(1,"Alone Alan","Alan Walker","EDM","02:43");
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void getAll() {
	}

	@Test
	void getByArtist() {
	}

	@Test
	void getByGenre() {
	}

	@Test
	void givenIdCheckSongObjectSuccess() throws SQLException {
		Assertions.assertEquals(song,songRepository.geyById(connection, 1));
	}

	@Test
	void givenIdCheckSongObjectFailure() throws SQLException {
		Assertions.assertNotEquals(song,songRepository.geyById(connection, 2));
	}

	@Test
	void getByName() {

	}

	@Test
	void getUrlById() {
	}
}