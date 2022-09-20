/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.model;

import java.util.Objects;

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

    public int getSongNumber() {
        return songNumber;
    }

    public void setSongNumber(int songNumber) {
        this.songNumber = songNumber;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songNumber == song.songNumber && Double.compare(song.duration, duration) == 0 && Objects.equals(songName, song.songName) && Objects.equals(songUrl, song.songUrl) && Objects.equals(artist, song.artist) && Objects.equals(genre, song.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songNumber, songName, songUrl, duration, artist, genre);
    }

    @Override
    public String toString() {
        return "Song{" +
                "songNumber=" + songNumber +
                ", songName='" + songName + '\'' +
                ", songUrl='" + songUrl + '\'' +
                ", duration=" + duration +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
