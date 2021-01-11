package simp.java.myutil;

import javax.swing.JFrame;

public class Myutil {
		public static void init(JFrame f, int w, int h, String title) {
			f.setTitle(title);
			f.setSize(w, h);
			f.setLocationRelativeTo(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}
