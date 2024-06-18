package jp.excd.bean;

public class ComposerBean {
	
	//プロパティ宣言
	//作曲家ID
	private String composer_id;
	
	//ユニーク名
	private String unique_code;
	
	//ニックネーム
	private String nickname;
	
	//登録日
	private String joined_date_formated;
	
	//性別
	private String gender_formated;
	
	//誕生日
	private String birthday_formated;
	
	//リスナー数
	private String listener_count_formated;
	
	//言語
	private String language_type;
	
	//メッセージ
	private String message;
	
	//FaceBookリンク
	private String fb_link;
	
	//Twitterリンク
	private String tw_link;
	
	//関連リンクURL
	private String other_link_url;
	
	//関連リンク文字列
	private String other_link_description;
	
	//コンストラクタ生成
	//作曲家ID
	public String getcomposer_id() {
		return composer_id;
	}
	
	public void setcomposer_id(String composer_id) {
		this.composer_id = composer_id;
	}
	
	//ユニーク名
	public String getunique_code() {
		return unique_code;
	}
	
	public void setunique_code(String unique_code) {
		this.unique_code = unique_code;
	}
	
	//ニックネーム
	public String getnickname() {
		return nickname;
	}
	
	public void setnickname(String nickname) {
		this.nickname = nickname;
	}
	
	//登録日
	public String getjoined_date_formated() {
		return joined_date_formated;
	}
	
	public void setjoined_date_formated(String joined_date_formated) {
		this.joined_date_formated = joined_date_formated;
	}
	
	//性別
	public String getgender_formated() {
		return gender_formated;
	}
	
	public void setgender_formated(String gender_formated) {
		this.gender_formated = gender_formated;
	}
	
	//誕生日
	public String getbirthday_formated() {
		return birthday_formated;
	}
	
	public void setbirthday_formated(String birthday_formated) {
		this.birthday_formated = birthday_formated;
	}
	
	//リスナー数
	public String getlistener_count_formated() {
		return listener_count_formated;
	}
	
	public void setlistener_count_formated(String listener_count_formated) {
		this.listener_count_formated = listener_count_formated;
	}
	
	//言語
	public String getlanguage_type() {
		return language_type;
	}
	
	public void setlanguage_type(String language_type) {
		this.language_type = language_type;
	}
	
	//メッセージ
	public String getmessage() {
		return message;
	}
	
	public void setmessage(String message) {
		this.message = message;
	}
	
	//FaceBookリンク
	public String getfb_link() {
		return fb_link;
	}
	
	public void setfb_link(String fb_link) {
		this.fb_link = fb_link;
	}
	
	//Twitterリンク
	public String gettw_link() {
		return tw_link;
	}
	
	public void settw_link(String tw_link) {
		this.tw_link = tw_link;
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

}