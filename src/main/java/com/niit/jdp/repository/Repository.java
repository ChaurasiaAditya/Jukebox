package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository <T> {
    List<T> getAllSongs(Connection connection) throws SQLException;

    List<T> getByArtist(Connection connection, String artist) throws SQLException;

    List<T> getByGenre(Connection connection, String genre) throws SQLException;

    List<T> getBySongName(Connection connection, String songName);


}
