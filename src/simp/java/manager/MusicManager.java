package simp.java.manager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

import simp.java.music.player.MusicPlay;
import simp.java.music.vo.Music;

public class MusicManager {
	ArrayList<Music> musicList = new ArrayList<>();
	MusicPlay mp = new MusicPlay("Far_Apart.mp3");
	
	public MusicManager() {
		setMusicList();
	}

	public void playMusic() {
		//다시 초기화 하지 않으면 illegalthreadstateexception 오류가 나타난다.
		mp = new MusicPlay("Far_Apart.mp3");
		mp.start();
	}
	
	public void stopMusic() {
		mp.close();
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
}
