package simp.java.io;

//쓰레드로 구현 why? 이유는 모르겠으나 이렇게 하지 않으면 프레임 생성 중 멈춘다...
public class SinglePlay extends Thread{
	private MusicPlayer mp;
	
	public SinglePlay(MusicPlayer mp) {
		this.mp = mp;
	}
	
	public SinglePlay() {
//		NullPointerException 방지용?
	}

	public void close() {
		try {
			mp.stop();
			this.interrupt();
			//예외 처리 하지 않으면 왜 안돌아갈까?
		} catch(NullPointerException e) {
			
		}
	}

	@Override
	public void run() {
		mp.play();
		mp.player.getPosition();
	}
}
