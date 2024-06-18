package jp.excd.transform;

import java.text.NumberFormat;
import java.util.Date;

public class Transform {

	//カンマ編集
	public static String isComma (long number) {
		String ret = String.format("%,d", number);
		return ret;
	}
	
	//四捨五入で、少数第一まで表示
	public static String isThree (double number) {
		double roundedNumber = Math.round(number * 10.0) / 10.0;
        return String.format("%.1f", roundedNumber);
	}

	public static String getLastUploadTime(Double release_datetime) {

		String resultVal;
		double d_releaseDay = 0;

		//現在のエポック秒を取得
		Date date = new Date();
		Double nowEpoch = (double) date.getTime();

		//差分を算出
		Double diff = nowEpoch - release_datetime * 1000;

		//小数点以下を切り捨てる処理
		NumberFormat numberFormat = NumberFormat.getInstance();
		numberFormat.setMaximumFractionDigits(0);

		//公開時間を取得
		//1秒未満
		if (diff < 1000) {
			resultVal = "たった今";

		}
		//1秒以上かつ2秒未満
		else if (diff < 2000) {
			resultVal = "1秒前";

		}
		//2秒以上かつ60秒未満
		else if (diff < 60000) {
			resultVal = diff + "秒前";

		}
		//1分以上かつ2分未満
		else if (diff < 120000) {
			resultVal = "1分前";

		}
		//2分以上かつ60分未満
		else if (diff < 3600000) {
			d_releaseDay = (diff / 60000);
			resultVal = numberFormat.format(d_releaseDay) + "分前";

		}
		//1時間以上かつ2時間未満
		else if (diff < 7200000) {
			resultVal = "1時間前";

		}
		//2時間以上かつ24時間未満
		else if (diff < 86400000) {
			d_releaseDay = (diff / 3600000);
			resultVal = numberFormat.format(d_releaseDay) + "時間前";

		}
		//1日以上かつ2日未満
		else if (diff < 172800000) {
			resultVal = "1日前";

		}
		//2日以上かつ7日未満
		else if (diff < 604800000) {
			d_releaseDay = (diff / 86400000);
			resultVal = numberFormat.format(d_releaseDay) + "日前";

		}
		//7日以上かつ14日未満
		else if (diff < 1209600000) {
			resultVal = "1週間前";

		}
		//14日以上かつ30日未満
		else if (diff < 2592000000L) {
			d_releaseDay = (diff / 604800000);
			resultVal = numberFormat.format(d_releaseDay) + "週間前";

		}
		//30日以上かつ60日未満
		else if (diff < 5184000000L) {
			resultVal = "1ヶ月前";

		}
		//60日以上かつ365日未満
		else if (diff < 31536000000L) {
			d_releaseDay = (diff / 2592000000L);
			resultVal = numberFormat.format(d_releaseDay) + "ヶ月前";

		}
		//1年以上かつ2年未満
		else if (diff < 63072000000L) {
			resultVal = "1年前";

		}
		//2年以上
		else {
			d_releaseDay = (diff / 31536000000L);
			resultVal = numberFormat.format(d_releaseDay) + "年前";

		}
		return resultVal;
	}
	
	//キーをコード値の内容に変換して返す。
	public static String isKey(String key){
		
		String resultKey = null;
		
		if("01".equals(key)){
			resultKey = "Cメジャー";
		
		}else if("02".equals(key)){
			resultKey = "Cシャープメジャー";
			
		}else if("03".equals(key)){
			resultKey = "Dフラットメジャー";
			
		}else if("04".equals(key)){
			resultKey = "Dメジャー";
			
		}else if("05".equals(key)){
			resultKey = "Dシャープメジャー";
			
		}else if("06".equals(key)){
			resultKey = "Eフラットメジャー";
			
		}else if("07".equals(key)){
			resultKey = "Eメジャー";
			
		}else if("08".equals(key)){
			resultKey = "Fメジャー";
			
		}else if("09".equals(key)){
			resultKey = "Fシャープメジャー";
			
		}else if("10".equals(key)){
			resultKey = "Gフラットメジャー";
			
		}else if("11".equals(key)){
			resultKey = "Gメジャー";
			
		}else if("12".equals(key)){
			resultKey = "Gシャープメジャー";
			
		}else if("13".equals(key)){
			resultKey = "Aフラットメジャー";
			
		}else if("14".equals(key)){
			resultKey = "Aメジャー";
			
		}else if("15".equals(key)){
			resultKey = "Aシャープメジャー";
		
		}else if("16".equals(key)){
			resultKey = "Bフラットメジャー";
			
		}else if("17".equals(key)){
			resultKey = "Bメジャー";
			
		}else if("18".equals(key)){
			resultKey = "Cマイナー";
			
		}else if("19".equals(key)){
			resultKey = "Cシャープマイナー";
			
		}else if("20".equals(key)){
			resultKey = "Dフラットマイナー";
			
		}else if("21".equals(key)){
			resultKey = "Dマイナー";
			
		}else if("22".equals(key)){
			resultKey = "Dシャープマイナー";
			
		}else if("23".equals(key)){
			resultKey = "Eフラットマイナー";
			
		}else if("24".equals(key)){
			resultKey = "Eマイナー";
			
		}else if("25".equals(key)){
			resultKey = "Eシャープマイナー";
			
		}else if("26".equals(key)){
			resultKey = "Fシャープマイナー";
			
		}else if("27".equals(key)){
			resultKey = "Gフラットマイナー";
			
		}else if("28".equals(key)){
			resultKey = "Gマイナー";
			
		}else if("29".equals(key)){
			resultKey = "Gシャープマイナー";
			
		}else if("30".equals(key)){
			resultKey = "Aフラットマイナー";
			
		}else if("31".equals(key)){
			resultKey = "Aマイナー";
			
		}else if("32".equals(key)){
			resultKey = "Aシャープマイナー";
			
		}else if("33".equals(key)){
			resultKey = "Bフラットマイナー";
			
		}else if("34".equals(key)){
			resultKey = "Bマイナー";
			
		}
		return resultKey;
	}
	
	//楽譜表記をコード値の内容に変換して返す。
	public static String isScore_type(String score_type){
	
		String resultScore_type = null;
		
		if("0".equals(score_type)){
			resultScore_type = "楽譜通り";
		
		}else if("1".equals(score_type)){
			resultScore_type = "1オクターブ上で表記";
			
		}
		return resultScore_type;
	}
	
	//登録日を[yyyy年MM月dd日]で返す。
	public static String isDate(String joined_date){
		
		StringBuilder joined = new StringBuilder(joined_date);
		StringBuilder date = (joined.insert(4, "年").insert(7, "月").insert(10,"日"));
		String resultDate = date.toString();
		return resultDate;
	}
	
	//性別を「男」もしくは「女」と日本語で返す。nullの場合は""（空白）を返す。
	public static String isGender(String gender){
	
		String resultGender = null;
		
		if("1".equals(gender)){
			resultGender = "男";
			
		}else if("2".equals(gender)){
			resultGender = "女";
			
		}else{
			resultGender = "";
		
		}
		return resultGender;
	}
	
	//誕生日を[yyyy/MM/dd]で返す。
	public static String isBirthday(String birthday){
	
		StringBuilder sb = new StringBuilder(birthday);
		StringBuilder SB = (sb.insert(4, "/").insert(7, "/"));
		String resultBirthday = SB.toString();
		return resultBirthday;
	}
	
	//言語を「日本語」もしくは「英語」と日本語で返す。
	public static String isLanguage_type(String language_type){
	
		String resultLanguage_type = null;
		
		if("001".equals(language_type)){
			resultLanguage_type = "英語";
			
		}else if("002".equals(language_type)){
			resultLanguage_type = "日本語";
			
		}
		return resultLanguage_type;
	}
}