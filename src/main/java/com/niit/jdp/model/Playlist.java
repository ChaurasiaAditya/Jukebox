/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private int id;
    private String playlistName;
    private List<Song> songList;


    public Playlist() {
    }

    public Playlist(int id, String playlistName, List<Song> songList) {
        this.id = id;
        this.playlistName = playlistName;
        this.songList = songList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return getId() == playlist.getId() && Objects.equals(getPlaylistName(), playlist.getPlaylistName()) && Objects.equals(getSongList(), playlist.getSongList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPlaylistName(), getSongList());
    }

    @Override
    public String toString() {
        return "Playlist{" +
            "id=" + getId() +
            ", playlistName='" + getPlaylistName() + '\'' +
            ", songList=" + getSongList() +
            '}';
    }
}
