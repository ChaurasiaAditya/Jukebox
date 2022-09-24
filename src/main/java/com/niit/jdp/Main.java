package com.niit.jdp;

import com.niit.jdp.exeception.PlaylistIdNotFoundException;
import com.niit.jdp.exeception.SongIdNotFoundException;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.DisplayService;
import com.niit.jdp.service.SongPlayerService;
import com.niit.jdp.service.SongSetting;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Create a scanner object
		Scanner scanner = new Scanner(System.in);

		// Create an object of DatabaseService
		DatabaseService databaseService = new DatabaseService();

		try {
			// Get a connection
			databaseService.connect();

			// Get the connection object
			Connection connection = databaseService.getConnection();

			// Create a repository object
			SongRepository songRepository = new SongRepository();

			// print the connection status
			databaseService.printConnectionStatus();

			// Create a DisplayService object
			DisplayService displayService = new DisplayService();

			// Create a music player service object
			SongPlayerService songPlayerService = new SongPlayerService();

			// Create a playlist repository object
			PlaylistRepository playlistRepository = new PlaylistRepository();

			// Create a Song Setting Object
			SongSetting songSetting = new SongSetting();

			int choice;
			do {
				displayService.displayMainMenu();
				choice = scanner.nextInt();
				switch (choice) {
					case 1: { // Show all Songs from Database
						// Get all songs from the database
						List<Song> allSongsList = songRepository.getAll(connection);
						// Display all the songs
						displayService.displayCatalogue(allSongsList);
						System.out.print("\nEnter the Song Id number to play the song : ");
						int id = scanner.nextInt();
						// Get the song url by id from the database
						String urlById = songRepository.getUrlById(connection, id);
						// Play the song
						songPlayerService.play(urlById);
						break;
					}
					case 2: { // All songs with respected artist name
						// prompt the user to enter the artist name
						System.out.print("Enter the artist name : ");
						scanner.nextLine();
						String artist = scanner.nextLine();
						// Get all songs by artist from the database
						List<Song> songListByArtist = songRepository.getByArtist(connection, artist);
						// Display all the songs
						displayService.displayCatalogue(songListByArtist);
						System.out.print("\nEnter the Song Id number to play the song : ");
						int id = scanner.nextInt();
						// Get the song url by id from the database
						String urlById = songRepository.getUrlById(connection, id);
						// Play the song
						songPlayerService.play(urlById);
						break;
					}
					case 3: { // All songs with respected genre
						// prompt the user to enter the genre
						System.out.print("Enter the genre : ");
						scanner.nextLine();
						String genre = scanner.next();
						// Get all songs by genre from the database
						List<Song> songsListByGenre = songRepository.getByGenre(connection, genre);
						// Display all the songs
						displayService.displayCatalogue(songsListByGenre);
						System.out.print("\nEnter the Song Id number to play the song : ");
						// Get the song url by id from the database
						int id = scanner.nextInt();
						String urlById = songRepository.getUrlById(connection, id);
						// Play the song
						songPlayerService.play(urlById);
						break;
					}
					case 4: { // search song by name
						// prompt the user to enter the song name
						System.out.print("Enter the song name : ");
						scanner.nextLine();
						String name = scanner.nextLine();
						// Get all songs by name from the database
						List<Song> songListByName = songRepository.getByName(connection, name);
						// Display all the songs
						displayService.displayCatalogue(songListByName);
						System.out.print("\nEnter the Song Id number to play the song : ");
						// Get the song url by id from the database
						int id = scanner.nextInt();
						String urlById = songRepository.getUrlById(connection, id);
						// Play the song
						songPlayerService.play(urlById);
						break;
					}
					case 5: { // Make a playlist and Add songs to it
						// prompt the user to enter the playlist name
						System.out.print("Enter the playlist name : ");
						scanner.nextLine();
						String playlistName = scanner.nextLine();
						displayService.displayCatalogue(songRepository.getAll(connection));
						// prompt the user to enter the Song Ids
						System.out.print("Enter the Song Ids seperated by Spaces or 0 for Main Menu : ");
						String playlistIds = scanner.nextLine();
						if (!playlistIds.equals("0") && playlistRepository.createNewPlaylist(connection, playlistName, playlistIds)) {
							System.out.println("\u001B[32mPlaylist added successfully\u001B[0m");
						}
						break;
					}
					case 6: { // VIEW ALL PLAYLIST
						// Get all playlist from the database
						List<String> allPlaylistNames = playlistRepository.getAllPlaylistNames(connection);
						displayService.displayPlaylists(allPlaylistNames);

						System.out.print("Enter the playlist Id to view the songs in the Playlist or 0 for Main Menu : ");
						int playlistId = scanner.nextInt();
						if (playlistId > 0) {
							// Get all songs in playlist by playlist id from the database
							List<Song> songsInPlaylist = playlistRepository.getAllSongsInPlaylist(connection, playlistId);
							// Display all the songs
							displayService.displayCatalogue(songsInPlaylist);
							System.out.print("\nEnter the Song Id number to play the song or 0 for Main Menu : ");
							// Get the song url by id from the database
							int id = scanner.nextInt();
							if (id > 0) {
								String urlById = songRepository.getUrlById(connection, id);
								// Play the song
								songPlayerService.play(urlById);
							}
						}
						break;
					}
					case 7: {
						// Call the setting method to perform the setting Operations
						songSetting.setting(connection, scanner, displayService, playlistRepository, songRepository);
						break;
					}
					default:
						System.out.println("\u001B[32mThank You For Using Jukebox\u001B[0m");
				}
			} while (choice != 8);

		} catch (SQLException | UnsupportedAudioFileException | LineUnavailableException | IOException |
				 PlaylistIdNotFoundException | SongIdNotFoundException exception) {
			System.out.println(exception.getMessage());
		}
		scanner.close();
	}
}