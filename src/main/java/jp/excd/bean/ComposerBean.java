package jp.excd.bean;

public class ComposerBean {
	

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
	

	
	//作曲家ID
	public String getComposer_id() {
		return composer_id;
	}
	
	public void setComposer_id(String composer_id) {

		this.composer_id = composer_id;
	}
	
	//ユニーク名

	public String getUnique_code() {
		return unique_code;
	}
	
	public void setUnique_code(String unique_code) {

		this.unique_code = unique_code;
	}
	
	//ニックネーム

	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {

		this.nickname = nickname;
	}
	
	//登録日

	public String getJoined_date_formated() {
		return joined_date_formated;
	}
	
	public void setJoined_date_formated(String joined_date_formated) {

		this.joined_date_formated = joined_date_formated;
	}
	
	//性別

	public String getGender_formated() {
		return gender_formated;
	}
	
	public void setGender_formated(String gender_formated) {

		this.gender_formated = gender_formated;
	}
	
	//誕生日

	public String getBirthday_formated() {
		return birthday_formated;
	}
	
	public void setBirthday_formated(String birthday_formated) {

		this.birthday_formated = birthday_formated;
	}
	
	//リスナー数

	public String getListener_count_formated() {
		return listener_count_formated;
	}
	
	public void setListener_count_formated(String listener_count_formated) {

		this.listener_count_formated = listener_count_formated;
	}
	
	//言語

	public String getLanguage_type() {
		return language_type;
	}
	
	public void setLanguage_type(String language_type) {
		this.language_type = language_type;
	}
	
	//メッセージ

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {

		this.message = message;
	}
	
	//FaceBookリンク

	public String getFb_link() {
		return fb_link;
	}
	
	public void setFb_link(String fb_link) {
		this.fb_link = fb_link;
	}
	
	//Twitterリンク
	public String getTw_link() {
		return tw_link;
	}
	
	public void setTw_link(String tw_link) {
		this.tw_link = tw_link;
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
