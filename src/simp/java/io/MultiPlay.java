package simp.java.io;

import java.util.Collection;
import java.util.Iterator;

import simp.java.music.vo.Music;

public class MultiPlay extends Thread {
	
	MusicPlayer mp;
	Collection<Music> c;
	
	public MultiPlay(Collection<Music> c) {
		this.c = c;
	}
	
	public void close() {
		try {
			mp.stop();
			this.interrupt();
			//예외 처리 하지 않으면 왜 안돌아갈까?
		} catch(NullPointerException e) {
			
		}
	}

	@Override
	public void run() {
		Iterator<Music> iter = c.iterator();
		while(iter.hasNext()) {
			Music m = iter.next();
			mp = new MusicPlayer(m);
			mp.play();
		}
	}
}
