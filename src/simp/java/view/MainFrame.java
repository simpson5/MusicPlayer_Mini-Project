package simp.java.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import simp.java.contoroller.MusicManager;
import simp.java.music.vo.Music;
import simp.myutil.Myutil;

//가장 처음 보이는 메인 프레임
public class MainFrame extends JFrame {
	//모든 프레임에서 볼 수 있게 스테틱으로 구현
	//프레임을 판넬로 바꾸자.
	public static MusicManager mm = new MusicManager();
	public static JPanel allMusicList;
	public static JPanel playMusicList;
	public static JFrame main;
	
	//기본 생성자를 만들어 상속시에도 반복 되지 않게 한다?
	//하지만 상속하지 않고 내부 클래스로 만들어 보자.
	//그러면 내부 클래스가 너무 증가하기 때문에 매니저 생성자가 만들어 질때 뮤직 리스트를 생성해버리자고
	//메인 프레임을 상속 시키자!
	
	public MainFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main = this;
		
		//음악 재생 panel
		JPanel playPanel = new PlayPanel(this, Color.cyan, "음악 재생");
		add(playPanel);
		//음악 검색 panel
		JPanel searchPanel = new SearchPanel(this, Color.orange,"재생 목록");
		add(searchPanel);
		//음악 전체 목록 panel
		allMusicList = new AllListPanel(this, Color.gray, "전체 목록");
		add(allMusicList);
		//음악 재생 목록 panel
		playMusicList = new PlayListPanel(this, Color.lightGray,"재생 목록");
		
		JButton AllListButton = new JButton("전체 목록");
		AllListButton.setBounds(400, 0, 100, 50);
		AllListButton.addActionListener(new ChangePanel2());
		add(AllListButton);
		JButton playListButton = new JButton("재생 목록");
		playListButton.setBounds(500, 0, 100, 50);
		playListButton.addActionListener(new ChangePanel());
		add(playListButton);
	}
	
	//각 버튼들 -- 상속을 했기때문에 여기서 일괄적으로 구현만해도 잘 돌아간다!
	//하지만 이제 상속이 아니지...
	
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
