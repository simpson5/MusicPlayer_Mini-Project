package simp.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Collection;

import simp.java.music.vo.Music;

public class LoadMusic {
	public static Collection<Music> loadallMusiclsit() {
		Collection<Music> c = null;
		File f = new File("Data/allMusiclsit.music");
		try(ObjectInputStream ois =
				new ObjectInputStream(
						new BufferedInputStream(
								new FileInputStream(f)));){
			while(true) {
				c.add((Music)ois.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {	
		}
		return c;
	}
}
