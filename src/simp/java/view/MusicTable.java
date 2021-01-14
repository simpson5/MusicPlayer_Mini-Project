package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;
import simp.myutil.TableCell;

public class MusicTable extends JPanel{
	private Collection<Music> c;
	
	public MusicTable(Collection<Music> c) {
		this.c = c;
		setBackground(Color.green);
		setSize(400, 600);
		setLayout(null);
		Iterator<Music> iter = c.iterator();
		int i = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			JLabel l = new JLabel(m.toString());
			JButton add = new JButton("추가");
			JButton remove = new JButton("제거");
			add.addActionListener(new addBtnListner(m));
			remove.addActionListener(new removeBtnListner(m));
			l.setBounds(0, i*50, 400, 50);
			add.setBounds(200, 0, 100, 50);
			remove.setBounds(300, 0, 100, 50);
			l.add(add);
			l.add(remove);
			add(l);
			i++;
		}
	}
	
	//추가 제거 하면서 playpanel에 있던 내용 다 지우고 다시 그리기 이러지 않으면 동기화 X
	public static class addBtnListner implements ActionListener {
		Music m;
		public addBtnListner(Music m) {
			this.m = m;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.addMusicList(m);
			MainFrame.playMusicList.removeAll();
			MainFrame.playMusicList.add(new MusicTable(MusicManager.musicList));
			MainFrame.playMusicList.revalidate();
			MainFrame.playMusicList.repaint();
		}
	}
	
	public static class removeBtnListner implements ActionListener {
		Music m;
		public removeBtnListner(Music m) {
			this.m = m;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.removeMusicList(m);
			MainFrame.playMusicList.removeAll();
			MainFrame.playMusicList.add(new MusicTable(MusicManager.musicList));
			MainFrame.playMusicList.revalidate();
			MainFrame.playMusicList.repaint();
		}
	}
}
