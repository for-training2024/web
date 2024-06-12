package jp.excd.bean;

public class SongBean {
	
	//曲ID
	private String song_id;
	
	//曲名
	private String title;
	
	//作曲家ID
	private String composer_id;
	
	//総感動指数
	private String rating_total_formated;
	
	//平均感動指数
	private String rating_average_formated;
	
	//再生回数
	private String total_listen_count_formated;
	
	//公開時間
	private String release_datetime_formated;
	
	//最終更新時間
	private String last_update_datetime_formated;
	
	//メッセージ
	private String message;
	
	//キー
	private String key_formated;
	
	//楽譜表記
	private String score_type_formated;
	
	//BPM
	private String bpm;
	
	//イメージファイル名
	private String image_file_name;
	
	//イメージファイル画像高さ
	private int image_file_height;
	
	//イメージファイル画像幅
	private int image_file_width;
	
	//関連リンク
	private String other_link_url;
	
	//関連リンク文字列
	private String other_link_description;
	
	
	//曲ID
	public String getSong_id() {
		return song_id;
	}
	
	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}
	
	//曲名
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	//作曲家ID
	public String getComposer_id() {
		return composer_id;
	}
	
	public void setComposer_id(String composer_id) {
		this.composer_id = composer_id;
	}
	
	//総感動指数
	public String getRating_total_formated() {
		return rating_total_formated;
	}
	
	public void setRating_total_forated(String rating_total_formated) {
		this.rating_total_formated = rating_total_formated;
	}
	
	//平均感動指数
	public String getRating_average_formated() {
		return rating_average_formated;
	}
	
	public void setRating_average_formated(String rating_average_formated) {
		this.rating_average_formated = rating_average_formated;
	}
	
	//再生回数
	public String getTotal_listen_count_formated() {
		return total_listen_count_formated;
	}
	
	public void setTotal_listen_count_formated(String total_listen_count_formated) {
		this.total_listen_count_formated = total_listen_count_formated;
	}
	
	//公開時間
	public String getRelease_datetime_formated() {
		return release_datetime_formated;
	}
	
	public void setRelease_datetime_formated(String release_datetime_formated) {
		this.release_datetime_formated = release_datetime_formated;
	}
	
	//最終更新時間
	public String getLast_update_datetime_formated() {
		return last_update_datetime_formated;
	}
	
	public void setLast_update_datetime_formated(String last_update_datetime_formated) {
		this.last_update_datetime_formated = last_update_datetime_formated;
	}
	
	//メッセージ
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	//キー
	public String getKey_formated() {
		return key_formated;
	}
	
	public void setKey_formated(String key_formated) {
		this.key_formated = key_formated;
	}
	
	//楽譜表記
	public String getScore_type_formated() {
		return score_type_formated;
	}
	
	public void setScore_type_formated(String score_type_formated) {
		this.score_type_formated = score_type_formated;
	}
	
	//BPM
	public String getBpm() {
		return bpm;
	}
	
	public void setBpm(String bpm) {
		this.bpm = bpm;
	}
	
	//イメージファイル名
	public String getImage_file_name() {
		return image_file_name;
	}
	
	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}
	
	//イメージファイル画像高さ
	public int getImage_file_height() {
		return image_file_height;
	}
	
	public void setImage_file_height(int image_file_height) {
		this.image_file_height = image_file_height;
	}
	
	//イメージファイル画像幅
	public int getImage_file_width() {
		return image_file_width;
	}
	
	public void setImage_file_width(int image_file_width) {
		this.image_file_width = image_file_width;
	}
	
	//関連リンクURL
	public String getOther_link_url() {
		return other_link_url;
	}
	
	public void setOther_link_url(String other_link_url) {
		this.other_link_url = other_link_url;
	}
	
	//関連リンク文字列
	public String getOther_link_description() {
		return other_link_description;
	}
	
	public void setOther_link_description(String other_link_description) {
		this.other_link_description = other_link_description;
	}
}
