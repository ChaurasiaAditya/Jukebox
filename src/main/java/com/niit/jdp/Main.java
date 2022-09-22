package com.niit.jdp;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.DisplayService;
import com.niit.jdp.service.SongPlayerService;

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

			int counter;
			do {

				displayService.displayMainMenu();

				counter = scanner.nextInt();
				switch (counter) {
					case 1: {
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
					case 2: {
						// prompt the user to enter the artist name
						System.out.print("Enter the artist name : ");
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
					case 3: {
						// prompt the user to enter the genre
						System.out.print("Enter the genre : ");
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
					case 4: {
						// prompt the user to enter the song name
						System.out.print("Enter the song name : ");
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
					case 5: {
						// prompt the user to enter the playlist name
						System.out.print("Enter the playlist name : ");
						String playlistName = scanner.next();
						// prompt the user to enter the playlist Ids
						System.out.print("Enter the playlist Ids : ");
						String playlistIds = scanner.next();
						if (playlistRepository.addSongsInPlaylist(connection, playlistName, playlistIds)) {
							System.out.println("Playlist added successfully");
						} else {
							System.out.println("Playlist not added");
						}
						break;
					}
					case 6:{
						// Get all playlist from the database
						List<String> allPlaylistNames = playlistRepository.getAllPlaylistNames(connection);
						displayService.displayPlaylists(allPlaylistNames);

						System.out.println("Enter the playlist id to view the songs in the Playlist : ");
						int playlistId = scanner.nextInt();
						// Get all songs in playlist by playlist id from the database
						List<Song> songsInPlaylist = playlistRepository.getAllSongsInPlaylist(connection,playlistId);
						// Display all the songs
						displayService.displayCatalogue(songsInPlaylist);
						System.out.print("\nEnter the Song Id number to play the song : ");
						// Get the song url by id from the database
						int id = scanner.nextInt();
						String urlById = songRepository.getUrlById(connection, id);
						// Play the song
						songPlayerService.play(urlById);
						break;
					}
					default:
						System.out.println("See you soon");
				}
			} while (counter != 7);


		} catch (SQLException | UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
			System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
	}
}