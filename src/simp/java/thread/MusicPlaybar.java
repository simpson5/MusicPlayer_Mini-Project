package simp.java.thread;

import javax.swing.JSlider;

public class MusicPlaybar extends JSlider implements Runnable {
	private int num;
	private long max;
	
	public MusicPlaybar(int num) {
		this.num = num;
		this.max = MusicPlay.playMusicList.get(num).getPlayTime();
		setMajorTickSpacing(60);
		setMinorTickSpacing(1);
	}
	@Override
	public void run() {
		for(int i = 0; i < max; i++) {
//			System.out.println(i + " : " + max);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
	}
}
