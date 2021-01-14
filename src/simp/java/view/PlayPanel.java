package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayPanel extends JPanel {
	private JFrame parent;
	
	public PlayPanel(JFrame parent, Color c, String title) {
		this.parent = parent; // 부모객체에 접근하기 위해 미리 필드로 저장
		setBackground(c);
		//크기, 위치 지정
		setBounds(0, 0, 400, 300);
		//재생버튼
		JButton musicStart = new JButton("재생");
		musicStart.addActionListener(new musicStartBtnListner());
		//정지버튼
		JButton musicStop = new JButton("정지");
		musicStop.addActionListener(new musicStopBtnListner());
		//다음곡
		JButton musicNext = new JButton("다음");
		musicNext.addActionListener(new musicNextBtnListner());
		//이전곡
		JButton musicPre = new JButton("이전");
		//재생바
		JButton musicPlayBar = new JButton();
		//현재 음악정보
		JLabel musicinfo = new JLabel();
		
		add(musicStart);
		add(musicStop);
		add(musicNext);
		add(musicPre);
		add(musicinfo);
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
	
	public class musicStopBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.stopMusic();
		}
	}
	
}
