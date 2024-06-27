package jp.excd.bean;

public record SongRecord(
		
		//曲ID
		String song_id,
		
		//曲名
		String title,
		
		//作曲家ID
		String composer_id,
		
		//総感動指数
		long rating_total,
		
		//平均感動指数
		double rating_average,
		
		//再生回数
		long total_listen_count,
		
		//公開時間
		double release_datetime,
		
		//最終公開時間
		double last_update_datetime,
		
		//メッセージ
		String message,
		
		//キー
		String key,
		
		//楽譜表記
		String score_type,
		
		//BPM
		double bpm,
		
		//イメージファイル
		String imege_file_name,
		
		//イメージファイル画像高さ
		int image_file_height,
		
		//イメージファイル画像幅
		int image_file_width,
		
		//関連リンクURL
		String other_link_url,
		
		//関連リンク文字列
		String other_link_description){

}

