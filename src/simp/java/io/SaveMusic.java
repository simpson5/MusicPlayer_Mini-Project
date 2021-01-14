package simp.java.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;

import simp.java.music.vo.Music;

public class SaveMusic {
	public static void searchSingerMusic(Collection<Music> c) {
		Iterator<Music> iter = c.iterator();
		File f = new File("Data/searchSingerMusic.music");
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream
				(new FileOutputStream(f)));){
			while(iter.hasNext()) {
				Music m = iter.next();
				oos.writeObject(m);
			}
		} catch (IOException e) {	
		}
	}
	
	public static void searchNameMusic(Collection<Music> c) {
		Iterator<Music> iter = c.iterator();
		File f = new File("Data/searchNameMusic.music");
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream
				(new FileOutputStream(f)));){
			while(iter.hasNext()) {
				Music m = iter.next();
				oos.writeObject(m);
			}
		} catch (IOException e) {	
		}
	}
	
	public static void playMusiclsit(Collection<Music> c) {
		Iterator<Music> iter = c.iterator();
		File f = new File("Data/playMusiclsit.music");
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream
				(new FileOutputStream(f)));){
			while(iter.hasNext()) {
				Music m = iter.next();
				oos.writeObject(m);
			}
		} catch (IOException e) {	
		}
	}
	
	public static void allMusiclsit(Collection<Music> c) {
		Iterator<Music> iter = c.iterator();
		File f = new File("Data/allMusiclsit.music");
		try(ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream
				(new FileOutputStream(f)));){
			while(iter.hasNext()) {
				Music m = iter.next();
				oos.writeObject(m);
			}
		} catch (IOException e) {	
		}
	}
}
