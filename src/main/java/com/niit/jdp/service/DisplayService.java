/*
 * Author Name: Aditya Chaurasia
 * Date: 21-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.service;

import com.niit.jdp.model.Song;

import java.util.List;

public class DisplayService {

    public void displayCatalogue(List<Song> songList) {
        System.out.println("========================================================");
        System.out.println("====================SONG CATALOGUE======================");
        System.out.println("\u001B[32mId\t\tSong Name\t\tArtist\t\t\tGenre\tDuration\u001B[0m");
        songList.forEach(song -> System.out.println(song.getId() + "\t\t" + song.getName() + "\t\t" +
                song.getArtist() + "\t\t" + song.getGenre() + "\t\t" + song.getDuration()));
    }
}
