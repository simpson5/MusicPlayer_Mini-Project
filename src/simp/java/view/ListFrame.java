package simp.java.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.music.vo.Music;
import simp.java.view.MainFrame.startBtnListner;
import simp.myutil.Myutil;

public class ListFrame extends MainFrame{
	public ListFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		ArrayList<Music> musicList = mm.getMusicList();
		JPanel list = Myutil.panel(1500, 600);
		list.setLocation(50,50);
		int i = 0;
		for(Music m : musicList) {
			JLabel label[] = new JLabel[musicList.size()];
			label[i] = Myutil.label(700, 50, m);
			label[i].setLocation(0, i * 50);
			
			JButton add = Myutil.btn(100, 30, "추가");
			JButton remove = Myutil.btn(100, 30, "제거");
			JButton start = Myutil.btn(100, 30, "재생");
			
			add.setLocation(1100, i * 50);
			remove.setLocation(1200, i * 50);
			start.setLocation(1300, i*50);
			start.addActionListener(new startBtnListner(m));
			add.addActionListener(new addBtnListner(m));
			remove.addActionListener(new removeBtnListner(m));
			
			list.add(start);
			list.add(add);
			list.add(remove);
			list.add(label[i]);
			i++;
		}
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 700);
		back.addActionListener(new backBtnListner());


		add(list);
		add(back);
	}
}
