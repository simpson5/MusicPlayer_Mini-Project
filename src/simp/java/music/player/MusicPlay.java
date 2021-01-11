package simp.java.music.player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

//쓰레드로 구현 why? 이유는 모르겠으나 이렇게 하지 않으면 프레임 생성 중 멈춘다...
public class MusicPlay extends Thread{
	private Player player;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public MusicPlay(String name) {
		try {
			file = new File("Music/" + name);
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
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
