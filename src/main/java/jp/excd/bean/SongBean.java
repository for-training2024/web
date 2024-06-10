package jp.excd.bean;

public class SongBean {
	
	//プロパティ宣言
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
	
	
	//コンストラクタ生成
	//曲ID
	public String getsong_id() {
		return song_id;
	}
	
	public void setsong_id(String song_id) {
		this.song_id = song_id;
	}
	
	//曲名
	public String gettitle() {
		return title;
	}
	
	public void settitle(String title) {
		this.title = title;
	}
	
	//作曲家ID
	public String getcomposer_id() {
		return composer_id;
	}
	
	public void setcomposer_id(String composer_id) {
		this.composer_id = composer_id;
	}
	
	//総感動指数
	public String getrating_total_formated() {
		return rating_total_formated;
	}
	
	public void setrating_total_forated(String rating_total_formated) {
		this.rating_total_formated = rating_total_formated;
	}
	
	//平均感動指数
	public String getrating_average_formated() {
		return rating_average_formated;
	}
	
	public void setrating_average_formated(String rating_average_formated) {
		this.rating_average_formated = rating_average_formated;
	}
	
	//再生回数
	public String gettotal_listen_count_formated() {
		return total_listen_count_formated;
	}
	
	public void settotal_listen_count_formated(String total_listen_count_formated) {
		this.total_listen_count_formated = total_listen_count_formated;
	}
	
	//公開時間
	public String getrelease_datetime_formated() {
		return release_datetime_formated;
	}
	
	public void setrelease_datetime_formated(String release_datetime_formated) {
		this.release_datetime_formated = release_datetime_formated;
	}
	
	//最終更新時間
	public String getlast_update_datetime_formated() {
		return last_update_datetime_formated;
	}
	
	public void setlast_update_datetime_formated(String last_update_datetime_formated) {
		this.last_update_datetime_formated = last_update_datetime_formated;
	}
	
	//メッセージ
	public String getmessage() {
		return message;
	}
	
	public void setmessage(String message) {
		this.message = message;
	}
	
	//キー
	public String getkey_formated() {
		return key_formated;
	}
	
	public void setkey_formated(String key_formated) {
		this.key_formated = key_formated;
	}
	
	//楽譜表記
	public String getscore_type_formated() {
		return score_type_formated;
	}
	
	public void setscore_type_formated(String score_type_formated) {
		this.score_type_formated = score_type_formated;
	}
	
	//BPM
	public String getbpm() {
		return bpm;
	}
	
	public void setbpm(String bpm) {
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
	public int getimage_file_width() {
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
	
	public void setgetother_link_description(String other_link_description) {
		this.other_link_description = other_link_description;
	}
}
