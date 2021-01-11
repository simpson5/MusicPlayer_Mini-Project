package simp.java.frame;

import javax.swing.JButton;
import simp.java.myutil.Myutil;

public class PlayFrame extends MainFrame{
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
}	
