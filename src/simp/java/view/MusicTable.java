package simp.java.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class MusicTable extends JPanel{
	private Collection<Music> c;

	public MusicTable(Collection<Music> c) {
		this.c = c;
		setBounds(0, 0, 400, 800);
		//layout이 null이 panel은 scrollpane이 먹히지 않는다.
		setLayout(new GridLayout(10, 0, 0, 10));
		setBackground(new Color(0,0,0,0));

		Iterator<Music> iter = c.iterator();
		int i = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			JLabel l = new JLabel(m.getMusicName());
			JButton add = new JButton();
			JButton remove = new JButton();
			add.addActionListener(new addBtnListner(m));
			remove.addActionListener(new removeBtnListner(m));
//			l.setBounds(0, 50 * i, 350, 50);
			l.setForeground(new Color(67,199,1));
			l.setFont(MainFrame.font);
			add.setBounds(220, 0, 60, 40);
			add.setIcon(new ImageIcon("Image/add.jpg"));
			remove.setBounds(280, 0, 60, 40);
			remove.setIcon(new ImageIcon("Image/remove.jpg"));
			l.add(add);
			l.add(remove);
			add(l);
			i++;
		}
	}

	//추가 제거 하면서 playpanel에 있던 내용 다 지우고 다시 그리기 이러지 않으면 동기화 X
	public class addBtnListner implements ActionListener {
		Music m;

		public addBtnListner(Music m) {
			this.m = m;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.addMusicList(m);
			MainFrame.playListPanel.removeAll();
			MainFrame.playListPanel.add(new MusicTable(MusicManager.managerMusicList));
			MainFrame.playListPanel.revalidate();
			MainFrame.playListPanel.repaint();
			//상위 항목 다시그리기 하지 않는 다면 큰일이 난다!
			MainFrame.jlp.revalidate();
			MainFrame.jlp.repaint();
		}
	}

	public class removeBtnListner implements ActionListener {
		Music m;
		public removeBtnListner(Music m) {
			this.m = m;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.removeMusicList(m);
			MainFrame.playListPanel.removeAll();
			MainFrame.playListPanel.add(new MusicTable(MusicManager.managerMusicList));
			MainFrame.playListPanel.revalidate();
			MainFrame.playListPanel.repaint();			
			MainFrame.jlp.revalidate();
			MainFrame.jlp.repaint();
		}
	}
}
