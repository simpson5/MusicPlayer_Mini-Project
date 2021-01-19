package simp.java.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import simp.java.modle.vo.Music;
import simp.java.thread.MusicPlay;
import simp.myutil.MyUtil;

public class Info extends JPanel {
	JLabel musicName = new JLabel();
	JLabel musicSinger = new JLabel();
	JLabel musicGenre = new JLabel();
	private Music m;
	private int sec;
	private int min;
	
	public Info(Music m) {
		setBackground(new Color(0,0,0,0));
		setBounds(0, 0, 300, 150);
		setLayout(null);
		
		this.m = m;
		sec = (int)m.getPlayTime();
		min = sec / 60;
		sec -= min * 60;
		
		musicName = new JLabel(m.getMusicName());
		musicSinger = new JLabel(m.getMusicSinger());
		musicGenre = new JLabel(m.getGenre() +  "  /  "+ m.getReleaseYear() 
					+ " / " + min + " : " +sec);
		System.out.println(m);
		
		musicName.setBounds(0, 0, 300, 20);
		musicSinger.setBounds(0, 20, 300, 20);
		musicGenre.setBounds(0, 40, 300, 20);
		
		MyUtil.winAmp(musicName);
		MyUtil.winAmp(musicSinger);
		MyUtil.winAmp(musicGenre);
		
		add(musicName);
		add(musicSinger);
		add(musicGenre);
	}
	
	public Info(String s) {
		setBackground(new Color(0,0,0,0));
		setBounds(0, 0, 300, 150);
		setLayout(null);
		
		JLabel label = new JLabel(s);
		label.setBounds(0, 20, 300, 20);
		MyUtil.winAmp(label);
		
		add(label);
	}
}
