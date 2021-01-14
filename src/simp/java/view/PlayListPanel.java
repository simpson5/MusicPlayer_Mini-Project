package simp.java.view;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import simp.java.music.vo.Music;

public class PlayListPanel extends JPanel {
	private JFrame parent;

	public PlayListPanel(MainFrame parent, Color c, String title) {
		this.parent = parent;
		setBackground(c);
		setBounds(400, 100, 400, 600);
		
		setLayout(null);
		
		List<Music> playMusicList = MainFrame.mm.getMusicList();
		JButton refrash = new JButton("새로고침");
		refrash.addActionListener(new MainFrame.refrash(this));
		refrash.setBounds(200, 200, 100, 50);
		add(refrash);
		add(new MusicTable(playMusicList));
	}

}
