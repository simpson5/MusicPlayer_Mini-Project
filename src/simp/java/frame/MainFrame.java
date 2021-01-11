package simp.java.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;

import simp.java.myutil.Myutil;

public class MainFrame extends JFrame {
	
	public MainFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		
		//음악 재생
		JButton play = Myutil.btn(200, 30, "음악 재생");
		play.setLocation(50, 100);
		play.addActionListener(new playBtnListner());
		
		//리스트 보기 (리스트에 추가 , 제거)
		JButton list = Myutil.btn(200, 30, "리스트 보기");
		list.setLocation(50, 200);
		list.addActionListener(new listBtnListner());
		
		//음악 검색 (제목 가수 장르)
		JButton search = Myutil.btn(200, 30, "음악 검색");
		search.setLocation(50, 300);
		search.addActionListener(new searchBtnListner());
		
		add(play);
		add(list);
		add(search);
		
		
	
	}
	
	public class playBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new PlayFrame(800, 800, "음악 플레이어").setVisible(true);
		}
	}
	
	public class listBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListFrame(800, 800, "음악 리스트").setVisible(true);
		}
	}
	
	public class searchBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SearchFrame(800, 800, "음악 검색").setVisible(true);
		}
	}
}
