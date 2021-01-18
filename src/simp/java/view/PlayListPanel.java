package simp.java.view;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class PlayListPanel extends JPanel {
	
	private Collection<Music> playMusicList;

	public PlayListPanel(Color c, String title) {
		setLayout(null);
		setBackground(new Color(0,0,0,0));
		setBounds(0, 0, 400, 600);
		playMusicList = MusicManager.managerMusicList;
		add(new MusicTable(playMusicList));
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
