/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.model;

public class Playlist {
    private String playlistName;
    private Song song;

    public Playlist() {
    }

    public Playlist(String playlistName, Song song) {
        this.playlistName = playlistName;
        this.song = song;
    }
}
