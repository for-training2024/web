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

	public String getLastUploadTime(Double release_datetime) {

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
		
		if(key.equals("01")){
			resultKey = "Cメジャー";
		
		}else if(key.equals("02")){
			resultKey = "Cシャープメジャー";
			
		}else if(key.equals("03")){
			resultKey = "Dフラットメジャー";
			
		}else if(key.equals("04")){
			resultKey = "Dメジャー";
			
		}else if(key.equals("05")){
			resultKey = "Dシャープメジャー";
			
		}else if(key.equals("06")){
			resultKey = "Eフラットメジャー";
			
		}else if(key .equals("07")){
			resultKey = "Eメジャー";
			
		}else if(key.equals("08")){
			resultKey = "Fメジャー";
			
		}else if(key.equals("09")){
			resultKey = "Fシャープメジャー";
			
		}else if(key.equals("10")){
			resultKey = "Gフラットメジャー";
			
		}else if(key.equals("11")){
			resultKey = "Gメジャー";
			
		}else if(key.equals("12")){
			resultKey = "Gシャープメジャー";
			
		}else if(key.equals("13")){
			resultKey = "Aフラットメジャー";
			
		}else if(key.equals("14")){
			resultKey = "Aメジャー";
			
		}else if(key.equals("15")){
			resultKey = "Aシャープメジャー";
		
		}else if(key.equals("16")){
			resultKey = "Bフラットメジャー";
			
		}else if(key.equals("17")){
			resultKey = "Bメジャー";
			
		}else if(key.equals("18")){
			resultKey = "Cマイナー";
			
		}else if(key.equals("19")){
			resultKey = "Cシャープマイナー";
			
		}else if(key.equals("20")){
			resultKey = "Dフラットマイナー";
			
		}else if(key.equals("21")){
			resultKey = "Dマイナー";
			
		}else if(key.equals("22")){
			resultKey = "Dシャープマイナー";
			
		}else if(key.equals("23")){
			resultKey = "Eフラットマイナー";
			
		}else if(key.equals("24")){
			resultKey = "Eマイナー";
			
		}else if(key.equals("25")){
			resultKey = "Eシャープマイナー";
			
		}else if(key.equals("26")){
			resultKey = "Fシャープマイナー";
			
		}else if(key.equals("27")){
			resultKey = "Gフラットマイナー";
			
		}else if(key.equals("28")){
			resultKey = "Gマイナー";
			
		}else if(key.equals("29")){
			resultKey = "Gシャープマイナー";
			
		}else if(key.equals("30")){
			resultKey = "Aフラットマイナー";
			
		}else if(key.equals("31")){
			resultKey = "Aマイナー";
			
		}else if(key.equals("32")){
			resultKey = "Aシャープマイナー";
			
		}else if(key.equals("33")){
			resultKey = "Bフラットマイナー";
			
		}else if(key.equals("34")){
			resultKey = "Bマイナー";
			
		}
		return resultKey;
	}
	
	//楽譜表記をコード値の内容に変換して返す。
	public static String isScore_type(String score_type){
	
		String resultScore_type = null;
		
		if(score_type.equals("0")){
			resultScore_type = "楽譜通り";
		
		}else if(score_type.equals("1")){
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
		
		if(gender.equals("1")){
			resultGender = "男";
			
		}else if(gender.equals("2")){
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
		
		if(language_type.equals("001")){
			resultLanguage_type = "英語";
			
		}else if(language_type.equals("002")){
			resultLanguage_type = "日本語";
			
		}
		return resultLanguage_type;
	}
}
