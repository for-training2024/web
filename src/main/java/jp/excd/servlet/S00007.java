package jp.excd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.excd.Util.Judge;
import jp.excd.Util.Transform;
import jp.excd.bean.ComposerBean;
import jp.excd.bean.ComposerRecord;
import jp.excd.conponent.PlaceHolderInput;

public class S00007 extends HttpServlet {

	/** 言語：日本語*/
	private static String LANG_JP = "002";
	/** 言語：英語*/
	private static String LANG_EN = "001";

	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

		getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request, response);
	}

	public void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {

		Connection con = null;
		request.setCharacterEncoding("UTF-8");

		String dbName = "meloko";
		String userName = "meloko";
		String password = "exceed";
		String timeZone = "Asia/Tokyo";

		try {
			// (1)DB接続（コネクションの確立）
			con = MySQLSetting.getConnection(dbName, userName, password, timeZone);

			// (2)内部メソッド呼び出し
			this.mainProcessForSearch(request, response, con);

		} catch (Exception e) {
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);

		} finally {
			try {
				if (con != null) {

					// (3)接続したコネクションの切断を行う。
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();

			}

		}
	}

	private void mainProcessForSearch(HttpServletRequest request, HttpServletResponse response, Connection con)
			throws IOException, Exception {

		// 接続URL受け取り
		String URL = request.getRequestURI();

		// (1) 接続URLが「/ja/S00007/searh」以外の場合は、404.jspへフォワーディングする。
		if ("/web/ja/S00007/search".equals(URL)) {
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		}

		// POSTパラメタの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		// (2) 入力項目(POSTパラメタ)を使って、Requestオブジェクトのアトリビュートの初期化をする。
		String nickname_radio = request.getParameter("nickname_radio");
		String nickname_type_radio = request.getParameter("nickname_type_radio");
		String nickname = request.getParameter("nickname");
		String joined_date_radio = request.getParameter("joined_date_radio");
		String joined_date_from = request.getParameter("joined_date_from");
		String joined_date_to = request.getParameter("joined_date_to");
		String gender_radio = request.getParameter("gender_radio");
		String gender = request.getParameter("gender");
		String birthday_radio = request.getParameter("birthday_radio");
		String birthday_from = request.getParameter("birthday_from");
		String birthday_to = request.getParameter("birthday_to");
		String listener_count_radio = request.getParameter("listener_count_radio");
		String listener_count_from = request.getParameter("listener_count_from");
		String listener_count_to = request.getParameter("listener_count_to");
		//String []language_type_jp = request.getParameterValues("language_type_jp");
		//String []language_type_en = request.getParameterValues("language_type_en");

		String sort_order = request.getParameter("sort_order");

		String[] language_type_jp_values = request.getParameterValues("language_type_jp");
		String language_type_jp = "false";
		if (language_type_jp_values != null && language_type_jp_values.length > 0) {
			language_type_jp = "true";
		} else {
			// もし配列がnullまたは長さが0の場合、適切なデフォルト値か処理を追加
		}

		String[] language_type_en_values = request.getParameterValues("language_type_en");
		String language_type_en = "false";
		if (language_type_en_values != null && language_type_en_values.length > 0) {
			language_type_en = "true";
		} else {
			// もし配列がnullまたは長さが0の場合、適切なデフォルト値か処理を追加
		}

		//初期化
		request.setAttribute("error", null);
		request.setAttribute("nickname_is_error", null);
		request.setAttribute("nickname_radio", nickname_radio);
		request.setAttribute("nickname_type_radio", nickname_type_radio);
		request.setAttribute("nickname", nickname);
		request.setAttribute("joined_date_is_error", null);
		request.setAttribute("joined_date_radio", joined_date_radio);
		request.setAttribute("joined_date_from", joined_date_from);
		request.setAttribute("joined_date_to", joined_date_to);
		request.setAttribute("gender_is_error", null);
		request.setAttribute("gender_radio", gender_radio);
		request.setAttribute("gender", gender);
		request.setAttribute("birthday_is_error", null);
		request.setAttribute("birthday_radio", birthday_radio);
		request.setAttribute("birthday_from", birthday_from);
		request.setAttribute("birthday_to", birthday_to);
		request.setAttribute("listener_count_is_error", null);
		request.setAttribute("listener_count_radio", listener_count_radio);
		request.setAttribute("listener_count_from", listener_count_from);
		request.setAttribute("listener_count_to", listener_count_to);
		request.setAttribute("language_is_error", null);
		request.setAttribute("language_type_jp", language_type_jp);
		request.setAttribute("language_type_en", language_type_en);
		request.setAttribute("sort_order", sort_order);

		//(4) 後にエラーに関する条件分岐に利用するため、変数を用意する
		Integer lcf = null;
		Integer lct = null;
		//Integer bf = null;
		//Integer bt = null;

		// (5) ニックネームについて、以下のとおりエラー判定を行う。
		if ("1".equals(nickname_radio)) {
			if (nickname == null || "".equals(nickname)) {
				// エラー
				String s = this.getDescription(con, "ES00007_001");
				request.setAttribute("error", s);
				request.setAttribute("nickname_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
				return;
			} else {
				//処理続行
			}

		} else if (!("1".equals(nickname_radio))) {
			// 処理継続
		}

		//(6) 登録日FROMについてエラー判定を行う。
		if ("1".equals(joined_date_radio)) {
			if (joined_date_from == null || "".equals(joined_date_from)) {
				// 処理継続
			} else if (Judge.isDateValue(joined_date_from) == false) {
				// エラー
				String s = this.getDescription(con, "ES00007_002");
				request.setAttribute("error", s);
				request.setAttribute("joined_date_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
			} else {
				//処理続行
			}
		} else if (!("1".equals(joined_date_radio))) {
			// 処理継続
		}

		//(7) 登録日TOについてエラー判定を行う
		if ("1".equals(joined_date_radio)) {
			if (joined_date_to == null || "".equals(joined_date_to)) {
				// 処理継続
			} else if (Judge.isDateValue(joined_date_to) == false) {
				// エラー
				String s = this.getDescription(con, "ES00007_003");
				request.setAttribute("error", s);
				request.setAttribute("joined_date_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
			} else {
				//処理続行
			}
		} else if (!("1".equals(joined_date_radio))) {
			// 処理継続
		}

		// (8) 登録日FROM、登録日TOについてエラー判定を行う。
		if ("1".equals(joined_date_radio)) {
			if (joined_date_from == null || "".equals(joined_date_from) &&
					(joined_date_to == null || "".equals(joined_date_to))) {
				//エラー
				String s = this.getDescription(con, "ES00007_004");
				request.setAttribute("error", s);
				request.setAttribute("joined_date_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
				return;
			} else if (joined_date_from == null
					|| "".equals(joined_date_from) && Judge.isDateValue(joined_date_to) == true) {
				//処理続行
			} else if (Judge.isDateValue(joined_date_from)) {
				//処理続行
			}
		} else if (!("1".equals(joined_date_radio))) {
			// 処理継続
		}

		// (9) 登録日FROM、登録日TOについてエラー判定を行う。
		if ("1".equals(joined_date_radio)) {
			if(Judge.isDateValue(joined_date_from) == true && Judge.isDateValue(joined_date_to) == true) {
				int checkResult = joined_date_to.compareTo(joined_date_from);
				if (checkResult < 0) {
					// エラー
					String s = this.getDescription(con, "ES00007_005");
					request.setAttribute("error", s);
					request.setAttribute("joined_date_is_error", "1");
					getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
							response);
					return;
				}
			}
		} else if (!("1".equals(joined_date_radio))) {

		}

		// (10) 誕生日FROMについてエラー判定を行う。
		if ("1".equals(birthday_radio)) {
			if (birthday_from == null || "".equals(birthday_from)) {
				// 処理継続
			} else if (Judge.isDateValue(birthday_from) == false) {
				// エラー
				String s = this.getDescription(con, "ES00007_006");
				request.setAttribute("error", s);
				request.setAttribute("birthday_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
				return;
			} else if (Judge.isDateValue(birthday_from) == true) {
				//処理続行
			}
		} else if (!("1".equals(birthday_radio))) {
			// 処理続行
		}

		// (11) 誕生日TOについてエラー判定を行う。
		if ("1".equals(birthday_radio)) {
			if (birthday_to == null || "".equals(birthday_to)) {
				//処理続行
			} else if (Judge.isDateValue(birthday_to) == false) {
				//エラー
				String s = this.getDescription(con, "ES00007_007");
				request.setAttribute("error", s);
				request.setAttribute("birthday_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
				return;
			} else if (Judge.isDateValue(birthday_to) == true) {
				//処理続行
			}
		} else {
			// 処理続行
		}

		// (12) 誕生日FROM 誕生日TO についてエラー判定を行う。
		if ("1".equals(birthday_radio)) {
			if ((birthday_from == null || "".equals(birthday_from) &&
					(birthday_to == null || "".equals(birthday_to)))) {
				//エラー
				String s = this.getDescription(con, "ES00007_008");
				request.setAttribute("error", s);
				request.setAttribute("birthday_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
						response);
				return;
			} else if (birthday_from == null || "".equals(birthday_from) && Judge.isDateValue(birthday_to) == true) {
				//処理続行
			} else if (Judge.isDateValue(birthday_from) == true) {
				//処理続行
			}
		} else if (!("1".equals(birthday_radio))) {
			//処理続行
		}

		// (13) 誕生日FROM　誕生日TO（逆転チェック）
		if ("1".equals(birthday_radio)) {
			if(Judge.isDateValue("birthday from")== true && Judge.isDateValue("birthday to")== true) {
				int checkResult = birthday_to.compareTo(birthday_from);
				if (checkResult < 0) {
					//エラー
					String s = this.getDescription(con, "ES00007_009");
					request.setAttribute("error", s);
					request.setAttribute("rating_from_error", "1");
					getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request,
							response);
					return;

				}
			}
		} else if (!("1".equals(birthday_radio))) {
			//処理続行
		}

		// (14) リスナー数FROM　エラーチェック
		if ("1".equals(listener_count_radio)) {
			if (listener_count_from == null || "".equals(listener_count_from)) {
				//処理続行
			} else if (Judge.isNumber(listener_count_from) == false) {
				//エラー
				String s = this.getDescription(con, "ES00007_010");
				request.setAttribute("error", s);
				request.setAttribute("listener_count_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;

			} else {
				//処理継続
				lcf = Integer.parseInt(listener_count_from);
			}
		} else if (!("1".equals(listener_count_radio))) {
			//処理続行
		}

		// (15) リスナー数TO エラー判定を行う。
		if ("1".equals(listener_count_radio)) {
			if (listener_count_to == null || "".equals(listener_count_to)) {
				//処理継続
			} else if (Judge.isNumber(listener_count_to) == false) {
				//エラー
				String s = this.getDescription(con, "ES00007_011");
				request.setAttribute("error", s);
				request.setAttribute("listener_count_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;

			} else {
				//処理継続
				lct = Integer.parseInt(listener_count_to);
			}
		} else if (!("1".equals(listener_count_radio))) {
			//処理継続
		}

		// (16) リスナー数FROM、リスナー数TO エラー判定を行う。
		if ("1".equals(listener_count_radio)) {
			if (listener_count_from == null || "".equals(listener_count_from) &&
					(listener_count_to == null || "".equals(listener_count_to))) {
				//エラー
				String s = this.getDescription(con, "ES00007_012");
				request.setAttribute("error", s);
				request.setAttribute("listener_count_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;
			} else if (listener_count_from == null
					|| "".equals(listener_count_from) && Judge.isNumber(listener_count_to) == false) {
				//エラー
				String s = this.getDescription(con, "ES00007_012");
				request.setAttribute("error", s);
				request.setAttribute("listener_count_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;
			} else if (listener_count_from == null
					|| "".equals(listener_count_from) && Judge.isNumber(listener_count_to) == true) {
				//処理続行
			} else if (Judge.isNumber(listener_count_from) == false || Integer.parseInt(listener_count_from) < 0) {
				//エラー
				String s = this.getDescription(con, "ES00007_012");
				request.setAttribute("error", s);
				request.setAttribute("listener_count_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;

			} else if (Judge.isNumber(listener_count_from) == true) {
				//処理続行					
			}

		} else if (!("1".equals(listener_count_radio))) {
			//処理継続
		}

		// (17) リスナー数FROM　リスナー数TO エラー判定を行う。
		if ("1".equals(listener_count_radio)) {
			if (isBlank(listener_count_from) == false) {
				lcf = Integer.parseInt(listener_count_from);
			}
			if (isBlank(listener_count_to) == false) {
				lct = Integer.parseInt(listener_count_to);
			}
			if ((lcf != null && lct != null) && lcf > lct) {
				//エラー
				String s = this.getDescription(con, "ES00007_013");
				request.setAttribute("error", s);
				request.setAttribute("listener_count_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;
			}

			if ((lcf != null && lct != null) && (lct > lcf)) {
				//処理続行
			}

		} else {
			//処理続行
		}

		// (18) 言語ついて、以下のとおりエラー判定を行う。
		if (("true".equals(language_type_jp))) {
			if (("true".equals(language_type_en))) {
				//処理続行

			} else if ("false".equals(language_type_en)) {
				//処理続行

			}

		} else if ("false".equals(language_type_jp)) {
			if ("true".equals(language_type_en)) {
				//処理続行

			} else if ("false".equals(language_type_en)) {
				//エラー
				String s = this.getDescription(con, "ES00007_014");
				request.setAttribute("error", s);
				request.setAttribute("language_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp")
				.forward(request, response);
				return;

			}
		}

		// (19) SQLのデータベースベースから値を取得する。
		List<ComposerRecord> results = null;
		try {
			results = executeQuery(request, response, con,
					nickname_radio,
					nickname_type_radio,
					nickname,
					joined_date_radio,
					joined_date_from,
					joined_date_to,
					gender_radio,
					gender,
					birthday_radio,
					birthday_from,
					birthday_to,
					listener_count_radio,
					listener_count_from,
					listener_count_to,
					language_type_jp,
					language_type_en,
					sort_order);


		} catch (Exception e) {
			String error = getDescription(con, "ES00007_015");
			request.setAttribute("error", error);
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request, response);
			return;
		}

		if (results == null) {
			results = new ArrayList<ComposerRecord>();
		}
		int listSize = results.size();

		// (20) ゼロ件チェック
		if (listSize == 0) {
			String error = getDescription(con, "ES00007_016");
			request.setAttribute("error", error);
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00007.jsp").forward(request, response);
			return;
		}

		// (21) 前処理で得られたListを用いて、Requestオブジェクトに値を設定していく。
		List<ComposerBean> newList = new ArrayList<ComposerBean>();

		int counter = 0;

		for (ComposerRecord l : results) {
			counter = counter + 1;
			// 先頭の10件のみ処理を行う。
			if (counter > 10) {
				break;
			}

			ComposerBean cb = new ComposerBean(); // コンストラクタはループ内で生成する
			//ニックネーム
			String Nickname = l.nickname();
			cb.setNickname(Nickname);
			//登録日
			String joined_date_formated = Transform.conDate(l.joined_date());
			cb.setJoined_date_formated(joined_date_formated);
			//性別
			String Gender = Transform.getGender(l.gender());
			cb.setGender_formated(Gender);
			//誕生日
			String birthday_formated = Transform.conBirthday(l.birthday());
			cb.setBirthday_formated(birthday_formated);
			//リスナー数
			String listener_count_formated = Transform.conComma(l.listener_count());
			cb.setListener_count_formated(listener_count_formated);
			//言語
			String language_type = Transform.getLanguage_type(l.language_type());
			cb.setLanguage_type(language_type);
			//作曲家 ID
			String composer_id = l.composer_id();
			cb.setComposer_id(composer_id);
			//ユニークコード
			String unique_code = l.unique_code();
			cb.setUnique_code(unique_code);

			newList.add(cb);
		}

		String count = NumberFormat.getNumberInstance().format(listSize);
		request.setAttribute("hits", count);
		request.setAttribute("list", newList);

		// (22) S00008.jsp にフォワーディングする。
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00008.jsp").forward(request, response);
	}

	//文言マスタより引数で渡されたkeyをIDにもつレコードを取得

	private String getDescription(Connection con, String description_id)
			throws Exception {

		String ret = "";
		String sql = "select description from mst_description where description_id =?;";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, description_id);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			ret = rs.getString("description");
		}

		rs.close();
		pstmt.close();
		return ret;

	}

	private List<ComposerRecord> executeQuery(HttpServletRequest request,
			HttpServletResponse response,
			Connection con,
			String nickname_radio,
			String nickname_type_radio,
			String nickname,
			String joined_date_radio,
			String joined_date_from,
			String joined_date_to,
			String gender_radio,
			String gender,
			String birthday_radio,
			String birthday_from,
			String birthday_to,
			String listener_count_radio,
			String listener_count_from,
			String listener_count_to,
			String language_type_jp,
			String language_type_en,
			String sort_order) throws Exception {

		@SuppressWarnings("unused")
		boolean joinFlg = false; // true:結合した、false：結合していない

		// (1) SQLの断片を準備する

		String sql1 = "SELECT id, unique_code, nickname, joined_date, gender, birthday, listener_count, language_type, message, fb_link, tw_link, other_link_url, other_link_description ";
		String sql2 = "FROM composer ";
		String sql3 = "WHERE ";
		String sql4 = "nickname like ?";
		String sql5 = "nickname = ?";
		String sql6 = " AND ";
		String sql7 = " joined_date >= ? ";
		String sql8 = " AND ";
		String sql9 = " joined_date <= ? ";
		String sql10 = " AND ";
		String sql11 = " gender = ? ";
		String sql12 = " AND ";
		String sql13 = "birthday >= ?";
		String sql14 = " AND ";
		String sql15 = "birthday <= ?";
		String sql16 = " AND ";
		String sql17 = "listener_count >= ?";
		String sql18 = " AND ";
		String sql19 = "listener_count <= ?";
		String sql20 = " AND ";
		String sql21 = " language_type =?";
		String sql22 = " ORDER BY joined_date desc";
		String sql23 = " ORDER BY joined_date asc";
		String sql24 = " ORDER BY listener_count desc";
		String sql25 = " ORDER BY listener_count asc";
		String sql26 = " ,id desc;";

		// (2) SQLを連結するための文字列を宣言する。
		String query = sql1 + sql2;

		// (3) プレイスホルダに設定する値を格納するためのListを用意する。
		List<PlaceHolderInput> list = new ArrayList<PlaceHolderInput>();

		// (4) nicknameのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(nickname_radio)) {
			if (nickname == null || "".equals(nickname)) {
				// 処理続行
			} else {
				if (list.size() == 0) {
					query = query + sql3;
				}

				if ("1".equals(nickname_type_radio)) {
					query = query + sql4;
					nickname = "%" + nickname + "%";

				} else if ("2".equals(nickname_type_radio)) {
					query = query + sql5;

				} else {
					throw new Exception();
				}
				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(nickname);
				list.add(phi);

			}
		} else if (!("1".equals(nickname_radio))) {
			//処理続行
		}

		// (5) 登録日FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(joined_date_radio)) {
			if (joined_date_from == null || "".equals(joined_date_from)) {
				//処理続行
			}
			else if (Judge.isDateValue(joined_date_from)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql6;
				}
				query = query + sql7;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(joined_date_from);
				list.add(phi);
			} else {
				throw new Exception();
			}
		} else if (!("1".equals(joined_date_radio))) {
			//処理続行
		}

		// (6) 登録日TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(joined_date_radio)) {
			if (joined_date_to == null || "".equals(joined_date_to)) {
				//処理続行
			}
			else if (Judge.isDateValue(joined_date_to)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql8;
				}
				query = query + sql9;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(joined_date_to);
				list.add(phi);
			} else {
				throw new Exception();
			}
		} else if (!("1".equals(joined_date_radio))) {
			//処理続行
		}
		// (7) 性別のSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(gender_radio)) {
			if (gender == null || "".equals(gender)) {
				//処理続行

			} else if ("1".equals(gender)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql10;
				}
				query = query + sql11;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(gender);
				list.add(phi);

			} else if ("2".equals(gender)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql10;
				}
				query = query + sql11;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(gender);
				list.add(phi);

			} else {
				throw new Exception();
			}
		} else if (!("1".equals(gender_radio))) {
			//処理続行
		}

		// (8) 誕生日FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(birthday_radio)) {
			if (birthday_from == null || "".equals(birthday_from)) {
				//処理続行
			}
			else if (Judge.isDateValue(birthday_from)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql12;
				}
				query = query + sql13;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(birthday_from);
				list.add(phi);
			} else {
				throw new Exception();
			}
		} else if (!("1".equals(birthday_radio))) {
			//処理続行
		}
		// (9) 誕生日TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(birthday_radio)) {
			if (birthday_to == null || "".equals(birthday_to)) {
				//処理続行
			}
			else if (Judge.isDateValue(birthday_to)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql14;
				}
				query = query + sql15;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(birthday_to);
				list.add(phi);
			} else {
				throw new Exception();
			}
		} else if (!("1".equals(birthday_radio))) {
			//処理続行
		}
		// (10) リスナー数FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(listener_count_radio)) {
			if (listener_count_from == null || "".equals(listener_count_from)) {
				//処理続行
			} else if (Judge.isNumber(listener_count_from)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql16;
				}
				query = query + sql17;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("1");
				phi.setIntValue(Integer.parseInt(listener_count_from));
				list.add(phi);
			} else {
				throw new Exception();
			}
		} else if (!("1".equals(listener_count_radio))) {
			//処理続行
		}
		// (11) リスナー数TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(listener_count_radio)) {
			if (listener_count_to == null || "".equals(listener_count_to)) {
				//処理続行
			} else if (Judge.isNumber(listener_count_to)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql18;
				}
				query = query + sql19;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("1");
				phi.setIntValue(Integer.parseInt(listener_count_to));
				list.add(phi);
			} else {
				throw new Exception();
			}
		} else if (!("1".equals(listener_count_radio))) {
			//処理続行
		}
		// (12) 言語のSQLへの連結及びプレイスホルダへの設定
		if ("true".equals(language_type_jp)) {
			if ("true".equals(language_type_en)) {
				//処理続行						

			} else if ("false".equals(language_type_en)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql20;
				}
				query = query + sql21;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(LANG_JP);
				list.add(phi);

			}

		} else if ("false".equals(language_type_jp)) {
			if ("true".equals(language_type_en)) {
				if (list.size() == 0) {
					query = query + sql3;
				} else {
					query = query + sql20;
				}
				query = query + sql21;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(LANG_EN);
				list.add(phi);

			} else {
				//処理続行
			}
		}

		// (13) 並び順の値に従って、ORDER BY句を連結する。
		if ("01".equals(sort_order)) {
			query = query + sql22;
		} else if ("02".equals(sort_order)) {
			query = query + sql23;
		} else if ("03".equals(sort_order)) {
			query = query + sql24;
		} else if ("04".equals(sort_order)) {
			query = query + sql25;
		} else {
			throw new Exception();
		}

		query = query + sql26;

		// (14) PreparedStatementのインスタンスを得る。
		PreparedStatement pstmt = con.prepareStatement(query);

		// (15) Where句の連結があれば、(4)で生成したプレイスホルダ用のListの内容をすべて、プレイスホルダに設定する。
		for (int i = 0; i < list.size(); i++) {
			PlaceHolderInput option = list.get(i);
			String type = option.getType();
			if ("1".equals(type)) {
				pstmt.setInt(i + 1, option.getIntValue());
			} else if ("2".equals(type)) {
				pstmt.setDouble(i + 1, option.getDoubleValue());
			} else if ("3".equals(type)) {
				pstmt.setString(i + 1, option.getStringValue());
			}
		}

		// (16) executeQueryを実行し、結果の「ResultSet」を得る。
		ResultSet rs = pstmt.executeQuery();
		List<ComposerRecord> conmposerList = new ArrayList<ComposerRecord>();

		while (rs.next()) {
			ComposerRecord record = new ComposerRecord(
					rs.getString("id"),
					rs.getString("unique_code"),
					rs.getString("nickname"),
					rs.getString("joined_date"),
					rs.getString("gender"),
					rs.getString("birthday"),
					rs.getLong("listener_count"),
					rs.getString("language_type"),
					rs.getString("message"),
					rs.getString("fb_link"),
					rs.getString("tw_link"),
					rs.getString("other_link_url"),
					rs.getString("other_link_description"));

			conmposerList.add(record);
		}

		// (17) ResultSetのインスタンス、PreparedStatementのインスタンスをクローズする。
		pstmt.close();

		// (18) 前処理で生成したListを呼び出し元に返却する。
		return conmposerList;

	}

	private boolean isBlank(String value) {
		if ("".equals(value)) {
			return true;
		} else if (value == null) {
			return true;
		}
		return false;
	}


}
