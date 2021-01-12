package simp.java.view;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

import simp.java.music.vo.Music;
import simp.myutil.Myutil;

public class PlayFrame extends MainFrame{
	public PlayFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		
		setLayout(null);
		
		JPanel set = Myutil.panel(1500, 600);
		set.setLocation(50,50);
		
		//재생
		JButton musicSetStart = Myutil.btn(200, 30, "음악 재생");
		musicSetStart.setLocation(50, 100);
		musicSetStart.addActionListener(new musicSetStartBtnListner());
		
		//정지
		JButton stop = Myutil.btn(200, 30, "음악 정지");
		stop.setLocation(50, 200);
		stop.addActionListener(new stopBtnListner());
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 300);
		back.addActionListener(new backBtnListner());
		
		add(musicSetStart);
		add(stop);
		add(back);
	}
}	
