package simp.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import simp.java.music.vo.Music;
import simp.java.thread.MusicPlay;

//음악 재생을 위한 클래스
public class MusicPlayer {
	//JLayer 라이브러리에 포함되어 오디오파일을 재생시켜주는 객체
	private Player player;
	private File file;
	//음악이 재생중인지 검사
	public boolean play = false;
	//재생할 음악
	private Music m;
	
	public MusicPlayer() {
	}

	//재생할 음악을 포함한 생성자
	public MusicPlayer(Music m) {
		try {
			this.m = m;
			//재생할 음악의 제목의 파일을 가져온다.
			file = new File("Music/" + m.getMusicName() + ".mp3");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	//음악을 재생 시켜주는 메소드
	public void play() {
		play = true;
		try {
			//JLayer의 play() 메소드가 음악을 재생시킨다.
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch ( ArrayIndexOutOfBoundsException e) {
			System.out.println(MusicPlay.nowMusic);
		}
	}
	
	//음악을 종료하는 메소드
	public void stop() {
		//음악이 재생중인지 검사
		if(play) {
			//JLayer의 close() 메소드가 음악을 종료한다.
			player.close();
			play = false;
		}
	}
	
	//재생중인 음악의 길이를 알려주는 메소드
	public int getTime() {
		return player.getPosition();
	}
}
