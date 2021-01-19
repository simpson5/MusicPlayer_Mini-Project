package simp.java.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
	public ResultPanel(JFrame parent, Color c, String title) {
		setBackground(new Color(0,0,0,0));
		setBounds(20, 350, 400, 400);
		setLayout(new GridLayout(1, 1));
	}
}
