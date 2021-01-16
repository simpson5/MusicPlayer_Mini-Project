package simp.java.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import simp.java.contoroller.MusicManager;
import simp.java.view.MainFrame.ChangePanel;
import simp.java.view.MainFrame.ChangePanel2;
import simp.myutil.Myutil;



public class MainFrame2 extends JFrame{
	public static MusicManager mm = new MusicManager();
	public static JPanel allMusicList;
	public static JPanel playMusicList;
	public static JPanel searchPanel;
	public static JPanel resultPanel;
	public static JFrame main;
	JScrollPane scrollPane;
	ImageIcon icon;

	public MainFrame2(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		main = this;

		icon = new ImageIcon("Image/background.jpg");

		//배경 panel
		JPanel background = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false); //그림을 표시하게 설정,투명하게 조절
				super.paintComponent(g);
			}
		};
		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

		//음악 재생 panel
		JPanel playPanel = new PlayPanel(this, null, "음악 재생");
		add(playPanel);
		//음악 전체 목록 panel
		allMusicList = new AllListPanel(this, null, "전체 목록");
		add(allMusicList);
		//음악 재생 목록 panel
		playMusicList = new PlayListPanel(this, null,"재생 목록");
		//음악 검색 panel
		searchPanel = new SearchPanel(this, Color.orange,"검색창");
		add(searchPanel);
		//음악 검색 결과 panel
		resultPanel = new ResultPanel(this, Color.orange,"검색 목록");
		add(resultPanel);

		JButton AllListButton = new JButton("전체 목록");
		AllListButton.setBounds(400, 0, 100, 50);
		AllListButton.addActionListener(new ChangePanel2());
		add(AllListButton);

		JButton playListButton = new JButton("재생 목록");
		playListButton.setBounds(500, 0, 100, 50);
		playListButton.addActionListener(new ChangePanel());
		add(playListButton);
	}

	public static class ChangePanel implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Myutil.changePanel(main, allMusicList, playMusicList);
		}
	}

	public static class ChangePanel2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Myutil.changePanel(main, playMusicList, allMusicList);
		}
	}
}
