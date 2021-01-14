package simp.myutil;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import simp.java.music.vo.Music;

public class Myutil {
	//프레임 생성
	public static void init(JFrame f, int w, int h, String title) {
		f.setTitle(title);
		f.setSize(w, h);
		f.setLocationRelativeTo(null);
		//초기화
		f.setLayout(null);
	}
	
	//panel 생성
	public static JPanel panel(int w, int h) {
		JPanel p = new JPanel();
//		p.setLayout(null);
		p.setSize(w, h);
		p.setBackground(Color.lightGray);
		return p;
		
	}
	//Label 생성
	public static JLabel label(int w, int h, Music m) {
		JLabel l = new JLabel(m.toString());
		l.setSize(w, h);
		return l;
	}
	
	//Button 생성
	public static JButton btn(int w, int h, String name) {
		JButton b = new JButton(name);
		b.setSize(w, h);
		return b;
	}
	
	//TextField 생성
	public static void text(JTextField t, int w, int h, String title) {
		t.setSize(w, h);
	}
	
	public static void changePanel(JFrame parent, JPanel current, JPanel next) {
		parent.remove(current);
		parent.add(next);
		parent.revalidate(); // 컨테이너 하위 계층 구조를 새로고침
		parent.repaint(); //화면 다시 그리기
	}
}
