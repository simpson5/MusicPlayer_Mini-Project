package simp.java.view.list;

import java.util.Collection;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.modle.vo.Music;
import simp.java.view.sub.MusicTable;
import simp.myutil.MyUtil;

public class AllListPanel extends JPanel {
	
	Collection<Music> allMusicSet;
	
	public AllListPanel(String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		MyUtil.setPanel(this);
		setBounds(3, 0, 400, 600);
		
		//전체 목록을 가져옴
		add(new MusicTable(MusicManager.managerMusicSet));
	}
}
