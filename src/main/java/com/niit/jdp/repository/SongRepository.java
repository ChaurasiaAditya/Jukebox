/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
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

    // This method is used to get all the songs from the database.
    public List<Song> getAllSongs(Connection connection) throws SQLException {
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
                int songNumber = resultSet.getInt("song_number");
                String songName = resultSet.getString("song_name");
                String artist = resultSet.getString("artist");
                String genre = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                Song song = new Song(songNumber, songName, artist, genre, duration);

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
                int songNumber = resultSet.getInt("song_number");
                String songName = resultSet.getString("song_name");
                String artists = resultSet.getString("artist");
                String genre = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                Song song = new Song(songNumber, songName, artists, genre, duration);

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
                int songNumber = resultSet.getInt("song_number");
                String songName = resultSet.getString("song_name");
                String artists = resultSet.getString("artist");
                String genres = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                Song song = new Song(songNumber, songName, artists, genres, duration);

                // add the song to the list
                songList.add(song);
            }
            // return the list
            return songList;
        }
    }

    @Override
    // This method is used to get all the songs from the database by song name.
    public List<Song> getBySongName(Connection connection, String songName) throws SQLException {
        // Create a list of songs
        List<Song> songList = new ArrayList<>();

        // write the query to get all the songs from the database by song name
        String query = "SELECT * FROM `jukebox`.`songs` WHERE (`song_name` = ?);";

        // create a statement object using the connection object
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // set the value in prepared statement
            preparedStatement.setString(1, songName);

            // execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // iterate over the result set and add the songs to the list
            while (resultSet.next()) {
                int songNumber = resultSet.getInt("song_number");
                String songNames = resultSet.getString("song_name");
                String artists = resultSet.getString("artist");
                String genres = resultSet.getString("genre");
                String duration = resultSet.getString("duration");

                // create a song object
                Song song = new Song(songNumber, songNames, artists, genres, duration);

                // add the song to the list
                songList.add(song);
            }
            // return the list
            return songList;
        }
    }
}