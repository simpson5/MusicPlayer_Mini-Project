package simp.java.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResultPanel extends JPanel {
	public ResultPanel(JFrame parent, Color c, String title) {
		setBackground(c);
		setBounds(0, 350, 400, 400);
		setLayout(null);
	}
}
