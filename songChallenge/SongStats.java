/**
 * 
 */
package songChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */
public class SongStats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Variables
		
		String line;
		int count = 1;
		ArrayList<Song> songs = new ArrayList<Song>();
		
		File file = new File("songlist-1.csv");
		
		
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			// Removing the column headers
			
			br.readLine();
			
			// Read first line
			
			line = br.readLine();
			
			while(line != null) {
			
			String[] csvSplit = line.split(",");
			int highestPosition = Integer.parseInt(csvSplit[2]);
			
			Song song = new Song(csvSplit[0], csvSplit[1], highestPosition);
			
			songs.add(song);
			
			System.out.println(song);
			
			line = br.readLine();
			
			}
			
			br.close();
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (Song s : songs) {
			System.out.println(s.getArtist() + ", " + s.getTitle() + ", " + s.getHighestPosition());
		}
		
		
		
	}

}
