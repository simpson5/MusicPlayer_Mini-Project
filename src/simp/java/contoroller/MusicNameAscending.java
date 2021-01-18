package simp.java.contoroller;

import java.util.Comparator;
import simp.java.music.vo.Music;

public class MusicNameAscending implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return o1.getMusicName().compareTo(o2.getMusicName());
	}

}
