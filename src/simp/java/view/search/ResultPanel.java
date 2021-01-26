package simp.java.view.search;

import javax.swing.JPanel;

import simp.myutil.MyUtil;

public class ResultPanel extends JPanel {
	public ResultPanel(String title) {
		//기본 패널 설정 >> 투명도, 위치/크기, 레이아웃
		MyUtil.setPanel(this);
		setBounds(30, 350, 400, 400);
	}
}
