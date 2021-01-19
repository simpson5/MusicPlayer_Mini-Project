package simp.java.view;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.modle.vo.Music;

public class AllListPanel extends JPanel {
	
	Collection<Music> allMusicSet;
	
	public AllListPanel(Color c, String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		setBackground(new Color(0,0,0,0));
		setBounds(3, 0, 400, 600);
		//layout이 null이 panel은 scrollpane이 먹히지 않는다.
//		setLayout(new GridLayout(1, 1));
		setLayout(null);
		
//		JScrollPane jsp = new JScrollPane(new MusicTable(allMusicSet), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		jsp.setLocation(0, 0);
//		jsp.setPreferredSize((new Dimension(350, 600)));
//		jsp.setBackground(new Color(0,0,0,0));
		
		//전체 목록을 가져옴
		add(new MusicTable(MusicManager.managerMusicSet));
	}
}
