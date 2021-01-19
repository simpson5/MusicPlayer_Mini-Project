package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.modle.vo.Music;
import simp.java.thread.MusicPlay;
import simp.myutil.MyUtil;

public class MusicInfo extends JPanel {
	public MusicInfo() {
		setBackground(new Color(0,0,0,0));
		setBounds(25, 50, 300, 150);
		setLayout(null);
	}
	
	public static class musicInfoBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MyUtil.infoChanger(MusicPlay.playMusicList.get(MusicPlay.nowMusic));
		}
		
	}
}
