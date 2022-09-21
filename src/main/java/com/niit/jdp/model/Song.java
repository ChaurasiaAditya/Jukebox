/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.model;

import java.util.Objects;

public class Song {
    private int id;
    private String name;
    private String duration;
    private String artist;
    private String genre;
    private String songUrl;

    public Song() {
    }

    public Song(int id, String name, String artist, String genre, String duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.artist = artist;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
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

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id && Objects.equals(name, song.name) && Objects.equals(duration, song.duration) && Objects.equals(artist, song.artist) && Objects.equals(genre, song.genre) && Objects.equals(songUrl, song.songUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, artist, genre, songUrl);
    }

    @Override
    public String toString() {
        return  getId() +"  "+
                getName() + '\'' +
                getArtist() + '\'' +
                getGenre() +
                getDuration() + '\'' +
                "\n";
    }
}
