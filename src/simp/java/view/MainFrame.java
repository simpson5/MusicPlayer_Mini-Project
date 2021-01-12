package simp.java.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;
import simp.myutil.Myutil;

//가장 처음 보이는 메인 프레임
public class MainFrame extends JFrame {
	//모든 프레임에서 볼 수 있게 스테틱으로 구현
	public static MusicManager mm = new MusicManager();
	
	//기본 생성자를 만들어 상속시에도 반복 되지 않게 한다?
	//하지만 상속하지 않고 내부 클래스로 만들어 보자.
	//그러면 내부 클래스가 너무 증가하기 때문에 매니저 생성자가 만들어 질때 뮤직 리스트를 생성해버리자고
	//메인 프레임을 상속 시키자!
	public MainFrame() {
		
	}
	
	public MainFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
	//각 버튼들 -- 상속을 했기때문에 여기서 일괄적으로 구현만해도 잘 돌아간다!
	public class playBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new PlayFrame(1500, 800, "음악 플레이어").setVisible(true);
		}
	}
	
	public class listBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new ListFrame(1500, 800, "음악 리스트").setVisible(true);
		}
	}
	
	public class searchBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SearchFrame(1500, 800, "음악 검색").setVisible(true);
		}
	}
	
	public class startBtnListner implements ActionListener {
		Music m;
		public startBtnListner(Music m) {
			this.m = m;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			mm.playMusic(m);
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
			dispose();
		}
	}
	
	public class addBtnListner implements ActionListener {
		Music m;
		public addBtnListner(Music m) {
			this.m = m;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.addMusicSet(m);
		}
	}
	
	public class removeBtnListner implements ActionListener {
		Music m;
		public removeBtnListner(Music m) {
			this.m = m;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.removeMusicSet(m);
		}
	}
	
	public class musicSetStartBtnListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			mm.playMusicMulty(mm.getMusicSet());
		}
		
	}
}
