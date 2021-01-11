package simp.java.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import simp.java.myutil.Myutil;

public class SearchFrame extends JFrame {
	public SearchFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 300);
		back.addActionListener(new backBtnListner());
		
		add(back);
	}
	
	public class backBtnListner implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			new MainFrame(800, 800, "음악 플레이어").setVisible(true);
		}
	}
}
