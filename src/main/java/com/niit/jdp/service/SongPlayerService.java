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
	public void play(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {

		// create AudioInputStream object
		File songFile = new File(songPath);

		try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(songFile)) {

			// create clip reference
			Clip clip = AudioSystem.getClip();

			// open audioInputStream to the clip
			clip.open(audioInputStream);

			while (true) {
				System.out.println("\n1. Pause\t 2. Resume\t 3. Restart\t 4. Stop\t 5. Exit");
				int choice = scanner.nextInt();
				switch (choice) {
					case 1:
						clip.stop();
						break;
					case 2:
						clip.start();
						break;
					case 3:
						clip.setMicrosecondPosition(0);
						break;
					case 4:
						clip.stop();
						clip.close();
						break;
					case 5:
						clip.stop();
						clip.close();
						System.exit(0);
						break;
					default:
						System.out.println("Invalid choice");
						scanner.close();
				}
			}
		}
	}
}
