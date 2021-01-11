package simp.java.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import simp.java.manager.MusicManager;
import simp.java.music.vo.Music;
import simp.java.myutil.Myutil;

public class ListFrame extends JFrame{
	public ListFrame(int w, int h, String title) {
		MusicManager mm = new MusicManager();
		mm.setMusicList();
		Myutil.init(this, w, h, title);
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 300);
		back.addActionListener(new backBtnListner());
		
		ArrayList<Music> MusicList = mm.getMusicList();
		int i = 0;
		for(Music m : MusicList) {
			JPanel list[] = new JPanel[MusicList.size()];
//			list[0] = Myutil.(list, w, h, m);
		//	add(list);
		}
		
		/**
		 * 라벨에 리스트를 집어 넣고 패널은 다시 원상 복구 한다. 패널의 y축 크기를 늘린다 ok?
		 */
		
		add(back);
	}
	
	public class backBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new MainFrame(800, 800, "음악 플레이어").setVisible(true);
		}
	}
}
