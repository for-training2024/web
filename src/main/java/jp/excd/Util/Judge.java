package jp.excd.Util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Judge {

	/**
	 * 日付として妥当な値かどうか判定する。返り値はtrueかfalse
	 * @param value チェック対象値
	 * @return
	 */
	public static boolean isDateValue (String value) {
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		try {
			format.parse(value);
			return true;

		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * 数値として妥当な値かどうか判定する。返り値はtrueかfalse
	 * @param num チェック対象値
	 * @return
	 */
	public static boolean isNumber(String num) {
		
		try {
			Integer.parseInt(num);
			return true;
			
		} catch (NumberFormatException e) {
			return false; // エラーにならないように、とりあえずダミー
		}
	}

	/**
	 * 数値として妥当な値かどうか判定する。返り値はtrueかfalse
	 * @param num チェック対象値
	 * @return
	 */
	public static boolean isDouble(String num) {
		
		try {
			Double.parseDouble(num);
			return true;
			
		} catch (NumberFormatException e) {
			return false; // エラーにならないように、とりあえずダミー
		}
	}
}