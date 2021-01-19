package simp.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;

import simp.java.modle.vo.Music;

//폴더에 존재하는 mp3 파일을 가져와서 객체로 저장해주는 클래스
public class SetMusic {
	//폴더이름과 객체로 저장할 곳
	public SetMusic(String folderName, Set<Music> musicSet) {
		//폴더 클래스
		File fs = new File(folderName);
		//isDirectory >> 경로가 폴더인지 확인
		if(fs.isDirectory()) {
			//listFiles() >> 폴더 안에 파일 목록을 File 배열로 반환
			File list[] = fs.listFiles();
			//forEach 문으로 파일을 하나씩 검사
			for(File f : list) {
				try {
					//파일을 mp3 mp3파일로 변환하여 객체로 만듦
					//jaudiotagger 라이브러리 사용한 부분
					MP3File mp3 = (MP3File) AudioFileIO.read(f);
					//태그를 이용해 정보 불러오기
//					AbstractID3v2Tag tag2 = mp3.getID3v2Tag();
					//해당 mp3 파일에 태그를 불러옴
					//jaudiotagger 라이브러리 사용한 부분
                    Tag tag = mp3.getTag();
                    
                    //부러온 태그를 바탕으로 Music 객체를 생성한다.
                    String musicName = tag.getFirst(FieldKey.TITLE);
                    String musicSinger = tag.getFirst(FieldKey.ARTIST);
                    String genre = tag.getFirst(FieldKey.GENRE);
                    //단위는 초
                    int playTime = mp3.getAudioHeader().getTrackLength();
                    String releaseYear = tag.getFirst(FieldKey.YEAR);
                    
                    musicSet.add(new Music(musicName, musicSinger, genre, playTime, releaseYear));
				
                //많은 예외들 ...
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
}
