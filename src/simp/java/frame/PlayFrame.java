package simp.java.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import simp.java.manager.MusicManager;
import simp.java.myutil.Myutil;

public class PlayFrame extends JFrame {
	MusicManager mm = new MusicManager();
	
	public PlayFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		
		setLayout(null);
		
		//재생
		JButton start = Myutil.btn(200, 30, "음악 재생");
		start.setLocation(50, 100);
		start.addActionListener(new startBtnListner());
		
		//정지
		JButton stop = Myutil.btn(200, 30, "음악 정지");
		stop.setLocation(50, 200);
		stop.addActionListener(new stopBtnListner());
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 300);
		back.addActionListener(new backBtnListner());
		
		add(start);
		add(stop);
		add(back);
	}
	
	public class startBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.playMusic();
			mm.setMusicList();
		}
	}
	
	public class stopBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.stopMusic();
		}
	}
	
	public class backBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.stopMusic();
			new MainFrame(800, 800, "음악 플레이어").setVisible(true);
		}
	}
}
