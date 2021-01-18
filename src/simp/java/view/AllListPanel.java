package simp.java.view;

import java.awt.Color;
import java.awt.Component;
import java.util.Collection;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class AllListPanel extends JPanel {
	
	Collection<Music> allMusicSet;
	
	public AllListPanel(Color c, String title) {
		setLayout(null);
		setBackground(new Color(0,0,0,0));
		setBounds(415, 90, 400, 600);

		allMusicSet = MusicManager.managerMusicSet;
		
		add(new MusicTable(allMusicSet));
	}
}
