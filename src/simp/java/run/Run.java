package simp.java.run;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;
import simp.java.view.MainFrame;

public class Run {
	public static void main(String[] args) {
		new MainFrame(800, 800, "음악 플레이어").setVisible(true);
	}
}
