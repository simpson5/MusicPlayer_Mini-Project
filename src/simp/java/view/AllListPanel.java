package simp.java.view;

import java.awt.Color;
import java.awt.Component;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import simp.java.music.vo.Music;

public class AllListPanel extends JPanel {
	private JFrame parent;
	
	public AllListPanel(JFrame parent, Color c, String title) {
		this.parent = parent;
		setBackground(c);
		setBounds(400, 100, 400, 600);
		
		setLayout(null);
		
		Set<Music> allMusicSet = MainFrame.mm.getMusicSet();
		
		add(new MusicTable(allMusicSet));
	}
}