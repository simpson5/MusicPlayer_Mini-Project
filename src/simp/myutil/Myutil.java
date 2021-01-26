package simp.myutil;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import simp.java.modle.vo.Music;
import simp.java.view.MainFrame;
import simp.java.view.sub.Info;
import simp.java.view.sub.MusicTable;

public class MyUtil {
	
	private static JSlider playBar;
	
	//리스트 패널 변환 메서드
	public static void changePanel(JPanel parent, JPanel next) {
		parent.removeAll();
		parent.add(next , new Integer(300));
		parent.revalidate(); // 컨테이너 하위 계층 구조를 새로고침
		parent.updateUI(); //화면 다시 그리기
		next.revalidate();
		next.updateUI();
		MainFrame.main.revalidate();
		MainFrame.main.repaint();
	}
	
	//문자열을 받을때 정보패널 변환 메서드
	public static void changeInfo(String s) {
		MainFrame.infoPanel.removeAll();
		MainFrame.infoPanel.add(new Info(s));
		MainFrame.infoPanel.revalidate();
		MainFrame.infoPanel.repaint();
		MainFrame.jlp.revalidate();
		MainFrame.jlp.repaint();
	}
	
	//음악 객체를 받을때 정보패널 변환 메서드
	public static void changeInfo(Music m) {
		MainFrame.infoPanel.removeAll();
		MainFrame.infoPanel.add(new Info(m));
		MainFrame.infoPanel.revalidate();
		MainFrame.infoPanel.repaint();
		MainFrame.jlp.revalidate();
		MainFrame.jlp.repaint();
	}
	
	//재생 목록 변환 메서드
	public static void changePlayPanel(Collection<Music> m) {
		MainFrame.playListPanel.removeAll();
		MainFrame.playListPanel.add(new MusicTable(m));
		MainFrame.playListPanel.revalidate();
		MainFrame.playListPanel.repaint();
		//상위 항목 다시그리기 하지 않는 다면 큰일이 난다!
		MainFrame.jlp.revalidate();
		MainFrame.jlp.repaint();
	}
	
	public static void changeResultPanel(Collection<Music> m)  {
		MainFrame.resultPanel.removeAll();
		MainFrame.resultPanel.add(new MusicTable(m));
		MainFrame.resultPanel.revalidate();
		MainFrame.resultPanel.repaint();
		//상위 항목 다시그리기 하지 않는 다면 큰일이 난다!
		MainFrame.jlp.repaint();
	}
	
	public static void playBar(Music m, int j) {
		//1초전 재생바 등 모든 항목을 제거
		MainFrame.playBarPanel.removeAll();
		//새로운 재생바 생성
		playBar = new JSlider(0, m.getPlayTime(), j);
		//항목을 다시 그려줌
		MainFrame.playBarPanel.add(playBar);
		MainFrame.playBarPanel.revalidate();
		MainFrame.playBarPanel.repaint();
		//레이어드를 사용했기 때문에(?) 상위 항목을 반드시 다시 그려줘야 한다.
		MainFrame.jlp.revalidate();
		MainFrame.jlp.repaint();
	}
	
	public static void winAmp(JLabel label) {
		label.setForeground(new Color(67,199,1));
		label.setFont(MainFrame.font);
	}

	public static void setPanel(JPanel jp) {
		jp.setBackground(new Color(0,0,0,0));
		jp.setLayout(null);	
	}
}
