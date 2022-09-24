package com.niit.jdp.repository;

import com.niit.jdp.exeception.SongIdNotFoundException;
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


class SongRepositoryTest {
	DatabaseService databaseService;
	Connection connection;
	SongRepository songRepository;
	Song song;
	Song song1;

	@BeforeEach
	void setUp() throws SQLException {
		databaseService = new DatabaseService();
		databaseService.connect();
		connection = databaseService.getConnection();
		songRepository = new SongRepository();
		song = new Song(1, "Alone Alan", "Alan Walker", "EDM", "02:43","src/main/resources/songs/Alone.wav");
		song1 = new Song();
		song1.setSongUrl("src/main/resources/songs/Alone.wav");
		song1.setId(2);
		song1.setName("Faded Alan");
		song1.setArtist("Alan Walker");
		song1.setDuration("04:43");
		song1.setGenre("EDM");
	}

	@AfterEach
	void tearDown() {
		databaseService = null;
		songRepository = null;
	}

	@Test
	void givenArtistNameReturnSongsWithThatArtist() throws SQLException {
		List<Song> expected = songRepository.getByArtist(connection, "Alan Walker");
		Assertions.assertEquals(songRepository.getByArtist(connection, "Alan Walker"), expected);
	}

	@Test
	void givenIdCheckSongObjectSuccess() throws SQLException {
		Assertions.assertEquals(song, songRepository.geyById(connection, 1));
	}

	@Test
	void givenIdCheckSongObjectFailure() throws SQLException {
		Assertions.assertNotEquals(song, songRepository.geyById(connection, song1.getId()));
	}

	@Test
	void givenNameCheckSongObjectSuccess() throws SQLException {
		List<Song> songList = new ArrayList<>();
		songList.add(song);
		Assertions.assertEquals(songList, songRepository.getByName(connection, song.getName()));
	}

	@Test
	void givenNameCheckSongObjectFailure() throws SQLException {
		List<Song> songList = new ArrayList<>();
		songList.add(song);
		Assertions.assertNotEquals(songList, songRepository.getByName(connection, "Diana King"));
	}

	@Test
	void givenIdCheckUrlOfSongSuccess() throws SQLException, SongIdNotFoundException {
		String url = song1.getSongUrl();
		String urlById = songRepository.getUrlById(connection, 1);
		Assertions.assertEquals(url, urlById);
	}

	@Test
	void givenIdCheckUrlOfSongFailure() throws SQLException, SongIdNotFoundException {
		String url = song1.getSongUrl();
		String urlById = songRepository.getUrlById(connection, 2);
		Assertions.assertNotEquals(url, urlById);
	}
}