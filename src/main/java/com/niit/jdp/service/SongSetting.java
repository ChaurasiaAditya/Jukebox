/*
 * Author Name: Aditya Chaurasia
 * Date: 22-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.service;

import com.niit.jdp.exeception.PlaylistIdNotFoundException;
import com.niit.jdp.exeception.SongIdNotFoundException;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SongSetting {
	public void setting(Connection connection, Scanner scanner, DisplayService displayService, PlaylistRepository playlistRepository, SongRepository songRepository) throws SQLException, PlaylistIdNotFoundException, SongIdNotFoundException {

		displayService.displaySetting();
		int counter;
		counter = scanner.nextInt();
		switch (counter) {
			case 1: { // Delete a Playlist
				// Get all playlist from the database
				displayService.displayPlaylists(playlistRepository.getAllPlaylistNames(connection));
				System.out.println("Enter the playlist Id to delete the Playlist or 0 to Cancel delete process");
				System.out.print("Enter your Choice : ");
				int playlistId = scanner.nextInt();
				if (playlistId > 0 && playlistRepository.deletePlaylist(connection, playlistId)) {
					System.out.println("\u001B[32mPlaylist " + playlistId + " Deleted Successfully\u001B[0m");
				} else {
					System.out.println("Playlist deletion Cancelled ");
				}
				break;
			}
			case 2: { // Delete a Song
				// Display all the songs
				displayService.displayCatalogue(songRepository.getAll(connection));
				System.out.println("Enter the Song Id to delete the Song or 0 to Cancel delete process");
				System.out.print("Enter your Choice : ");
				int id = scanner.nextInt();
				if (id > 0 && songRepository.deleteById(connection, id)) {
					System.out.println("\u001B[32mSong " + id + " Deleted Successfully\u001B[0m");
				}
				break;
			}
			case 3: { // Update Song Name
				// Display all the songs
				displayService.displayCatalogue(songRepository.getAll(connection));
				System.out.print("Enter the Song Id to Update the Name or 0 to Cancel Update process : ");
				int id = scanner.nextInt();
				if (id > 0) {
					scanner.nextLine();
					System.out.print("Enter the New Name of song : ");
					String name = scanner.nextLine();
					if (songRepository.updateById(connection, id, name)) {
						System.out.println("\u001B[32mSong Name Updated Successfully\u001B[0m");
					} else {
						System.out.println("Song Name Update Failed");
					}
				} else {
					System.out.println("Song Name Updating Cancelled");
				}
				break;
			}
			default:
				System.out.println("Exit Setting");
		}
	}
}
