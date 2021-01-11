package simp.java.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import simp.java.frame.MainFrame;
import simp.java.manager.MusicManager;

public class MainMenu {
	MusicManager mm = new MusicManager();
	Scanner sc = new Scanner(System.in);
	
	public void Menu() {
		new MainFrame(800, 800, "음악 플레이어").setVisible(true);
	}
}
