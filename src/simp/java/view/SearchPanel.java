package simp.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simp.java.music.vo.Music;

public class SearchPanel extends JPanel {
	JTextField inputMusic;

	public SearchPanel(JFrame parent, Color c, String title) {
		setBackground(new Color(0,0,0,0));
		setBounds(50, 250, 400, 50);
		setLayout(null);
		
		inputMusic = new JTextField(10);
		JButton searchMusicBtn = new JButton("제목 검색");
		JButton searchSingerBtn = new JButton("가수 검색");
		inputMusic.setBounds(0, 0, 100, 50);
		searchSingerBtn.setBounds(200, 0, 100, 50);
		searchMusicBtn.setBounds(100, 0, 100, 50);
		searchSingerBtn.addActionListener(new SearchSingerbtnListener());
		searchMusicBtn.addActionListener(new SearchMusicListener());
		add(inputMusic);
		add(searchSingerBtn);
		add(searchMusicBtn);
		
	}
	
	public class SearchSingerbtnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = inputMusic.getText();
			
			MainFrame.resultPanel.removeAll();
			MainFrame.resultPanel.add(new MusicTable(MainFrame.mm.searchMusicBySinger(s)));
			MainFrame.resultPanel.revalidate();
			MainFrame.resultPanel.repaint();
			//상위 항목 다시그리기 하지 않는 다면 큰일이 난다!
			MainFrame.jlp.repaint();
			inputMusic.setText("");
		}
	}
	
	public class SearchMusicListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = inputMusic.getText();
			
			MainFrame.resultPanel.removeAll();
			MainFrame.resultPanel.add(new MusicTable(MainFrame.mm.searchMusicByTitle(s)));
			MainFrame.resultPanel.revalidate();
			MainFrame.resultPanel.repaint();
			//상위 항목 다시그리기
			MainFrame.jlp.repaint();
			inputMusic.setText("");
		}
	}

}
