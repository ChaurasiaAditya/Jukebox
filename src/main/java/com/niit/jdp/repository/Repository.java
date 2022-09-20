package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository <T> {
    List<T> getAll(Connection connection) throws SQLException;

    List<T> getByArtist(Connection connection, String artist);

    List<T> getByGenre(Connection connection, String genre);

    List<T> getBySongName(Connection connection, String songName);


}
