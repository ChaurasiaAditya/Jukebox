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

	/**
	 * This function displays the song catalogue in a tabular format
	 *
	 * @param songList The list of songs to be displayed
	 */
	public void displayCatalogue(List<Song> songList) {
		System.out.println("========================================================");
		System.out.println("====================SONG CATALOGUE======================");
		System.out.println("\u001B[32mId\t\tSong Name\t\tArtist\t\t\tGenre\tDuration\u001B[0m");
		songList.forEach(song -> System.out.println(song.getId() + "\t\t" + song.getName() + "\t\t" + song.getArtist() + "\t\t" + song.getGenre() + "\t\t" + song.getDuration()));
		System.out.println("========================================================");
	}

	/**
	 * This function displays the main menu of the program
	 */
	public void displayMainMenu() {
		System.out.println("===================================");
		System.out.println("===========MAIN MENU===============");
		System.out.println("1. Display all of Songs");
		System.out.println("2. Display all songs by artist");
		System.out.println("3. Display all songs by genre");
		System.out.println("4. Search a song by name");
		System.out.println("5. Add a playlist");
		System.out.println("6. View all playlist");
		System.out.println("7. Settings");
		System.out.println("8. Exit");
		System.out.println("===================================");
		System.out.print("Enter your choice: ");
	}

	/**
	 * This function takes a list of strings as a parameter and prints out the list of strings
	 *
	 * @param playlistList A list of playlist names
	 */
	public void displayPlaylists(List<String> playlistList) {
		System.out.println("===================================");
		System.out.println("===========PLAYLISTS===============");
		playlistList.forEach(System.out::println);
		System.out.println("===================================");
	}

	public void displaySetting() {
		System.out.println("=========Setting==========");
		System.out.println("1. Delete A Playlist");
		System.out.println("2. Delete A Song");
		System.out.println("3. Update Song Name");
		System.out.print("Enter Your Choice : ");
	}
}