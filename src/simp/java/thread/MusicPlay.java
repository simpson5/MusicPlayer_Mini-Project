package simp.java.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntUnaryOperator;

import simp.java.contoroller.MusicManager;
import simp.java.io.MusicPlayer;
import simp.java.music.vo.Music;
import simp.java.view.AllListPanel;

public class MusicPlay extends Thread {
	
	//현재 재생중인 곡
	public static int nowMusic;
	public static ArrayList<Music> playMusicList = MusicManager.managerMusicList;
	public ArrayList<MusicPlayer> mpList = new ArrayList<>();
	
	public MusicPlay() {
		for(Music music : playMusicList) {
			System.out.println(music);
			MusicPlayer mp = new MusicPlayer(music);
			mpList.add(mp);
		}
	}
	
	public void close() {
		try {
			mpList.get(nowMusic).stop();
			System.out.println("정지" + nowMusic);
			this.interrupt();
		} catch (IndexOutOfBoundsException e) {
			
		}
//		this.stop();
	}
	
	@Override
	public void run() {
		try {
			if(MusicManager.managerMusicList.size() == 0) {
				System.out.println("저장된 곡이 없다");
				return;
			}
			System.out.println(nowMusic);
			for(int i = nowMusic; i < mpList.size(); i++) {
				System.out.println("시작" + nowMusic + " : " + i);
					try {
						mpList.get(i).play();
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("어레이" + i + " : " + nowMusic);
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						nowMusic = i;
						return;
					}
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("인덱스 " + nowMusic);
		}
	}

	public ArrayList<MusicPlayer> getMpList() {
		return mpList;
	}

	public void setMpList(ArrayList<MusicPlayer> mpList) {
		this.mpList = mpList;
	}
	
	
}
