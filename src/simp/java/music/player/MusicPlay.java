package simp.java.music.player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicPlay extends Thread{
	private Player player;
//	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public MusicPlay(String name) {
		try {
//			this.isLoop = isLoop;
			file = new File("Music/" + name);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		
		System.out.println("실행");
	}
	
	public int getTime() {
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {
		player.close();
		this.interrupt();
	}

	@Override
	public void run() {
		try {
				player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
}
