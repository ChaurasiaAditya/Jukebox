/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PlaylistRepository {
	/**
	 * It takes a connection object, a playlist name and a string of song numbers and adds them to the playlist
	 *
	 * @param connection   The connection object to the database.
	 * @param playlistName The name of the playlist
	 * @param songNumbers  This is the string of song numbers that the user wants to add to the playlist.
	 * @return A boolean value.
	 */
	public boolean addSongsInPlaylist(Connection connection, String playlistName, String songNumbers) throws SQLException {

		// convert string to array
		char[] songNumbersArray = songNumbers.toCharArray();

		// Create a StringJoiner with comma(,) as delimiter
		StringJoiner stringJoiner = new StringJoiner(",");

		// Add the elements to StringJoiner
		for (char songNumber : songNumbersArray) {
			stringJoiner.add(String.valueOf(songNumber));
		}

		// Create a string with the query
		String query = "INSERT INTO `jukebox`.`playlists` (`name`, `songs_list`) VALUES (?, ?);";

		// create a prepared statement object
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		// set the values to the query
		preparedStatement.setString(1, playlistName);
		preparedStatement.setString(2, stringJoiner.toString().trim());

		// execute the query
		return preparedStatement.executeUpdate() > 0;
	}
}