package simp.java.frame;

import javax.swing.JButton;
import simp.java.myutil.Myutil;

public class SearchFrame extends MainFrame {
	public SearchFrame(int w, int h, String title) {
		Myutil.init(this, w, h, title);
		
		JButton back = Myutil.btn(200, 30, "뒤로 가기");
		back.setLocation(50, 300);
		back.addActionListener(new backBtnListner());
		
		add(back);
	}
}
