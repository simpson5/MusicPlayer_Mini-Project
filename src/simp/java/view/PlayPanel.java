package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.thread.MusicPlay;

public class PlayPanel extends JPanel {
	public static JPanel musicInfo;
	JLabel musicName;
	JLabel musicSinger;
	JLabel musicGenre;
	
	public PlayPanel(JFrame parent, Color c, String title) {
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		//크기, 위치 지정
		setBounds(8, 20, 400, 400);
		//재생버튼
		JButton musicStart = new JButton();
		musicStart.addActionListener(new musicStartBtnListner());
		musicStart.setBounds(10, 130, 70, 50);
		musicStart.setIcon(new ImageIcon("Image/play.png"));
		//정지버튼
		JButton musicStop = new JButton();
		musicStop.addActionListener(new musicStopBtnListner());
		musicStop.setBounds(85, 130, 70, 50);
		musicStop.setIcon(new ImageIcon("Image/stop.png"));
		//다음곡
		JButton musicNext = new JButton();
		musicNext.addActionListener(new musicNextBtnListner());
		musicNext.setBounds(160, 130, 70, 50);
		musicNext.setIcon(new ImageIcon("Image/next.png"));
		//이전곡
		JButton musicPrevious = new JButton();
		musicPrevious.addActionListener(new musicPreviousBtnListener());
		musicPrevious.setBounds(235, 130, 70, 50);
		musicPrevious.setIcon(new ImageIcon("Image/pre.png"));
		
		//현재 음악정보
		JButton musicInfoBtn = new JButton();
		musicInfoBtn.addActionListener(new MusicInfo.musicInfoBtnListener());
		musicInfoBtn.setBounds(310, 130, 70, 50);
		musicInfoBtn.setIcon(new ImageIcon("Image/info.png"));

		add(musicStart);
		add(musicStop);
		add(musicNext);
		add(musicPrevious);
		add(musicInfoBtn);
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
