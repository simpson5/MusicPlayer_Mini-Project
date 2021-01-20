package simp.java.view;

import java.util.Collection;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.modle.vo.Music;
import simp.myutil.MyUtil;

public class AllListPanel extends JPanel {
	
	Collection<Music> allMusicSet;
	
	public AllListPanel(String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		MyUtil.setPanel(this);
		setBounds(3, 0, 400, 600);
		
		//layout이 null이 panel은 scrollpane이 먹히지 않는다.
		
		//전체 목록을 가져옴
		add(new MusicTable(MusicManager.managerMusicSet));
	}
}
