package simp.java.frame;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.music.vo.Music;
import simp.java.myutil.Myutil;

public class ListFrame extends MainFrame{
	public ListFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		ArrayList<Music> musicList = mm.getMusicList();
		JPanel list = Myutil.panel(700, 200);
		list.setLocation(50,50);
		int i = 0;
		for(Music m : musicList) {
			JLabel label[] = new JLabel[musicList.size()];
			label[i] = Myutil.label(700, 50, m);
			label[i].setLocation(0, i * 50);
			
			JButton add = Myutil.btn(100, 30, "추가");
			JButton remove = Myutil.btn(100, 30, "제거");
			add.setLocation(500, i * 50);
			remove.setLocation(600, i * 50);
			
			list.add(add);
			list.add(remove);
			list.add(label[i]);
			i++;
		}
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 300);
		back.addActionListener(new backBtnListner());


		add(list);
		add(back);
	}
}
