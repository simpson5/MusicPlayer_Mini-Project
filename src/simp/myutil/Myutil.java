package simp.myutil;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import simp.java.view.MainFrame;

public class Myutil {
	//프레임 생성
	public static void init(JFrame f, int w, int h, String title) {
		f.setTitle(title);
		f.setSize(w, h);
		f.setLocationRelativeTo(null);
//		초기화
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
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
}
