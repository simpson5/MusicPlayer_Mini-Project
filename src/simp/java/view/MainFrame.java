package simp.java.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
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
	public static JPanel playPanel;
	public static JPanel searchPanel;
	public static JPanel resultPanel;
	public static JPanel playBarPanel;
	public static JFrame main;
	public static JLayeredPane jlp;
	public static JPanel listPanel;
	public static Font font = new Font("Sans Serif", Font.PLAIN, 15);

	public MainFrame(int w, int h, String title) {
		setTitle(title);
		setSize(800, 800);
//		setResizable(false);
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
		playPanel = new PlayPanel(this, null, "음악 재생");
		//음악 목록 panel
		listPanel = new JPanel();
		listPanel.setBackground(new Color(0,0,0,0));
		listPanel.setBounds(420, 90, 400, 600);
		listPanel.setLayout(null);
		//음악 전체 목록 panel
		allListPanel = new AllListPanel(null, "전체 목록");
		//음악 재생 목록 panel
		playListPanel = new PlayListPanel(null,"재생 목록");
		
		listPanel.add(allListPanel);
		
		//음악 검색 panel
		searchPanel = new SearchPanel(this, null,"검색창");
		//음악 검색 결과 panel
		resultPanel = new ResultPanel(this, null,"검색 목록");
		//음악 리스트 버튼 panel
		JPanel btnPanel = new JPanel();
		btnPanel.setBounds(415, 30, 350, 50);
		btnPanel.setBackground(new Color(0, 0, 0, 0));
		btnPanel.setLayout(null);

		JButton AllListButton = new JButton();
		AllListButton.setBounds(0, 0, 80, 50);
		AllListButton.setIcon(new ImageIcon("Image/alllist.jpg"));
		JButton playListButton = new JButton();
		playListButton.setBounds(90, 0, 80, 50);
		playListButton.setIcon(new ImageIcon("Image/playlist.jpg"));
		JButton shuffleListButton = new JButton();
		shuffleListButton.setBounds(180, 0, 80, 50);
		shuffleListButton.setIcon(new ImageIcon("Image/shuffle.png"));
		JButton sortListButton = new JButton();
		sortListButton.setBounds(270, 0 , 80, 50);
		sortListButton.setIcon(new ImageIcon("Image/sort.jpg"));
		
		btnPanel.add(AllListButton);
		btnPanel.add(playListButton);
		btnPanel.add(shuffleListButton);
		btnPanel.add(sortListButton);
		
		AllListButton.addActionListener(new ChangePanel());
		playListButton.addActionListener(new ChangePanel2());
		shuffleListButton.addActionListener(new ChangePanel3());
		sortListButton.addActionListener(new ChangePanel4());
		
		
		playBarPanel = new PlayBarPanel();
		
		jlp.add(background, new Integer(0));
		jlp.add(playPanel, new Integer(200));
		jlp.add(btnPanel, new Integer(300));
		jlp.add(listPanel, new Integer(300));
		jlp.add(searchPanel, new Integer(300));
		jlp.add(resultPanel, new Integer(300));
		jlp.add(playBarPanel, new Integer(400));

		add(jlp);
	}

	public class ChangePanel implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Myutil.changePanel(listPanel, allListPanel);
		}
	}

	public class ChangePanel2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Myutil.changePanel(listPanel, playListPanel);
		}
	}
	
	public class ChangePanel3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.shuffleMusicList();
			MainFrame.playListPanel.removeAll();
			MainFrame.playListPanel.add(new MusicTable(MusicManager.managerMusicList));
			MainFrame.playListPanel.revalidate();
			MainFrame.playListPanel.repaint();			
			MainFrame.jlp.revalidate();
			MainFrame.jlp.repaint();
			Myutil.changePanel(listPanel, playListPanel);
		}
	}
	
	public class ChangePanel4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.sortMusicList();
			MainFrame.playListPanel.removeAll();
			MainFrame.playListPanel.add(new MusicTable(MusicManager.managerMusicList));
			MainFrame.playListPanel.revalidate();
			MainFrame.playListPanel.repaint();			
			MainFrame.jlp.revalidate();
			MainFrame.jlp.repaint();
			Myutil.changePanel(listPanel, playListPanel);
		}
	}
}
