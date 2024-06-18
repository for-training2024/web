package jp.excd.bean;

public class ExSongBean extends SongBean{
	
	private String unique_code;
	private String nickname;
	
	public void setunique_code(String unique_code) {
		this.unique_code = unique_code;
	}
	public void setnickname(String nickname) {
		this.nickname = nickname;
	}
	public String getunique_code() {
		return unique_code;
	}
	public String getnickname() {
		return nickname;
	}
}
