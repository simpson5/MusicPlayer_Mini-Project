package simp.java.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BackGround extends JPanel {
	private BufferedImage image;
	private int w;
	private int h;

	public BackGround(String fileName) {
		try {
			image = ImageIO.read(new File(fileName));
			w = image.getWidth();
			h = image.getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		//img객체를 x,y값 만큼 떨어뜨려(offset) 그리기 메소드
		//boolean java.awt.Graphics.drawImage(Image img, int x, int y, ImageObserver observer)
		g.drawImage(image, 0, 0, null);
	}
}
