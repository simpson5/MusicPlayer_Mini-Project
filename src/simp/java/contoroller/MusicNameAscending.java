package simp.java.contoroller;

import java.util.Comparator;

import simp.java.modle.vo.Music;

//음악 이름을 기준으로 정렬하는 커스텀 정렬 클래스
public class MusicNameAscending implements Comparator<Music> {

	@Override
	public int compare(Music o1, Music o2) {
		return o1.getMusicName().compareTo(o2.getMusicName());
	}

}
