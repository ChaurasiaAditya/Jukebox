/*
 * Author Name: Aditya Chaurasia
 * Date: 20-09-2022
 * Created With: IntelliJ IDEA Ultimate
 * Profile: github.com/ChaurasiaAditya
 */
package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SongPlayerService {
	Scanner scanner = new Scanner(System.in);

	/**
	 * It plays the song at the given path and allows the user to pause, resume, restart, stop and exit the song
	 *
	 * @param songPath The path of the song file.
	 */
	public void play(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		// create AudioInputStream object
		File songFile = new File(songPath);

		try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile)) {
			// create clip reference
			Clip clip = AudioSystem.getClip();

			// open audioInputStream to the clip
			clip.open(audioInputStream);

			// start the clip
			clip.start();

			int choice;
			do {
				System.out.println("\nEnter 1. Pause\t 2. Resume\t 3. Restart\t 4.Back to Main Menu");
				System.out.print("Enter your choice: ");
				choice = scanner.nextInt();
				switch (choice) {
					case 1:
						clip.stop();
						break;
					case 2:
						clip.start();
						break;
					case 3:
						clip.setMicrosecondPosition(0);
						clip.start();
						break;
					case 4:
						clip.stop();
						clip.close();
						break;
					default:
						System.out.println("Invalid choice");
				}
			} while (choice != 4);
		}
	}
}