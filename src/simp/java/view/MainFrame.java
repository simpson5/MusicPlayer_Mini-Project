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
import simp.myutil.MyUtil;

//메인 프레임
public class MainFrame extends JFrame{
	//다시 그리기를 위한 변수
	public static JFrame main;
	//관리자 불러오면서 음악 전체 목록 저장
	public static MusicManager mm = new MusicManager();
	//음악 목록 패널 >> 전체, 재생 두가지를 가지고 있다.
	private JPanel listPanel;
	//전체목록 패널
	public static JPanel allListPanel;
	//재생목록 패널
	public static JPanel playListPanel;
	//재생 패널
	public static JPanel musicInfo;
	public static JPanel playPanel;
	public static JPanel playBarPanel;
	//검색패널
	public static JPanel searchPanel;
	public static JPanel resultPanel;
	//배경화면과 각 패널 레이어드 구분을 위해
	public static JLayeredPane jlp;
	//기본 폰트
	public static Font font = new Font("Sans Serif", Font.PLAIN, 15);

	public MainFrame(String title) {
		//제목, 크기, 크기변환, 위치 지정
		setTitle(title);
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);

		//레이아웃, 종료값 지정
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main = this;

		//레이어드 pane
		jlp = new JLayeredPane();
		jlp.setSize(800, 800);
		jlp.setLayout(null);
		jlp.setOpaque(false);

		//배경 panel
		JPanel background = new BackGround("Image/background.jpg");
		background.setBounds(0, 0, 800, 800);

		//음악 재생 panel
		musicInfo = new MusicInfo();
		playPanel = new PlayPanel(this, null, "음악 재생");
		playBarPanel = new PlayBarPanel();
		
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

		//전체, 재생, 셔플 , 정렬 버튼
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
		
		jlp.add(background, new Integer(0));
		jlp.add(playPanel, new Integer(200));
		jlp.add(musicInfo, new Integer(300));
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
			MyUtil.changePanel(listPanel, allListPanel);
		}
	}

	public class ChangePanel2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			MyUtil.changePanel(listPanel, playListPanel);
		}
	}
	
	public class ChangePanel3 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//셔플을 실행함
			mm.shuffleMusicList();
			//셔플 결과 실행을 확인 + 실제 panel 셔플을 그려줌
			MyUtil.changePlayPanel(MusicManager.managerMusicList);
			//셔플 panel을 열어주는 부분
			MyUtil.changePanel(listPanel, playListPanel);
			mm.playMusic();
		}
	}
	
	public class ChangePanel4 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			mm.sortMusicList();
			MyUtil.changePlayPanel(MusicManager.managerMusicList);
			MyUtil.changePanel(listPanel, playListPanel);
			mm.playMusic();
		}
	}
}
