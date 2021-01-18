package simp.java.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.myutil.Myutil;



public class MainFrame extends JFrame{
	public static MusicManager mm = new MusicManager();
	public static JPanel allListPanel;
	public static JPanel playListPanel;
	public static JPanel searchPanel;
	public static JPanel resultPanel;
	public static JFrame main;
	public static JLayeredPane jlp;

	public MainFrame(int w, int h, String title) {
		setTitle(title);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);

		//		초기화
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = this;

		//레이어드를 위해
		jlp = new JLayeredPane();
		jlp.setSize(800, 800);
		jlp.setLayout(null);
		jlp.setOpaque(false);

		//배경 panel
		JPanel background = new BackGround("Image/background.jpg");
		background.setBounds(0, 0, 800, 800);

		//음악 재생 panel
		JPanel playPanel = new PlayPanel(this, null, "음악 재생");
		//음악 전체 목록 panel
		allListPanel = new AllListPanel(null, "전체 목록");
		//음악 재생 목록 panel
		playListPanel = new PlayListPanel(null,"재생 목록");
		//음악 검색 panel
		searchPanel = new SearchPanel(this, null,"검색창");
		//음악 검색 결과 panel
		resultPanel = new ResultPanel(this, null,"검색 목록");
		//음악 리스트 버튼 panel
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(415, 30, 350, 50);
		btnPanel.setBackground(new Color(0, 0, 0, 0));
		btnPanel.setLayout(null);

		JButton AllListButton = new JButton("전체 목록");
		AllListButton.setBounds(0, 0, 80, 50);
		JButton playListButton = new JButton("재생 목록");
		playListButton.setBounds(90, 0, 80, 50);
		JButton suffleListButton = new JButton("재생 목록");
		suffleListButton.setBounds(180, 0, 80, 50);
		JButton sortListButton = new JButton("재생 목록");
		sortListButton.setBounds(270, 0 , 80,50);
		
		btnPanel.add(AllListButton);
		btnPanel.add(playListButton);
		btnPanel.add(suffleListButton);
		btnPanel.add(sortListButton);
		
		playListButton.addActionListener(new ChangePanel());
		AllListButton.addActionListener(new ChangePanel2());
		
		jlp.add(background, new Integer(0));
		jlp.add(playPanel, new Integer(300));
		jlp.add(btnPanel, new Integer(300));
		jlp.add(allListPanel, new Integer(300));
		jlp.add(playListPanel, new Integer(300));
		jlp.add(searchPanel, new Integer(300));
		jlp.add(resultPanel, new Integer(300));

		getContentPane().add(jlp);
	}

	public class ChangePanel implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Myutil.changePanel(jlp, allListPanel, playListPanel);
		}
	}

	public class ChangePanel2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Myutil.changePanel(jlp, playListPanel, allListPanel);
		}
	}
}
