package simp.java.music.vo;

public class Music {
	private String musicName;
	private String musicSinger;
	private String genre;
	private long playTime;
	//private int playCnt;
	private String releaseYear;
	
	public Music(String musicName, String musicSinger, String genre, long playTime, String releaseYear) {
		super();
		this.musicName = musicName;
		this.musicSinger = musicSinger;
		this.genre = genre;
		this.playTime = playTime;
		this.releaseYear = releaseYear;
	}

	public Music() {
		// TODO Auto-generated constructor stub
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicSinger() {
		return musicSinger;
	}

	public void setMusicSinger(String musicSinger) {
		this.musicSinger = musicSinger;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getPlayTime() {
		return playTime;
	}

	public void setPlayTime(long playTime) {
		this.playTime = playTime;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return 	musicName + "\t" + musicSinger + "\t" + genre ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((musicName == null) ? 0 : musicName.hashCode());
		result = prime * result + ((musicSinger == null) ? 0 : musicSinger.hashCode());
		result = prime * result + (int) (playTime ^ (playTime >>> 32));
		result = prime * result + ((releaseYear == null) ? 0 : releaseYear.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Music other = (Music) obj;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (musicName == null) {
			if (other.musicName != null)
				return false;
		} else if (!musicName.equals(other.musicName))
			return false;
		if (musicSinger == null) {
			if (other.musicSinger != null)
				return false;
		} else if (!musicSinger.equals(other.musicSinger))
			return false;
		if (playTime != other.playTime)
			return false;
		if (releaseYear == null) {
			if (other.releaseYear != null)
				return false;
		} else if (!releaseYear.equals(other.releaseYear))
			return false;
		return true;
	}
}
