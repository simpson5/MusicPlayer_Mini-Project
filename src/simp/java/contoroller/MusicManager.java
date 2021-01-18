package simp.java.contoroller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import simp.java.io.SetMusic;
import simp.java.music.vo.Music;
import simp.java.thread.MusicPlay;
import simp.java.thread.MusicPlaybar;
import simp.java.view.PlayPanel;

public class MusicManager {
	//음악 셋 전체 목록
	public static HashSet<Music> managerMusicSet = new HashSet<>();
	//음악 리스트 재생 목록
	public static ArrayList<Music> managerMusicList = new ArrayList<>();
	//
	public MusicPlay mp;
	public Thread mpb;
	
	//메니저 객체 생성시 음악 저장
	public MusicManager() {
		saveMusicSet();
	}
	
	//음악재생
	public void playMusic() {
		stopMusic();
		mp.nowMusic = 0;
		mp = new MusicPlay();
		mp.start();
		mpb = new Thread(new MusicPlaybar(mp.nowMusic));
		mpb.start();
	}
	
	//음악정지
	public void nextMusic() {
		stopMusic();
		mp = new MusicPlay();
		mp.nowMusic++;
		mp.start();
	}
	
	public void previousMusic() {
		stopMusic();
		if(mp.nowMusic == 0) {
			System.out.println("이전곡이 없습니다");
			return;
		}
		mp = new MusicPlay();
		mp.nowMusic--;
		mp.start();
	}
	
	public void stopMusic() {
		try {
			mp.close();
		} catch (NullPointerException e) {
//			System.out.println("종료3");
		}
	}
	
	//음악들 폴더에서 불러오기 나중에 자세히 보자
	public void saveMusicSet() {
		new SetMusic("Music", managerMusicSet);
	}
	
	//저장된 음악(전체 목록) 불러오기
	public Set<Music> getMusicSet() {
		return this.managerMusicSet;
	}
	
	//재생 목록에 음악 추가
	public void addMusicList(Music m) {
		//음악이 재생 목록에 없다면 추가
		if(!managerMusicList.contains(m)) {
			managerMusicList.add(m);
		}
		else {
			System.out.println("이미 곡이 있습니다");
		}
	}
	
	//재생 목록에 음악 제거
	public void removeMusicList(Music m) {
		//음악이 재생목록에 있다면 제거
		if(managerMusicList.contains(m)) {
			managerMusicList.remove(m);
		}
		else {
			System.out.println("곡이 없습니다.");
		}
	}
	
	//재생 목록 불러오기
	public List<Music> getMusicList(){
//		System.out.println(musicList);
		return this.managerMusicList;
	}
	
	//6. 특정곡이 있는지 검사하는 메소드 : 복수개의 결과가 나올수 있음. 
//	(곡명일부로 검색해서 해당곡이 있다면, 곡정보(제목/가수)를 출력하고, 없다면, "검색결과가 없습니다"출력)
//	+ searchMusicByTitle(String title) : List<Music>
	public List<Music> searchMusicByTitle(String title) {
		List<Music> searchList = new ArrayList<>(managerMusicSet);
		List<Music> list = new ArrayList<>();
		for(int i=0; i<searchList.size(); i++) {
			String oldTitle = searchList.get(i).getMusicName();
			if(oldTitle.contains(title)) {
				list.add(searchList.get(i));
			}
//			outer :
//			for(int j=0; j<=(oldTitle.length()-title.length()); j++) {
//				if(title.charAt(0) == oldTitle.charAt(j)) {
//					int count=0;
//					for(int x=0; x<title.length(); x++) {
//						if(title.charAt(x) == oldTitle.charAt(j+x)) {
//							count++;
//							if(count == title.length()) {
//								list.add(musicList.get(i));
//								break outer;
//							}
//						}
//					}	
//				}
//			}
	}	
		if(list.size() == 0) System.out.println("검색 결과가 없습니다.");
		return list;
	}
//	7. 가수명으로 검색 메소드 : 복수개의 결과가 나올수 있음.
//	+ searchMusicBySinger(String singer) : List<Music>
	public List<Music> searchMusicBySinger(String singer) {
		//검색용 목록
		List<Music> searchList = new ArrayList<>(managerMusicSet);
		//검색 결과 목록
		List<Music> list = new ArrayList<>();
		for(int i=0; i<searchList.size(); i++) {
			String oldSinger = searchList.get(i).getMusicSinger();
			if(oldSinger.contains(singer)) {
				list.add(searchList.get(i));
			}
		}
//		int num=0;
//		for(int i=num; i<searchList.size(); i++) {
//			if(searchList.get(i).getMusicSinger().equals(singer)) {
//				list.add(searchList.get(i));
//				num = i+1;
//			}
//		}
		if(list.size() == 0) System.out.println("검색 결과가 없습니다.");
		System.out.println(list);
		return list;
	}
	
	//음악 재생 리스트 섞기
	public List<Music> suffleMusicList(){
		return managerMusicList;
	}
	
	//음악 재생 리스트 제목 정렬
	public List<Music> sortMusicList(){
		return managerMusicList;
	}
}
