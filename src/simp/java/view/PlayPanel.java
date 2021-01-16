package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.thread.MusicPlay;

public class PlayPanel extends JPanel {
	private JFrame parent;
	JLabel musicinfo;
	
	public PlayPanel(JFrame parent, Color c, String title) {
		this.parent = parent; // 부모객체에 접근하기 위해 미리 필드로 저장
		setBackground(c);
		setLayout(null);
		//크기, 위치 지정
		setBounds(20, 100, 400, 200);
		//재생버튼
		JButton musicStart = new JButton("재생");
		musicStart.addActionListener(new musicStartBtnListner());
		musicStart.setBounds(20, 50, 80, 50);
		//정지버튼
		JButton musicStop = new JButton("정지");
		musicStop.addActionListener(new musicStopBtnListner());
		musicStop.setBounds(100, 50, 80, 50);
		//다음곡
		JButton musicNext = new JButton("다음");
		musicNext.addActionListener(new musicNextBtnListner());
		musicNext.setBounds(180, 50, 80, 50);
		//이전곡
		JButton musicPrevious = new JButton("이전");
		musicPrevious.addActionListener(new musicPreviousBtnListener());
		musicPrevious.setBounds(260, 50, 80, 50);
		//재생바
		JButton musicPlayBar = new JButton();
		//현재 음악정보
		JButton musicInfoBtn = new JButton("정보");
		musicInfoBtn.addActionListener(new musicInfoBtnListener());
		musicinfo = new JLabel();
		musicinfo.setBounds(30, 60, 300, 50);
		
		add(musicStart);
		add(musicStop);
		add(musicNext);
		add(musicPrevious);
		add(musicInfoBtn);
		add(musicinfo);
	}
	
	public class musicInfoBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			musicinfo.setText(MusicPlay.playMusicList.get(MusicPlay.nowMusic).toString());
			musicinfo.setBounds(30, 60, 300, 50);
		}
		
	}
	
	public class musicStartBtnListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.playMusic();
		}
		
	}
	
	public class musicNextBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.nextMusic();
		}
	}
	
	public class musicPreviousBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.previousMusic();
		}
	}
	
	public class musicStopBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.stopMusic();
		}
	}
	
}
