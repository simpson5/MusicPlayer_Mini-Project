package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class MusicTable extends JPanel{
	private JPanel list;
	private Collection<Music> c;

	public MusicTable(Collection<Music> c) {
		this.c = c;
		setBounds(0, 0, 400, 600);
		setLayout(null);
		setBackground(new Color(0,0,0,0));

		Iterator<Music> iter = c.iterator();
		int i = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			JLabel l = new JLabel(m.toString());
			JButton add = new JButton("추가");
			JButton remove = new JButton("제거");
			add.addActionListener(new addBtnListner(m));
			remove.addActionListener(new removeBtnListner(m));
			l.setBounds(0, i*50, 350, 50);
			l.setForeground(Color.white);
			add.setBounds(230, 0, 60, 40);
			remove.setBounds(290, 0, 60, 40);
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
