package simp.java.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class PlayListPanel extends JPanel {
	private JFrame parent;
	
	List<Music> playMusicList = MusicManager.musicList;

	public PlayListPanel(MainFrame parent, Color c, String title) {
		this.parent = parent;
		setBackground(c);
		setBounds(400, 100, 400, 600);
		setLayout(null);
	}
}
