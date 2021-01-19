package simp.java.view;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.modle.vo.Music;

public class PlayListPanel extends JPanel {
	
	private Collection<Music> playMusicList;

	public PlayListPanel(Color c, String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		setBackground(new Color(0,0,0,0));
		setBounds(3, 0, 400, 600);
		setLayout(null);
		
		//재생목록을 가져옴
		add(new MusicTable(MusicManager.managerMusicList));
	}

	//새로 고침을 위한 메서드, 지금은 필요 없음
	public PlayListPanel refresh() {
		System.out.println(MusicManager.managerMusicList);
		playMusicList = MusicManager.managerMusicList;
		removeAll();
		add(new MusicTable(playMusicList));
		return this;
	}
}
