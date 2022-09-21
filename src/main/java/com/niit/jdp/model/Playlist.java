/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Playlist {
    private String playlistName;
    private Song song;

    public Playlist() {
    }

    public Playlist(String playlistName, Song song) {
        this.playlistName = playlistName;
        this.song = song;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(playlistName, playlist.playlistName) && Objects.equals(song, playlist.song);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistName, song);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistName='" + playlistName + '\'' +
                ", song=" + song +
                '}';
    }
}
