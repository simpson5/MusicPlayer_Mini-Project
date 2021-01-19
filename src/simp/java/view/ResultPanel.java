package simp.java.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
	public ResultPanel(JFrame parent, Color c, String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		setBackground(new Color(0,0,0,0));
		setBounds(30, 350, 400, 400);
		setLayout(new GridLayout(1, 1));
	}
}
