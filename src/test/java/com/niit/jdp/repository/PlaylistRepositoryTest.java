package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
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

class PlaylistRepositoryTest {
	DatabaseService databaseService;
	Connection connection;
	PlaylistRepository playlistRepository;
	Song song;
	Playlist playlist;
	Playlist playlist1;

	@BeforeEach
	void setUp() throws SQLException {
		databaseService = new DatabaseService();
		databaseService.connect();
		connection = databaseService.getConnection();
		playlistRepository = new PlaylistRepository();
		playlist = new Playlist();
		List<Song> songList = new ArrayList<>();
		playlist1 = new Playlist(1, "MyFavourite", songList);
		songList.add(song);
		playlist.setSongList(songList);
		playlist.setId(1);
		playlist.setPlaylistName("MyFavourite");
	}

	@AfterEach
	void tearDown() {
		databaseService = null;
		playlistRepository = null;
		playlist = null;
	}

	@Test
	void givenConnectionAndPlaylistIdReceiveIdsOfPlaylistSuccess() throws SQLException {
		Assertions.assertEquals("1,2,3,4", playlistRepository.getIdsFromPlaylist(connection, 1), "Id not present in Database");
	}

	@Test
	void givenConnectionAndPlaylistIdReceiveIdsOfPlaylistFailure() throws SQLException {
		Assertions.assertNotEquals("1,2,3", playlistRepository.getIdsFromPlaylist(connection, 1), "Id not present in Database");
	}
}