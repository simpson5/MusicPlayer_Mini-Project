package simp.java.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.thread.MusicPlay;
import simp.myutil.MyUtil;

public class InfoPanel extends JPanel {
	public InfoPanel() {
		MyUtil.setPanel(this);
		setBounds(25, 50, 300, 150);
	}
	
	public static class musicInfoBtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MyUtil.infoChanger(MusicManager.managerMusicList.get(MusicManager.nowMusic));
		}
		
	}
}
