package simp.java.view;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class AllListPanel extends JPanel {
	
	Collection<Music> allMusicSet;
	
	public AllListPanel(Color c, String title) {
		setLayout(null);
		setBackground(new Color(0,0,0,0));
		setBounds(0, 0, 400, 600);

		allMusicSet = MusicManager.managerMusicSet;
		
		add(new MusicTable(allMusicSet));
	}
}
