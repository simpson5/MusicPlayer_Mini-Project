package simp.java.thread;

import javax.swing.JSlider;

import simp.java.contoroller.MusicManager;
import simp.java.view.MainFrame;

public class MusicPlayBar implements Runnable {
	private int num;
	private JSlider playBar;

	public MusicPlayBar() {
		this.num = MusicPlay.nowMusic;
	}

	@Override
	public void run() {
		try {
			for(int i = num; i <= MusicManager.managerMusicList.size(); i++) {
				for(int j = 0; j < MusicPlay.playMusicList.get(i).getPlayTime(); j++) {
					System.out.println(j+ " / " +MusicPlay.playMusicList.get(i).getPlayTime());
					MainFrame.playBarPanel.removeAll();
					playBar = new JSlider(0, (int)MusicPlay.playMusicList.get(i).getPlayTime(), j);
					MainFrame.playBarPanel.add(playBar);
					MainFrame.playBarPanel.revalidate();
					MainFrame.playBarPanel.repaint();
					MainFrame.jlp.revalidate();
					MainFrame.jlp.repaint();
					Thread.sleep(1000);
				}
			}
		} catch (IndexOutOfBoundsException e) {
			
		} catch (InterruptedException e) {
			System.out.println("정지와 1초마다 실행을 위해");
		}
	}
}
