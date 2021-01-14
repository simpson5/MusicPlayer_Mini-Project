package simp.java.contoroller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import simp.java.io.SetMusic;
import simp.java.music.vo.Music;
import simp.java.thread.MusicPlay;

public class MusicManager {
	//음악 셋 전체 목록
	public static HashSet<Music> musicSet = new HashSet<>();
	//음악 리스트 재생 목록
	public static ArrayList<Music> musicList = new ArrayList<>();
	public static MusicPlay mp;
	
	//메니저 객체 생성시 음악 저장
	public MusicManager() {
		saveMusicSet();
	}
	
	//음악재생
	public void playMusic() {
		mp = new MusicPlay(musicList);
		mp.start();
	}
	
	//음악정지
	public void nextMusic() {
		try {
			mp.next();
		} catch(NullPointerException e) {
			//실행된 mp가 없을 경우에
		}
	}
	
	public void stopMusic() {
		mp.stop();
	}
	
	//음악들 폴더에서 불러오기 나중에 자세히 보자
	public void saveMusicSet() {
		new SetMusic("Music", musicSet);
	}
	
	//저장된 음악(전체 목록) 불러오기
	public Set<Music> getMusicSet() {
		return this.musicSet;
	}
	
	//재생 목록에 음악 추가
	public void addMusicList(Music m) {
		//음악이 재생 목록에 없다면 추가
		if(!musicList.contains(m)) {
			musicList.add(m);
			System.out.println(m.getMusicName() + "이 재생목록에 추가되었습니다.");
		}
		else {
			System.out.println("이미 곡이 있습니다");
		}
		System.out.println(musicList);
	}
	
	//재생 목록에 음악 제거
	public void removeMusicList(Music m) {
		//음악이 재생목록에 있다면 제거
		if(musicList.contains(m)) {
			musicList.remove(m);
			System.out.println(m.getMusicName() + "이 재생목록에 제거되었습니다..");
		}
		else {
			System.out.println("곡이 없습니다.");
		}
		System.out.println(musicList);
	}
	
	//재생 목록 불러오기
	public List<Music> getMusicList(){
		System.out.println(musicList);
		return this.musicList;
	}
	
	//6. 특정곡이 있는지 검사하는 메소드 : 복수개의 결과가 나올수 있음. 
//	(곡명일부로 검색해서 해당곡이 있다면, 곡정보(제목/가수)를 출력하고, 없다면, "검색결과가 없습니다"출력)
//	+ searchMusicByTitle(String title) : List<Music>
	public List<Music> searchMusicByTitle(String title) {
    List<Music> list = new ArrayList<>();
		for(int i=0; i<musicList.size(); i++) {
			String oldTitle = musicList.get(i).getMusicName();
			outer :
			for(int j=0; j<=(oldTitle.length()-title.length()); j++) {
				if(title.charAt(0) == oldTitle.charAt(j)) {
					int count=0;
					for(int x=0; x<title.length(); x++) {
						if(title.charAt(x) == oldTitle.charAt(j+x)) {
							count++;
							if(count == title.length()) {
								list.add(musicList.get(i));
								break outer;
							}
						}
					}	
				}
			}	
	}	
		if(list.size() == 0) System.out.println("검색 결과가 없습니다.");
		return list;
	}
//	7. 가수명으로 검색 메소드 : 복수개의 결과가 나올수 있음.
//	+ searchMusicBySinger(String singer) : List<Music>
	public List<Music> searchMusicBySinger(String singer) {
		List<Music> list = new ArrayList<>();
		int num=0;
		for(int i=num; i<musicList.size(); i++) {
			if(musicList.get(i).getMusicSinger().equals(singer)) {
				list.add(musicList.get(i));
				num = i+1;
			}
		}
		if(list.size() == 0) System.out.println("검색 결과가 없습니다.");
		return list;
	}
}
