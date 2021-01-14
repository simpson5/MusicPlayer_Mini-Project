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

import simp.java.music.vo.Music;

public class SetMusic {
	public SetMusic(String folderName, Set<Music> musicSet) {
		File fs = new File(folderName);
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
                    
                    musicSet.add(new Music(musicName, musicSinger, genre, playTime, releaseYear));
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
