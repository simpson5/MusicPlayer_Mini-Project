package simp.java.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import simp.java.music.vo.Music;

public class SearchPanel extends JPanel {
	JTextField inputMusic;

	public SearchPanel(JFrame parent, Color c, String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		setBackground(new Color(0,0,0,0));
		setBounds(50, 250, 400, 50);
		setLayout(null);
		
		//검색창
		inputMusic = new JTextField(10);
		inputMusic.setBounds(0, 5, 100, 40);
		inputMusic.setBackground(Color.black);
		inputMusic.setForeground(new Color(67,199,1));
		inputMusic.setBorder(new LineBorder(Color.black, 8, true));
		
		//제목 , 가수 검색 버튼
		JButton searchMusicBtn = new JButton();
		JButton searchSingerBtn = new JButton();
		searchSingerBtn.setBounds(210, 0, 90, 50);
		searchMusicBtn.setBounds(110, 0, 90, 50);
		searchSingerBtn.setIcon(new ImageIcon("Image/sing.png"));
		searchMusicBtn.setIcon(new ImageIcon("Image/song.png"));
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
			
//			JScrollPane jsp = new JScrollPane(new MusicTable(MainFrame.mm.searchMusicBySinger(s)), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//			jsp.setLocation(0, 0);
//			jsp.setPreferredSize((new Dimension(340, 375)));
//			jsp.setBackground(new Color(0,0,0,0));
			
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
