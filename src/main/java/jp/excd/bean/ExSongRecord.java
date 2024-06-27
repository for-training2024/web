package jp.excd.bean;

public class ExSongRecord {

	private String song_id;
	private String title;
	private String composer_id;
	private long rating_total;
	private double rating_average;
	private long total_listen_count;
	private double release_datetime;
	private double last_update_datetime;
	private String message;
	private String key_formated;
	private String score_type;
	private double bpm;
	private String image_file_name;
	private int image_file_height;
	private int image_file_width;
	private String other_link_url;
	private String other_link_description;
	private String unique_code;
	
	private String nickname;
	
	
	public String getsong_id() {
		return song_id;
	}
	public void setsong_id(String song_id) {
		this.song_id = song_id;
	}
	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}
	public String getcomposer_id() {
		return composer_id;
	}
	public void setcomposer_id(String composer_id) {
		this.composer_id = composer_id;
	}
	public long getrating_total() {
		return rating_total;
	}
	public void setrating_total(long rating_total) {
		this.rating_total = rating_total;
	}
	public double getrating_average() {
		return rating_average;
	}
	public void setrating_average(double rating_average) {
		this.rating_average = rating_average;
	}
	public long gettotal_listen_count() {
		return total_listen_count;
	}
	public void settotal_listen_count(long total_listen_count) {
		this.total_listen_count = total_listen_count;
	}
	public double getrelease_datetime() {
		return release_datetime;
	}
	public void setrelease_datetime(double release_datetime) {
		this.release_datetime = release_datetime;
	}
	public double getlast_update_datetime() {
		return last_update_datetime;
	}
	public void setlast_update_datetime(double last_update_datetime) {
		this.last_update_datetime = last_update_datetime;
	}
	public String getmessage() {
		return message;
	}
	public void setmessage(String message) {
		this.message = message;
	}
	public String getkey() {
		return key_formated;
	}
	public void setkey(String key_formated) {
		this.key_formated = key_formated;
	}
	public String getscore_type() {
		return score_type;
	}
	public void setscore_type(String score_type) {
		this.score_type = score_type;
	}
	//BPM
	public double getbpm() {
		return bpm;
	}
	public void setbpm(double bpm) {
		this.bpm = bpm;
	}
	//イメージファイル名
	public String getimage_file_name() {
		return image_file_name;
	}
	public void setimage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}
	//イメージファイル画像高さ
	public int getimage_file_height() {
		return image_file_height;
	}
	public void setimage_file_height(int image_file_height) {
		this.image_file_height = image_file_height;
	}
	//イメージファイル画像幅
	public  int getimage_file_width() {
		return image_file_width;
	}
	public void setimage_file_width(int image_file_width) {
		this.image_file_width = image_file_width;
	}
	//関連リンクURL
	public String getother_link_url() {
		return other_link_url;
	}
	public void setother_link_url(String other_link_url) {
		this.other_link_url = other_link_url;
	}
	//関連リンク文字列
	public String getother_link_description() {
		return other_link_description;
	}
	public void setother_link_description(String other_link_description) {
		this.other_link_description = other_link_description;
	}
	public String getunique_code() {
		return unique_code;
	}
	public void setunique_code(String unique_code) {
		this.unique_code = unique_code;
	}
	public String getnickname() {
		return nickname;
	}
	public void setnickname(String nickname) {
		this.nickname = nickname;
	}
}