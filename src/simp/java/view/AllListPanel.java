package simp.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Collection;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;

public class AllListPanel extends JPanel {
	
	Collection<Music> allMusicSet;
	
	public AllListPanel(Color c, String title) {
		setLayout(null);
		setBackground(new Color(0,0,0,0));
		setBounds(3, 0, 400, 600);

		allMusicSet = MusicManager.managerMusicSet;
		
		JScrollPane jsp = new JScrollPane(new MusicTable(allMusicSet), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jsp.setLocation(0, 0);
		jsp.setSize(350, 600);
//		jsp.setPreferredSize((new Dimension(350, 200)));
		jsp.setBackground(new Color(0,0,0,0));
		
		add(jsp);
	}
}
