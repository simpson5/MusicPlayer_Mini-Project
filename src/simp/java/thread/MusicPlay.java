package simp.java.thread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.IntUnaryOperator;

import simp.java.contoroller.MusicManager;
import simp.java.io.MusicPlayer;
import simp.java.modle.vo.Music;
import simp.java.view.AllListPanel;
import simp.myutil.MyUtil;

//음악 재생을 위한 쓰레드, 쓰레드로 만들지 않을 경우 음악이 재생중일때 모든 동작이 멈춘다.
public class MusicPlay extends Thread {
	
	//현재 재생중인 곡을 알기 위한 변수 이를 바탕으로 다음곡과 이전곡을 불러온다.
	public static int nowMusic;
	//재생목록에 있는 음악을 플레이어에 담는 변수
	public static ArrayList<Music> playMusicList = MusicManager.managerMusicList;
	//재생목록에 있는 음악을 담기 위한 플레이어 리스트
	public ArrayList<MusicPlayer> mpList = new ArrayList<>();
	
	public MusicPlay() {
		//각 재생 목록 음악을 담기 위한 플레이어를 만든다.
		for(Music music : playMusicList) {
			System.out.println(music);
			MusicPlayer mp = new MusicPlayer(music);
			mpList.add(mp);
		}
	}
	
	//플레이어와 스레드 종료를 위한 메소드
	@SuppressWarnings("deprecation")
	public void close() {
		try {
			//stop 메소드를 호출하지 않으면 스레드가 멈춰도 음악은 재생중이다...why?
			//JLayer 라이브러리 문제인지...
			mpList.get(nowMusic).stop();
//			System.out.println("정지" + nowMusic);
			this.interrupt();
		} catch (IndexOutOfBoundsException e) {
			
		}
		//stop()는 사용 X >> 스레드가 사용 중이던 자원들이 불완전한 상태로 남겨지기 때문
//		this.stop();
	}
	
	//플레이어 실행 메소드
	@Override
	public void run() {
		//저장된 곡이 없다면 그대로 종료
		try {
			if(playMusicList.size() == 0) {
				MyUtil.infoChanger("재생할 곡이 없습니다.");
				return;
			}
			//현재 재생중인 곡
//			System.out.println(nowMusic);
			//nowMusic 부터 음악이 플레이어 수 까지 반복
			for(int i = nowMusic; i < mpList.size(); i++) {
				//오류 검사 용도
				//System.out.println("시작" + nowMusic + " : " + i);
					try {
						//해당 플레이어 재생
						mpList.get(i).play();
					} catch (ArrayIndexOutOfBoundsException e) {
						//오류 검사용
						System.out.println("어레이" + i + " : " + nowMusic);
					}
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						//종료할 경우 현재 음악의 순서를 종료한 음악의 순서로 바꿔줌
						nowMusic = i;
						return;
					}
			}
		} catch (IndexOutOfBoundsException e) {
			//오류 검사용
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
