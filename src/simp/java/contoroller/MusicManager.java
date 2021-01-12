package simp.java.contoroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

import simp.java.io.MultiPlay;
import simp.java.io.MusicPlayer;
import simp.java.io.SinglePlay;
import simp.java.music.vo.Music;

public class MusicManager {
	//음악 리스트 출력용
	public static ArrayList<Music> musicList = new ArrayList<>();
	//음악 셋 재생용
	public static HashSet<Music> musicSet = new HashSet<>();
	SinglePlay sp = new SinglePlay();
	MultiPlay mp;
	
	public MusicManager() {
		setMusicList();
	}
	
	public void playMusicMulty(Collection<Music> c) {
		mp = new MultiPlay(c);
		mp.start();
	}

	public void playMusic(Music m) {
		//다시 초기화 하지 않으면 illegalthreadstateexception 오류가 나타난다.
		sp = new SinglePlay(new MusicPlayer(m));
		sp.start();
	}
	
	public void stopMusic() {
		sp.close();
//		mp.close();
	}
	
	//음악 리스트 폴더에서 불러오기 나중에 자세히 보자
	public void setMusicList() {
		File fs = new File("Music");
		//isDirectory가 무엇일까?
		if(fs.isDirectory()) {
			File list[] = fs.listFiles();
			for(File f : list) {
				try {
					//mp3 파일 정보를 위해...
					MP3File mp3 = (MP3File) AudioFileIO.read(f);
					//태그를 이용해 정보 불러오기
					AbstractID3v2Tag tag2 = mp3.getID3v2Tag();
                    Tag tag = mp3.getTag();
                    
                    String musicName = tag.getFirst(FieldKey.TITLE);
                    String musicSinger = tag.getFirst(FieldKey.ARTIST);
                    String genre = tag.getFirst(FieldKey.GENRE);
                    int playTime = mp3.getAudioHeader().getTrackLength();
                    String releaseYear = tag.getFirst(FieldKey.YEAR);
                    
                    musicList.add(new Music(musicName, musicSinger, genre, playTime, releaseYear));
				} catch (CannotReadException
						| IOException 
						| TagException 
						| ReadOnlyFileException
						| InvalidAudioFrameException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public ArrayList<Music> getMusicList() {
		return this.musicList;
	}
	
	public void addMusicSet(Music m) {
		musicSet.add(m);
		System.out.println(m.getMusicName() + "이 재생목록에 추가되었습니다.");
	}
	
	public void removeMusicSet(Music m) {
		musicSet.remove(m);
		System.out.println(m.getMusicName() + "이 재생목록에 제거되었습니다..");
	}
	
	public HashSet<Music> getMusicSet(){
		Iterator iter = musicSet.iterator();
		while(iter.hasNext()) {
			Music m = (Music) iter.next();
		}
		return this.musicSet;
	}
}
