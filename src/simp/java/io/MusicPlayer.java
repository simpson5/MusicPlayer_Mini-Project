package simp.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import simp.java.music.vo.Music;

public class MusicPlayer {
	Player player;
	private File file;
	//음악이 재생중인지 검사
	public boolean play = false;
	
	public MusicPlayer() {
	}

	public MusicPlayer(Music m) {
		try(FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis)) {
			file = new File("Music/" + m.getMusicName() + ".mp3");
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void play() {
		play = true;
		try {
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	
	public void stop() {
		if(play) {
			player.close();
			play = false;
		}
	}
}
