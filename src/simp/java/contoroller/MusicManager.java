package simp.java.contoroller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JLabel;

import simp.java.io.SetMusic;
import simp.java.modle.vo.Music;
import simp.java.thread.MusicPlay;
import simp.java.thread.MusicPlayBar;
import simp.java.view.Info;
import simp.java.view.MainFrame;
import simp.java.view.PlayPanel;
import simp.myutil.MyUtil;

//플레이어와 스레드를 컨트롤 하기 위한 클래스
public class MusicManager {
	//음악 셋 전체 목록
	public static HashSet<Music> managerMusicSet = new HashSet<>();
	//음악 리스트 재생 목록
	public static ArrayList<Music> managerMusicList = new ArrayList<>();
	//음악 재생 쓰레드
	public MusicPlay mp;
	//음악 재생바 쓰레드
	public Thread mpb = new Thread();
	
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
		mpb.interrupt();
		mpb = new Thread(new MusicPlayBar());
		mpb.start();
		MyUtil.infoChanger(MusicPlay.playMusicList.get(MusicPlay.nowMusic));
	}
	
	//다음 곡으로 가기
	public void nextMusic() {
		stopMusic();
		mp = new MusicPlay();
		mp.nowMusic++;
		mp.start();
		mpb.interrupt();
		mpb = new Thread(new MusicPlayBar());
		mpb.start();
		MyUtil.infoChanger(MusicPlay.playMusicList.get(MusicPlay.nowMusic));
	}
	
	//이전 곡으로 가기
	public void previousMusic() {
		stopMusic();
		if(mp.nowMusic == 0) {
			System.out.println("이전곡이 없습니다");
			return;
		}
		mp = new MusicPlay();
		mp.nowMusic--;
		mp.start();
		mpb.interrupt();
		mpb = new Thread(new MusicPlayBar());
		mpb.start();
		MyUtil.infoChanger(MusicPlay.playMusicList.get(MusicPlay.nowMusic));
	}
	
	//음악정지
	public void stopMusic() {
		try {
			mp.close();
			mpb.interrupt();
		} catch (NullPointerException e) {
		}
		MyUtil.infoChanger("음악 종료");
	}
	
	//음악들 폴더에서 불러와 전체목록에 저장하는 메서드
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
			MyUtil.infoChanger("곡이 추가되었습니다.");
		}
		else {
			MyUtil.infoChanger("이미 곡이 있습니다");
		}
	}
	
	//재생 목록에 음악 제거
	public void removeMusicList(Music m) {
		//음악이 재생목록에 있다면 제거
		if(managerMusicList.contains(m)) {
			managerMusicList.remove(m);
			MyUtil.infoChanger("곡이 제거 되었습니다.");
		}
		else {
			MyUtil.infoChanger("곡이 없습니다.");
		}
	}
	
	//재생 목록 불러오기
	public List<Music> getMusicList(){
		return this.managerMusicList;
	}
	
	//6. 특정곡이 있는지 검사하는 메소드 : 복수개의 결과가 나올수 있음. 
//	(곡명일부로 검색해서 해당곡이 있다면, 곡정보(제목/가수)를 출력하고, 없다면, "검색결과가 없습니다"출력)
//	+ searchMusicByTitle(String title) : List<Music>
	public List<Music> searchMusicByTitle(String title) {
		//셋 형식을 리스트 형식으로 바꿔줌
		List<Music> searchList = new ArrayList<>(managerMusicSet);
		//검색 결과물 리스트
		List<Music> list = new ArrayList<>();
		//리스트에서 하나씩 검사하는 for문
		for(int i=0; i<searchList.size(); i++) {
			//검사할 곡의 제목을 저장
			String oldTitle = searchList.get(i).getMusicName();
			//검사할 곡의 제목이 검사할 내용인 title을 포함하는지 확인
			if(oldTitle.contains(title)) {
				list.add(searchList.get(i));
			}
			//위의 코드로 수정
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
		if(list.size() == 0) MyUtil.infoChanger("찾으시는 곡이 없습니다.");
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
		//위의 코드로 수정
//		int num=0;
//		for(int i=num; i<searchList.size(); i++) {
//			if(searchList.get(i).getMusicSinger().equals(singer)) {
//				list.add(searchList.get(i));
//				num = i+1;
//			}
//		}
		if(list.size() == 0) MyUtil.infoChanger("찾으시는 곡이 없습니다.");
		return list;
	}
	
	//음악 재생 리스트 섞기
	public List<Music> shuffleMusicList(){
		
		//기본 메서드를 이용하여 셔플함
		Collections.shuffle(managerMusicList);
		
		MyUtil.infoChanger("셔플 완료");
		return managerMusicList;
	}
	
	//음악 재생 리스트 제목 정렬
	public List<Music> sortMusicList(){
		
		//커스텀 메서드를 이용하여 정렬함
		Comparator<Music> comp = new MusicNameAscending();
		Collections.sort(managerMusicList, comp);
		
		MyUtil.infoChanger("정렬 완료");
		return managerMusicList;
	}
}
