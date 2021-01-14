package simp.java.thread;

import java.util.Collection;
import java.util.Iterator;

import simp.java.io.MusicPlayer;
import simp.java.music.vo.Music;

public class MusicPlay extends Thread {
	
	MusicPlayer mp;
	Music m;
	Collection<Music> c;
	
	public MusicPlay(Collection<Music> c) {
		this.c = c;
	}
	
	public void close() {
		for(int i = 0; i < c.size(); i++) {
			mp.stop();
			this.interrupt();
		}
	}
	
	public void next() {
		mp.stop();
		this.interrupt();
	}

	@Override
	public void run() {
		if(c.size() == 0) {
			System.out.println("저장된 곡이 없다");
			return;
		}
		Iterator<Music> iter = c.iterator();
		while(iter.hasNext()) {
			Music m = iter.next();
			mp = new MusicPlayer(m);
			mp.play();
		}
	}

	public MusicPlayer getMp() {
		return mp;
	}

	public void setMp(MusicPlayer mp) {
		this.mp = mp;
	}

	public Collection<Music> getC() {
		return c;
	}

	public void setC(Collection<Music> c) {
		this.c = c;
	}
}
