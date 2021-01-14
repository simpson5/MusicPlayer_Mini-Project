package simp.java.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import simp.java.music.vo.Music;
import simp.myutil.TableCell;

public class MusicTable extends JPanel{
	private Collection<Music> c;
	
	public MusicTable(Collection<Music> c) {
		this.c = c;
		setSize(400, 700);
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
		
		//테이블로 하는 방식 체크박스 추가에서 포기...
//		Object[] columnNames = {
//				"제목", "가수", "장르", "재생"
//		};
//		
//		Object[][] rowData = new Object[c.size()][columnNames.length];
//		Iterator<Music> iter = c.iterator();
//		for(int i = 0; i < c.size(); i++) {
//			Music m = iter.next();
//			rowData[i][0] = m.getMusicName();
//			rowData[i][1] = m.getMusicSinger();
//			rowData[i][2] = m.getGenre();
//		}
//		
//		JTable table = new JTable(rowData, columnNames);
//		table.setSize(400, 800);
//		
//		table.getColumn("재생").setCellRenderer(new TableCell());
//		table.getColumn("재생").setCellEditor(new TableCell());
//		
//		JScrollPane scroll = new JScrollPane(table);
//		add(scroll);
	}
	
	public static class addBtnListner implements ActionListener {
		Music m;
		public addBtnListner(Music m) {
			this.m = m;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.addMusicList(m);
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
		}
	}
	
}
