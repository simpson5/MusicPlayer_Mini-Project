package simp.java.myutil;

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
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//초기화
		f.setLayout(null);
	}
	
	//panel 생성
	public static JPanel panel(int w, int h) {
		JPanel p = new JPanel();
		p.setLayout(null);
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
}
