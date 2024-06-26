package jp.excd.bean;

public class CommentRatingRecord {

	private int comment_id;
	private int comment_song_id;
	private int comment_sequence;
	private int comment_composer_id;
	private String comment_comment;
	private int comment_type;
	private int comment_to_comment_id;
	private double comment_write_datetime;
	private double rating_rating;
	private String composer_unique_code;
	private String composer_nickname;
	
	

	/**
	 * @return comment_id
	 */
	public int getcomment_id() {
		return comment_id;
	}
	/**
	 * @param comment_id セットする comment_id
	 */
	public void setcomment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	
	
	
	/**
	 * @return comment_song_id
	 */
	public int getcomment_song_id() {
		return comment_song_id;
	}
	/**
	 * @param comment_song_id セットする comment_song_id
	 */
	public void setcomment_song_id(int comment_song_id) {
		this.comment_song_id = comment_song_id;
	}
	
	
	
	
	/**
	 * @return comment_sequence
	 */
	public int getcomment_sequence() {
		return comment_sequence;
	}
	/**
	 * @param comment_sequence セットする comment_sequence
	 */
	public void setcomment_sequence(int comment_sequence) {
		this.comment_sequence = comment_sequence;
	}
	
	
	
	
	
	/**
	 * @return comment_composer_id
	 */
	public int getcomment_composer_id() {
		return comment_composer_id;
	}
	/**
	 * @param comment_composer_id セットする comment_composer_id
	 */
	public void setcomment_composer_id(int comment_composer_id) {
		this.comment_composer_id = comment_composer_id;
	}
	
	
	
	
	/**
	 * @return comment_comment
	 */
	public String getcomment_comment() {
		return comment_comment;
	}
	/**
	 * @param comment_comment セットする comment_comment
	 */
	public void setcomment_comment(String comment_comment) {
		this.comment_comment = comment_comment;
	}
	
	
	
	
	/**
	 * @return comment_type
	 */
	public int getcomment_type() {
		return comment_type;
	}
	/**
	 * @param comment_type セットする comment_type
	 */
	public void setcomment_type(int comment_type) {
		this.comment_type = comment_type;
	}
	
	
	
	/**
	 * @return comment_to_comment_id
	 */
	public int getcomment_to_comment_id() {
		return comment_to_comment_id;
	}
	/**
	 * @param comment_to_comment_id セットする comment_to_comment_id
	 */
	public void setcomment_to_comment_id(int comment_to_comment_id) {
		this.comment_to_comment_id = comment_to_comment_id;
	}
	
	
	
	/**
	 * @return comment_write_datetime
	 */
	public double getcomment_write_datetime() {
		return comment_write_datetime;
	}
	/**
	 * @param comment_write_datetime セットする comment_write_datetime
	 */
	public void setcomment_write_datetime(double comment_write_datetime) {
		this.comment_write_datetime = comment_write_datetime;
	}
	
	
	
	/**
	 * @return rating_rating
	 */
	public double getrating_rating() {
		return rating_rating;
	}
	/**
	 * @param rating_rating セットする rating_rating
	 */
	public void setrating_rating(double rating_rating) {
		this.rating_rating = rating_rating;
	}
	
	
	
	
	
	
	
	
	
	/**
	 * @return composer_unique_code
	 */
	public String getcomposer_unique_code() {
		return composer_unique_code;
	}
	/**
	 * @param composer_unique_code セットする composer_unique_code
	 */
	public void setcomposer_unique_code(String composer_unique_code) {
		this.composer_unique_code = composer_unique_code;
	}

	/**
	 * @return composer_nickname
			 */
	public String getcomposer_nickname() {
		return composer_nickname;
	}
	/**
	 * @param composer_nickname セットする composer_nickname
	 */
	public void setcomposer_nickname(String composer_nickname) {
		this.composer_nickname = composer_nickname;
	}

}
