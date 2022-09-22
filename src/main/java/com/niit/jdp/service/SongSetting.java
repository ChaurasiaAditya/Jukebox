/*
 * Author Name: Aditya Chaurasia
 * Date: 22-09-2022
 * Created With: IntelliJ IDEA Community Edition
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.service;

import com.niit.jdp.exeception.PlaylistIdNotFoundException;
import com.niit.jdp.exeception.SongIdNotFoundException;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SongSetting {
	public void setting(Connection connection, Scanner scanner, DisplayService displayService, PlaylistRepository playlistRepository, SongRepository songRepository) throws SQLException, PlaylistIdNotFoundException, SongIdNotFoundException {

		displayService.displaySetting();
		int counter;
		counter = scanner.nextInt();
		switch (counter) {
			case 1: { // Delete a Playlist
				// Get all playlist from the database
				List<String> allPlaylistNames = playlistRepository.getAllPlaylistNames(connection);
				displayService.displayPlaylists(allPlaylistNames);
				System.out.print("Enter the playlist Id to delete the Playlist : ");
				int playlistId = scanner.nextInt();
				if (playlistRepository.deletePlaylist(connection, playlistId)) {
					System.out.println("\u001B[32mPlaylist " + playlistId + " Deleted Successfully\u001B[0m");
				} else System.err.println("Delete process Fails");
				break;
			}
			case 2: { // Delete a Song
				List<Song> allSongsList = songRepository.getAll(connection);
				// Display all the songs
				displayService.displayCatalogue(allSongsList);
				System.out.print("Enter the Song Id to delete the Song : ");
				int id = scanner.nextInt();
				if (songRepository.deleteById(connection, id)) {
					System.out.println("\u001B[32mSong " + id + " Deleted Successfully\u001B[0m");
				} else {
					System.err.println("Song Deleted Failed");
				}
				break;
			}
			case 3: { // Update Song Name
				List<Song> allSongsList = songRepository.getAll(connection);
				// Display all the songs
				displayService.displayCatalogue(allSongsList);
				System.out.print("Enter the Song Id to Update the Name : ");
				int id = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter the New Name of song : ");
				String name = scanner.nextLine();
				if (songRepository.updateById(connection, id, name)) {
					System.out.println("\u001B[32mSong Name Updated Successfully\u001B[0m");
				} else {
					System.err.println("Song Name Updating Failed");
				}
				break;
			}
			default:
				System.out.println("Exit Setting");
		}
	}
}
