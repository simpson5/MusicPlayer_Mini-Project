package simp.java.thread;

import javax.swing.JSlider;

import simp.java.contoroller.MusicManager;
import simp.myutil.MyUtil;

//음악 재생바를 위한 스레드
public class MusicPlayBar implements Runnable {
	private int num;
	//슬라이더를 통해 구현
	private JSlider playBar;

	//재생중인 음악을 변수에 대입
	public MusicPlayBar() {
		this.num = MusicPlay.nowMusic;
	}

	//재생바를 위한 메소드
	//1초마다 새로운 슬라이더를 만들어 재생바가 움직이는 것 처럼 보여줌
	@Override
	public void run() {
		try {
			for(int i = num; i <= MusicManager.managerMusicList.size(); i++) {
				for(int j = 1; j <  MusicPlay.playMusicList.get(i).getPlayTime(); j++) {
//					System.out.println(j+ " / " +MusicPlay.playMusicList.get(i).getPlayTime());
					MyUtil.playBar(MusicPlay.playMusicList.get(i), j);
					//1초마다
					Thread.sleep(1000);
				}
				MusicPlay.nowMusic ++;
				MyUtil.infoChanger(MusicPlay.playMusicList.get(MusicPlay.nowMusic));
			}
		} catch (IndexOutOfBoundsException e) {
			
		} catch (InterruptedException e) {
			System.out.println("정지와 1초마다 실행을 위해");
		}
	}
}
