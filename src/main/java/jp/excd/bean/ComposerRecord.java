package jp.excd.bean;

public record ComposerRecord(
		
		//作曲家ID
		String composer_id,
		
		//ユニーク名
		String unique_code,
		
		//ニックネーム
		String nickname,
		
		//登録日
		String joined_date,
		
		//性別
		String gender,
		
		//誕生日
		String birthday,
		
		//リスナー数
		long listener_count,
		
		//言語
		String language_type,
		
		//メッセージ
		String message,
		
		//FaceBookリンク
		String fb_link,
		
		//Twitterリンク
		String tw_link,
		
		//関連リンクURL
		String other_link_url,
		
		//関連リンク文字列
		String other_link_description) {
}
