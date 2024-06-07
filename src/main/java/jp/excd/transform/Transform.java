package jp.excd.transform;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Transform {

	//日付として妥当な値かどうか判定する。返り値はtrueかfalse
	public static boolean isDateValue (String value) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			format.parse(value);
			return true;

		} catch (ParseException e) {
			return false;

		}

	}

	//数値として妥当な値かどうか判定する。返り値はtrueかfalse
	public static boolean isNumber(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false; // エラーにならないように、とりあえずダミー
		}
	}

	//数値として妥当な値かどうか判定する。返り値はtrueかfalse
	public static boolean isDouble(String num) {
		try {
			Double.parseDouble(num);
			return true;
		} catch (NumberFormatException e) {
			return false; // エラーにならないように、とりあえずダミー
		}
	}
	
	//カンマ編集
	public static String isComma (long number) {
		String ret = String.format("%,d", number);
		return ret;
	}
	
	//四捨五入で、少数第一まで表示
	public static String isMin (double number) {
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

}
