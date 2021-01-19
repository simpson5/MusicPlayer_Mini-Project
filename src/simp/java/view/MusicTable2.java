package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class MusicTable2 extends JPanel{
	private Collection<Music> c;

	public MusicTable2(Collection<Music> c) {
		this.c = c;
		setBounds(0, 0, 400, 800);
		setBackground(new Color(0,0,0,0));
		setLayout(null);

		Iterator<Music> iter = c.iterator();
		int i = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			JLabel l = new JLabel(m.getMusicName());
			JButton add = new JButton();
			JButton remove = new JButton();
			add.addActionListener(new addBtnListner(m));
			remove.addActionListener(new removeBtnListner(m));
			l.setBounds(0, 50 * i, 350, 50);
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

