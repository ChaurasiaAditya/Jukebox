/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.repository;

import com.niit.jdp.model.Song;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongRepository implements Repository<Song> {

    @Override
    // This method is used to add the song to the database.
    public boolean add(Connection connection, Song song) throws SQLException {

        // write the query to insert the song into the song table
        String query = "INSERT INTO `jukebox`.`songs` (`id`, `name`, `artist`, `duration`, `genre`, `url`) VALUES (?, ?, ?, ?, ?, ?);";

        // create a prepared statement object
        int numberOfRowsAffected;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            // set the values to the query
            preparedStatement.setInt(1,song.getId());
            preparedStatement.setString(2,song.getName());
            preparedStatement.setString(3,song.getArtist());
            preparedStatement.setString(4,song.getDuration());
            preparedStatement.setString(5,song.getGenre());
            preparedStatement.setString(6,song.getSongUrl());

            // execute the query
            numberOfRowsAffected = preparedStatement.executeUpdate();
        }
        // return true if the number of rows affected is more than 0
        return numberOfRowsAffected > 0;
    }

    @Override
    // This method is used to get all the songs from the database.
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

    @Override
    // This method is used to get all the songs from the database by artist.
    public List<Song> getByArtist(Connection connection, String artist) throws SQLException {
        // Create a list of songs
        List<Song> songList = new ArrayList<>();

        // write the query to get all the songs from the database by artist
        String query = "SELECT * FROM `jukebox`.`songs` WHERE (`artist` = ?);";

        // create a statement object using the connection object
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // set the value in prepared statement
            preparedStatement.setString(1, artist);

            // execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // iterate over the result set and add the songs to the list
            while (resultSet.next()) {
                // fetch the data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String artists = resultSet.getString("artist");
                String genre = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                Song song = new Song(id, name, artists, genre, duration);

                // add the song to the list
                songList.add(song);
            }
            // return the list
            return songList;
        }
    }

    @Override
    // This method is used to get all the songs from the database by genre.
    public List<Song> getByGenre(Connection connection, String genre) throws SQLException {
        // Create a list of songs
        List<Song> songList = new ArrayList<>();

        // write the query to get all the songs from the database by genre
        String query = "SELECT * FROM `jukebox`.`songs` WHERE (`genre` = ?);";

        // create a statement object using the connection object
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // set the value in prepared statement
            preparedStatement.setString(1, genre);

            // execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // iterate over the result set and add the songs to the list
            while (resultSet.next()) {
                // fetch the data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String artists = resultSet.getString("artist");
                String genres = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                Song song = new Song(id, name, artists, genres, duration);

                // add the song to the list
                songList.add(song);
            }
            // return the list
            return songList;
        }
    }

    @Override
    // This method is used to get all the songs from the database by song name.
    public Song getByName(Connection connection, String name) throws SQLException {
        // Create an object of songs
        Song song = new Song();

        // write the query to get all the songs from the database by song name
        String query = "SELECT * FROM `jukebox`.`songs` WHERE (`name` = ?);";

        // create a statement object using the connection object
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // set the value in prepared statement
            preparedStatement.setString(1, name);

            // execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // iterate over the result set and add the songs to the list
            while (resultSet.next()) {
                // fetch the data from the result set
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                String artists = resultSet.getString("artist");
                String genres = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                song.setId(id);
                song.setName(name1);
                song.setArtist(artists);
                song.setGenre(genres);
                song.setDuration(duration);

            }
            // return the list
            return song;
        }
    }

    @Override
    // This method is used to update the song name by id.
    public boolean updateById(Connection connection, int id, String name) throws SQLException {

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

    @Override
    // This method is used to delete the song by id.
    public boolean deleteById(Connection connection, int id) throws SQLException {
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