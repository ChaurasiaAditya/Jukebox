package com.niit.jdp.repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface Repository <T> {

    // Create - T
    boolean add(Connection connection, T object) throws SQLException;
    // Read - T
    List<T> getAll(Connection connection) throws SQLException;

    List<T> getByArtist(Connection connection, String artist) throws SQLException;

    List<T> getByGenre(Connection connection, String genre) throws SQLException;

    T getByName(Connection connection, String name) throws SQLException;

    // Update T
    boolean updateById(Connection connection, int id, String name) throws SQLException;

    // Delete T
    boolean deleteById(Connection connection, int id) throws SQLException;
}