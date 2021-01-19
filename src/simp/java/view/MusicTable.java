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
import simp.java.modle.vo.Music;
import simp.myutil.MyUtil;

//음악 목록을 불러오는 클래스
public class MusicTable extends JPanel{
	private Collection<Music> c;

	public MusicTable(Collection<Music> c) {
		this.c = c;
		setBounds(0, 0, 400, 800);
		setBackground(new Color(0,0,0,0));
		setLayout(null);

		Iterator<Music> iter = c.iterator();
		//라벨 위치 조정을 위한 변수
		int i = 0;
		while(iter.hasNext()) {
			Music m = iter.next();
			//음악 제목을 label에 담음
			JLabel l = new JLabel(m.getMusicName());
			//라벨의 위치를 조정
			l.setBounds(0, 43 * i, 350, 43);
			MyUtil.winAmp(l);
			
			//재생 목록 추가, 제거 버튼
			JButton add = new JButton();
			JButton remove = new JButton();
			add.setBounds(220, 0, 60, 38);
			remove.setBounds(280, 0, 60, 38);
			add.setIcon(new ImageIcon("Image/add.jpg"));
			remove.setIcon(new ImageIcon("Image/remove.jpg"));
			add.addActionListener(new addBtnListner(m));
			remove.addActionListener(new removeBtnListner(m));
			
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

		//해당 음악을 메서드를 통해 추가한뒤 재생목록패널에 모든것을 지우고 다시 그린다
		@Override
		public void actionPerformed(ActionEvent e) {
			MainFrame.mm.addMusicList(m);
			MyUtil.changePlayPanel(MusicManager.managerMusicList);
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
			MyUtil.changePlayPanel(MusicManager.managerMusicList);
		}
	}
}

