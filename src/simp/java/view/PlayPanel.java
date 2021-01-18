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
	JLabel musicinfo;
	
	public PlayPanel(JFrame parent, Color c, String title) {
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		//크기, 위치 지정
		setBounds(8, 100, 400, 200);
		//재생버튼
		JButton musicStart = new JButton("재생");
		musicStart.addActionListener(new musicStartBtnListner());
		musicStart.setBounds(10, 50, 70, 50);
		//정지버튼
		JButton musicStop = new JButton("정지");
		musicStop.addActionListener(new musicStopBtnListner());
		musicStop.setBounds(85, 50, 70, 50);
		//다음곡
		JButton musicNext = new JButton("다음");
		musicNext.addActionListener(new musicNextBtnListner());
		musicNext.setBounds(160, 50, 70, 50);
		//이전곡
		JButton musicPrevious = new JButton("이전");
		musicPrevious.addActionListener(new musicPreviousBtnListener());
		musicPrevious.setBounds(235, 50, 70, 50);
		//재생바
		JButton musicPlayBar = new JButton();
		//현재 음악정보
		JButton musicInfoBtn = new JButton("정보");
		musicInfoBtn.addActionListener(new musicInfoBtnListener());
		musicInfoBtn.setBounds(310, 50, 70, 50);
		musicinfo = new JLabel();
		
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
			MainFrame.jlp.repaint();
			musicinfo.setForeground(Color.white);
			musicinfo.setBounds(0, 0, 300, 50);
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
