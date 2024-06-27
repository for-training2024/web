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
		
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat format2 = new SimpleDateFormat("YYYY/MM/DD");
		DateFormat format3 = new SimpleDateFormat("YYYYMMDD");

		try {
			if (value.indexOf("-") == 5 ) {
				format1.parse(value);
				return true;
			} else if (value.indexOf("/") == 5 ) {
				format2.parse(value);
				return true;
			} else {
				format3.parse(value);
				return true;
			}
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
			return false; 
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
			return false; 
		}
	}
}