package simp.java.view;

import java.awt.Color;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simp.java.music.vo.Music;

public class SearchPanel extends JPanel {
	private JFrame parent;

	public SearchPanel(JFrame parent, Color c, String title) {
		this.parent = parent; // 부모객체에 접근하기 위해 미리 필드로 저장
		setBackground(c);
		setBounds(0, 300, 400, 400);
		
		JTextField inputEmail = new JTextField(10);
		JButton searchBtn = new JButton("검색");
		add(inputEmail);
		add(searchBtn);
		String singer = "";
		
//		List<Music> searchList = MainFrame.mm.searchMusicBySinger("벤");
		
//		add(new MusicTable(searchList));
	}

}
