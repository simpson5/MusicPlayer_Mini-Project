package simp.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import simp.java.music.vo.Music;
import simp.java.thread.MusicPlay;

public class MusicPlayer {
	private Player player;
	private File file;
	//음악이 재생중인지 검사
	public boolean play = false;
	private Music m;
	
	public MusicPlayer() {
	}

	public MusicPlayer(Music m) {
		try {
			this.m = m;
			file = new File("Music/" + m.getMusicName() + ".mp3");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
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
		} catch ( ArrayIndexOutOfBoundsException e) {
			System.out.println(MusicPlay.nowMusic);
		}
	}
	
	public void stop() {
		if(play) {
			player.close();
			play = false;
		}
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}

	public Music getM() {
		return m;
	}

	public void setM(Music m) {
		this.m = m;
	}
}
