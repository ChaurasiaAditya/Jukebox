/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.repository;

import com.niit.jdp.exeception.SongIdNotFoundException;
import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SongRepository implements Repository<Song> {

	/**
	 * This method is used to add the song to the database.
	 *
	 * @param connection connection object
	 * @param song       song object
	 * @return true if the song is added
	 * @throws SQLException sql exception
	 */
	@Override
	public boolean add(Connection connection, Song song) throws SQLException {
		// write the query to insert the song into the song table
		String query = "INSERT INTO `jukebox`.`songs` (`id`, `name`, `artist`, `duration`, `genre`, `url`) VALUES (?, ?, ?, ?, ?, ?);";

		// create a prepared statement object
		int numberOfRowsAffected;
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			// set the values to the query
			preparedStatement.setInt(1, song.getId());
			preparedStatement.setString(2, song.getName());
			preparedStatement.setString(3, song.getArtist());
			preparedStatement.setString(4, song.getDuration());
			preparedStatement.setString(5, song.getGenre());
			preparedStatement.setString(6, song.getSongUrl());

			// execute the query
			numberOfRowsAffected = preparedStatement.executeUpdate();
		}
		// return true if the number of rows affected is more than 0
		return numberOfRowsAffected > 0;
	}


	/**
	 * This method is used to get all the songs from the database.
	 *
	 * @param connection connection object
	 * @return list of songs
	 * @throws SQLException sql exception
	 */
	@Override
	public List<Song> getAll(Connection connection) throws SQLException {
		// Create a list of songs
		List<Song> songList = new ArrayList<>();

		// write the query to get all the songs from the database
		String query = "SELECT * FROM `jukebox`.`songs`;";

		// create a statement object
		try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			// execute the query
			ResultSet resultSet = preparedStatement.executeQuery();

			// iterate over the result set and add the songs to the list
			while (resultSet.next()) {
				// fetch the data from the result set
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String artist = resultSet.getString("artist");
				String genre = resultSet.getString("genre");
				String duration = resultSet.getString("duration");

				// create a song object
				Song song = new Song(id, name, artist, genre, duration);

				// add the song to the list
				songList.add(song);
			}
			// return the list
			return songList;
		}
	}

	/**
	 * This method is used to get the song from the database by id.
	 *
	 * @param connection the connection
	 * @param artist     name of the artist
	 * @return the song
	 * @throws SQLException the sql exception
	 */
	@Override
	public List<Song> getByArtist(Connection connection, String artist) throws SQLException {
		// Create a list of songs
		List<Song> songList = getAll(connection);
		return songList.stream().filter(song -> song.getArtist().equalsIgnoreCase(artist)).collect(Collectors.toList());
	}

	/**
	 * This method is used to get all the songs from the database by genre.
	 *
	 * @param connection the connection object
	 * @param genre      the genre of the song
	 * @return List of songs
	 * @throws SQLException sql exception
	 */
	@Override
	public List<Song> getByGenre(Connection connection, String genre) throws SQLException {
		List<Song> all = getAll(connection);
		return all.stream().filter(songs -> songs.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
	}

	/**
	 * This method is used to get all the songs from the database by duration.
	 *
	 * @param connection connection object
	 * @param id         id of the song
	 * @return Song Object
	 * @throws SQLException sql exception
	 */
	public Song geyById(Connection connection, int id) throws SQLException {

		// call the getAll method to get all the songs from the database
		List<Song> songList = getAll(connection);

		return songList.stream().filter(song -> song.getId() == id).findFirst().orElse(new Song());
	}

	/**
	 * This method is used to get all the songs from the database by duration.
	 *
	 * @param connection connection object
	 * @param name       name of the song to search
	 * @return List of songs
	 * @throws SQLException sql exception
	 */
	@Override
	public List<Song> getByName(Connection connection, String name) throws SQLException {

		// Create a list of songs
		List<Song> songList = getAll(connection);
		return songList.stream().filter(song -> song.getName().equals(name)).collect(Collectors.toList());
	}

	/**
	 * This method is used to get all the songs from the database by duration.
	 *
	 * @param connection connection object
	 * @param id         id of the song
	 * @param name       updated name of the song
	 * @return List of songs
	 * @throws SQLException sql exception
	 */
	@Override
	public boolean updateById(Connection connection, int id, String name) throws SQLException, SongIdNotFoundException {
		if (id < 0) {
			throw new SongIdNotFoundException("Id Cannot be Negative");
		} else {

			// write the query to update the song by id
			String query = "UPDATE `jukebox`.`songs` SET `name` = ? WHERE (`id` = ?);";

			int numberOfRowsAffected;
			// create a statement object using the connection object
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				// set the value in prepared statement
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);

				// execute the query
				numberOfRowsAffected = preparedStatement.executeUpdate();
			}
			// return true if the number of rows affected is greater than 0
			return numberOfRowsAffected > 0;
		}
	}

	/**
	 * This method is used to delete the song from the database by id.
	 *
	 * @param connection connection object
	 * @param id         id of the song
	 * @return true if the song is deleted
	 * @throws SQLException sql exception
	 */
	@Override
	public boolean deleteById(Connection connection, int id) throws SQLException, SongIdNotFoundException {
		if (id < 0) {
			throw new SongIdNotFoundException("Id Cannot be Negative");
		} else {
			// write the query to delete the song by id
			String query = "DELETE FROM `jukebox`.`songs` WHERE (`id` = ?);";

			int numberOfRowsAffected;
			// create a statement object using the connection object
			try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				// set the value in prepared statement
				preparedStatement.setInt(1, id);

				// execute the query
				numberOfRowsAffected = preparedStatement.executeUpdate();
			}
			// return true if the number of rows affected is greater than 0
			return numberOfRowsAffected > 0;
		}
	}

	/**
	 * This function takes a connection object and an id as input and returns the url of the song with the given id
	 *
	 * @param connection The connection object that is used to connect to the database.
	 * @param id         The id of the song
	 * @return The url of the song with the given id.
	 */
	public String getUrlById(Connection connection, int id) throws SQLException, SongIdNotFoundException {

		if (id < 0) {
			throw new SongIdNotFoundException("Id Cannot be Negative");
		} else {
			List<Song> songList = getAll(connection);
			Song song1 = songList.stream().filter(song -> song.getId() == id).findFirst().orElse(new Song());
			return song1.getSongUrl();
		}
	}
}