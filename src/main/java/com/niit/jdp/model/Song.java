/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.model;

public class Song {
    private int songNumber;
    private String songName;
    private String songUrl;
    private double duration;
    private String artist;
    private String genre;

    public Song() {
    }

    public Song(int songNumber, String songName, String songUrl, double duration, String artist, String genre) {
        this.songNumber = songNumber;
        this.songName = songName;
        this.songUrl = songUrl;
        this.duration = duration;
        this.artist = artist;
        this.genre = genre;
    }
}
