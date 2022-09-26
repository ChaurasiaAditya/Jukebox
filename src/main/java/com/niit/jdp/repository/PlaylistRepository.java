/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.repository;

import com.niit.jdp.exception.InvalidPlaylistIdException;
import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
	public boolean createNewPlaylist(Connection connection, String playlistName, String songNumbers) throws SQLException {
		// convert string to array
		String[] strings = songNumbers.split(" ");

		// Create a StringJoiner with comma(,) as delimiter
		StringJoiner stringJoiner = new StringJoiner(",");

		// Add the elements to StringJoiner
		Arrays.stream(strings).map(String::valueOf).forEachOrdered(stringJoiner::add);

		// Create a string with the query
		String query = "INSERT INTO `jukebox`.`playlists` (`name`, `songs_list`) VALUES (?, ?);";

		// create a prepared statement object
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// set the values to the query
			preparedStatement.setString(1, playlistName);
			preparedStatement.setString(2, stringJoiner.toString().trim());

			// execute the query
			return preparedStatement.executeUpdate() > 0;
		}
	}


	/**
	 * It takes a playlist id and returns a list of songs in that playlist
	 *
	 * @param connection The connection to the database.
	 * @param playlistId The id of the playlist you want to get the songs from.
	 * @return A list of songs
	 */
	public List<Song> getAllSongsInPlaylist(Connection connection, SongRepository songRepository, int playlistId) throws SQLException, InvalidPlaylistIdException {
		if (playlistId < 0) {
			throw new InvalidPlaylistIdException("Id Cannot be Negative");
		} else {
			// Create a list of songs
			List<Song> songList = new ArrayList<>();

			// convert the string to array seperated by (,)
			String[] idInString = getIdsFromPlaylist(connection, playlistId).split(",");

			// iterate over array to convert string array to integer array
			int[] idInInteger = Arrays.stream(idInString).mapToInt(Integer::parseInt).toArray();

			// iterate over integer array and store the variable in list
			for (int ids : idInInteger) {
				Song song = songRepository.geyById(connection, ids);
				songList.add(song);
			}
			// return the list of songs
			return songList;
		}
	}


	/**
	 * > This function gets all the playlists from the database and returns them as a list of strings
	 *
	 * @param connection The connection to the database
	 * @return A list of playlists
	 */
	public List<String> getAllPlaylistNames(Connection connection) throws SQLException {
		// Create a list of playlists
		List<String> playlistNameList = new ArrayList<>();

		// write the query to get all the playlists from the database
		String query = "SELECT `id`,`name` FROM `jukebox`.`playlists`;";

		// create a prepared statement object
		ResultSet resultSet;
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// execute the query
			resultSet = preparedStatement.executeQuery();

			// iterate over the result set and add the playlists to the list
			while (resultSet.next()) {
				playlistNameList.add(resultSet.getInt("id") + "\t" + resultSet.getString("name"));
			}
		}
		// return the list of playlists
		return playlistNameList;
	}

	/**
	 * It takes a connection object and a playlist name and deletes the playlist from the database
	 *
	 * @param connection The connection object to the database.
	 * @param playlistId The id of the playlist
	 * @return A boolean value.
	 */
	public boolean deletePlaylist(Connection connection, int playlistId) throws SQLException, InvalidPlaylistIdException {
		if (playlistId < 0) {
			throw new InvalidPlaylistIdException("Id Cannot be Negative");
		} else {
			// write the query to delete the playlist
			String query = "DELETE FROM `jukebox`.`playlists` WHERE (`id` = ?);";

			// create a prepared statement object
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				// set the values to the query
				preparedStatement.setInt(1, playlistId);
				// execute the query
				return preparedStatement.executeUpdate() > 0;
			}
		}
	}

	/**
	 * This function takes a playlist id as an argument and returns a string of song ids
	 *
	 * @param connection The connection object that is used to connect to the database.
	 * @param playListId The id of the playlist whose songs you want to get.
	 * @return A string of song ids
	 */
	public String getIdsFromPlaylist(Connection connection, int playListId) throws SQLException {
		String songsIds = null;
		// write the query to delete the playlist
		String query = "SELECT `songs_list` FROM `jukebox`.`playlists` WHERE (`id` = ?);";

		// create a object for prepared Statement
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// set the values for prepared statement
			preparedStatement.setInt(1, playListId);
			// execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// iterate over the result set and add playlist id to string
			while (resultSet.next()) {
				songsIds = resultSet.getString("songs_list");
			}
		}
		// return the list of ids as string
		return songsIds;
	}
}