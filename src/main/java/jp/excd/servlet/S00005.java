package jp.excd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.excd.Util.Judge;
import jp.excd.Util.Transform;
import jp.excd.bean.SongBean;
import jp.excd.bean.SongRecord;
import jp.excd.conponent.PlaceHolderInput;

public class S00005 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		String dbName = "meloko";
		String UserName = "meloko";
		String Password = "exceed";
		String timeZone = "Asia/Tokyo";

		Connection con = null;

		// コネクション
		try {
			con = MySQLSetting.getConnection(dbName, UserName, Password, timeZone);

		} catch (SQLException e) {
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);

		}

		try { 
			try {
				mainProcessForSearch(request, response, con);
			} catch (Exception e) {
				e.printStackTrace();
			}		

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	//mainProcessForSearchメソッド
	private void mainProcessForSearch (HttpServletRequest request, HttpServletResponse response, Connection con) throws IOException, ServletException, SQLException {

		request.setCharacterEncoding("UTF-8");
		String URL = request.getRequestURI();

		if ("/web/ja/S00005/search".equals(URL)) {

		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		}

		//検索画面からの入力値をgetParameterで取得
		String release_date_radio = request.getParameter("release_date_radio");
		String release_date_from = request.getParameter("release_date_from");
		String release_date_to = request.getParameter("release_date_to");
		String rating_radio = request.getParameter("rating_radio");
		String rating_from = request.getParameter("rating_from");
		String rating_to = request.getParameter("rating_to");
		String rating_average_radio = request.getParameter("rating_average_radio");
		String rating_average_from = request.getParameter("rating_average_from");
		String rating_average_to = request.getParameter("rating_average_to");
		String views_radio = request.getParameter("views_radio");
		String views_from = request.getParameter("views_from");
		String views_to = request.getParameter("views_to");
		String title_radio = request.getParameter("title_radio");
		String title_type_radio = request.getParameter("title_type_radio");
		String title = request.getParameter("title");
		String sort_order = request.getParameter("sort_order");


		//アトリビュートを初期化する
		request.setAttribute("error", null);
		request.setAttribute("release_date_is_error", null);
		request.setAttribute("release_date_radio", release_date_radio);
		request.setAttribute("release_date_from", release_date_from);
		request.setAttribute("release_date_to", release_date_to);
		request.setAttribute("rating_is_error", null);
		request.setAttribute("rating_radio", rating_radio);
		request.setAttribute("rating_from", rating_from);
		request.setAttribute("rating_to", rating_to);
		request.setAttribute("rating_average_is_error", null);
		request.setAttribute("rating_average_radio", rating_average_radio);
		request.setAttribute("rating_average_from", rating_average_from);
		request.setAttribute("rating_average_to", rating_average_to);
		request.setAttribute("views_is_error", null);
		request.setAttribute("views_radio", views_radio);
		request.setAttribute("views_from", views_from);
		request.setAttribute("views_to", views_to);
		request.setAttribute("title_is_error", null);
		request.setAttribute("title_radio", title_radio);
		request.setAttribute("title_type_radio", title_type_radio);
		request.setAttribute("title", title);
		request.setAttribute("sort_order", sort_order);

		//条件分岐に使う変数の初期化
		Integer rf = null;
		Integer rt = null;
		Double rAf = null;
		Double rAt = null;
		Integer vf = null;
		Integer vt = null;
		
		//(3)公開日FROMについてエラー判定を行う
		if ("1".equals(release_date_radio)) {
			if (release_date_from == null || "".equals(release_date_from)) {
				// 処理継続	

			} else if (Judge.isDateValue(release_date_from) == false) {
				// エラー
				String s = this.getDescription(con, "ES00005_001");
				request.setAttribute("error", s);
				request.setAttribute("release_date_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
				return;

			} else {
				// 処理継続
			}
		} else if (!("1".equals(release_date_radio))) {
			//処理続行
		}

		//(4)公開日TOについてエラー判定を行う
		if ("1".equals(release_date_radio)) {
			if (release_date_to == null || "".equals(release_date_to)) {
				// 処理継続

			} else if (Judge.isDateValue(release_date_to) == false) {
				// エラー
				String s = this.getDescription(con, "ES00005_002");
				request.setAttribute("error", s);
				request.setAttribute("release_date_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request,response);
				return;

			} else {
				// 処理継続
			}
		} else if (!("1".equals(release_date_radio))) {
			//処理続行
		}

		//(5)公開日FROM、公開日TOについてエラー判定を行う
		if ("1".equals(release_date_radio)) {
			if (release_date_from == null || "".equals(release_date_from) &&
					(release_date_to == null || "".equals(release_date_to))) {
				//エラー
				String s = this.getDescription(con, "ES00005_003");
				request.setAttribute("error", s);
				request.setAttribute("release_date_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request,response);
				return;

			} else if (release_date_from == null
					|| "".equals(release_date_from) && Judge.isDateValue(release_date_to) == true) {
				//処理続行

			} else if (Judge.isDateValue(release_date_from)) {
				//処理続行
			}
		} else if (!("1".equals(release_date_radio))) {
			//処理続行
		}

		//(6)公開日FROM、公開日TOについてエラー判定を行う
		if ("1".equals(release_date_radio)) {
			if( Judge.isDateValue(release_date_from) == true && Judge.isDateValue(release_date_to) == true) {
				int checkResult = release_date_to.compareTo(release_date_from);
	
				if (checkResult < 0) {
					// エラー
					String s = this.getDescription(con, "ES00005_004");
					request.setAttribute("error", s);
					request.setAttribute("release_date_is_error", "1");
					getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
					return;
				}
			}
		} else if (!("1".equals(release_date_radio))) {
			//処理続行
		}

		//(7)感動指数FROMについてエラー判定を行う
		if ("1".equals(rating_radio)) {
			if (rating_from == null || "".equals(rating_from)) {
				// 処理継続
			} else if (Judge.isNumber(rating_from) == false) {
				// エラー
				String s = this.getDescription(con, "ES00005_005");
				request.setAttribute("error", s);
				request.setAttribute("rating_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
				return;
			} else {
				// 処理継続
				rf = Integer.parseInt(rating_from);
			}
		} else if (!("1".equals(rating_radio))) {
			//処理続行
		}

		//(8)感動指数TOについてエラー判定を行う
		if ("1".equals(rating_radio)) {
			if (rating_to == null || "".equals(rating_to)) {
				//処理継続

			} else if (Judge.isNumber(rating_to) == false) {
				//エラー
				String s = this.getDescription(con, "ES00005_006");
				request.setAttribute("error", s);
				request.setAttribute("rating_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request,response);
				return;

			} else {
				//処理継続
				rt = Integer.parseInt(rating_to);
			}
		} else if (!("1".equals(rating_radio))) {
			//処理続行
		}

		//(9)感動指数FROM、感動指数TO についてエラー判定を行う
		if ("1".equals(rating_radio)) {

			if ((rating_from == null || "".equals(rating_from) &&
					(rating_to == null || "".equals(rating_to)))) {
				//エラー
				String s = this.getDescription(con, "ES00005_007");
				request.setAttribute("error", s);
				request.setAttribute("rating_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request,response);
				return;

			} else if (rating_from == null || "".equals(rating_from) && Judge.isNumber(rating_to) == true) {
				//処理続行

			} else if (Judge.isNumber(rating_from)) {
				//処理続行
			}
		} else if (!("1".equals(rating_radio))) {
			//処理続行
		}

		//(10)感動指数FROM、感動指数TO についてエラー判定を行う
		if ("1".equals(rating_radio)) {
			if (rating_from != null && !("".equals(rating_from))) {
				rf = Integer.parseInt(rating_from);
			}
			if (rating_to != null && !("".equals(rating_to))) {
				rt = Integer.parseInt(rating_to);
			}
			if (rf != null && rt != null && rf > rt) {
				//エラー
				String s = this.getDescription(con, "ES00005_008");
				request.setAttribute("error", s);
				request.setAttribute("rating_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
				return;

			} else {
				//処理続行
			}
		} else if (!("1".equals(rating_radio))) {
			//処理続行
		}

		//(11)平均感動指数FROM、平均感動指数TOについてエラー判定を行う
		if ("1".equals(rating_average_radio)) {

			if (rating_average_from != null && !("".equals(rating_average_from))) {
				rAf = Double.parseDouble(rating_average_from);
			}

			if (rating_average_to != null && !("".equals(rating_average_to))) {
				rAt = Double.parseDouble(rating_average_to);
			}

			if ((rAf != null && rAt != null) && (rAf > rAt)) {
				//エラー
				String s = this.getDescription(con, "ES00005_009");
				request.setAttribute("error", s);
				request.setAttribute("rating_average_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
				return;

			} else {
				//処理続行
			}
		} else if (!("1".equals(rating_average_radio))) {
			//処理続行
		}

		//(12)再生回数FROMについてエラー判定を行う
		if ("1".equals(views_radio)) {
			if (views_from == null || "".equals(views_from)) {
				//処理継続

			} else if (Judge.isNumber(views_from) == false) {
				//エラー
				String s = this.getDescription(con, "ES00005_010");
				request.setAttribute("error", s);
				request.setAttribute("views_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp")
				.forward(request, response);
				return;

			} else {
				//処理継続
			}
		} else if (!("1".equals(views_radio))) {
			//処理続行
		}

		//(13)再生回数TOについてエラー判定を行う。
		if ("1".equals(views_radio)) {
			if (views_to == null || "".equals(views_to)) {
				//処理継続

			} else if (Judge.isNumber(views_to) == false) {
				//エラー
				String s = this.getDescription(con, "ES00005_011");
				request.setAttribute("error", s);
				request.setAttribute("views_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp")
				.forward(request, response);
				return;

			} else {
				//処理継続
			}
		} else if (!("1".equals(views_radio))) {
			//処理続行
		}

		//(14)再生回数FROM、再生回数TOについてエラー判定を行う。
		if ("1".equals(views_radio)) {

			if (views_from == null || "".equals(views_from) &&
					(views_to == null|| "".equals(views_to))) {
				//エラー
				String s = this.getDescription(con, "ES00005_012");
				request.setAttribute("error", s);
				request.setAttribute("views_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp")
				.forward(request, response);
				return;

			} else if (views_from == null || "".equals(views_from) && Judge.isNumber(views_to) == true) {
				//処理続行

			} else if (Judge.isNumber(views_from)) {
				//処理続行
			}
		} else if (!("1".equals(views_radio))) {
			//処理続行
		}

		//(15)再生回数FROM、再生回数TOについてエラー判定を行う
		if ("1".equals(views_radio)) {

			if (views_from != null && !("".equals(views_from))) {
				vf = Integer.parseInt(views_from);
			}
			if (views_to != null && !("".equals(views_to))) {
				vt = Integer.parseInt(views_to);
			}
			if ((vf != null) && (vt != null)){
				if ( vf > vt) {
				//エラー
				String s = this.getDescription(con, "ES00005_013");
				request.setAttribute("error", s);
				request.setAttribute("views_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
				return;
				}
			} else {
				//処理続行
			}
		} else if (!("1".equals(views_radio))) {
			//処理続行
		}

		//(16)曲名についてエラー判定を行う
		if ("1".equals(title_radio)) {

			if (title == null || "".equals(title)) {
				//エラー
				String s = this.getDescription(con, "ES00005_014");
				request.setAttribute("error", s);
				request.setAttribute("title_is_error", "1");
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
				return;

			} else {
				//処理続行
			}
		} else if (!("1".equals(title_radio))) {
			//処理続行
		}

		//(17)リクエストパラメータを条件にList型のインスタンスで受け取り、曲情報を取得する
		List<SongRecord> results = null;

		try {
			results = executeQuery(request,
					response,
					con,
					release_date_radio,
					release_date_from,
					release_date_to,
					rating_radio,
					rating_from,
					rating_to,
					rating_average_radio,
					rating_average_from,
					rating_average_to,
					views_radio,
					views_from,
					views_to,
					title_radio,
					title_type_radio,
					title,
					sort_order);



		} catch (Exception e) {
			String error = getDescription(con, "ES00005_015");
			request.setAttribute("error", error);
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
			return;
		}

		if (results == null) {
			results = new ArrayList<SongRecord>();
		}
		int listSize = results.size();

		// ゼロ件チェック
		if (listSize == 0) {
			String error = getDescription(con, "ES00005_016");
			request.setAttribute("error", error);
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00005.jsp").forward(request, response);
			return;
		}

		//SongRecordからSongBeanへ
		List<SongBean> songList = new ArrayList<SongBean>();

		int counter = 0;
		

		for (SongRecord record : results) {
			SongBean bean = new SongBean();

			counter = counter + 1;
			
			if (counter > 10) {
				break;
			}
			
			//ソングID
			String Song_id = record.song_id();
			bean.setSong_id(Song_id);

			//曲名
			String Title = record.title();
			bean.setTitle(Title);
			
			//総感動指数
			long Rating_total = record.rating_total();
			//rating_totalをカンマ編集してString型に変換
			String rating_total_formated = Transform.conComma(Rating_total);
			bean.setRating_total_forated(rating_total_formated);

			//平均感動指数
			double Rating_average = record.rating_average();
			String rating_average_formated = Transform.conThree(Rating_average);			
			bean.setRating_average_formated(rating_average_formated);

			//再生回数
			long Total_listen_count = record.total_listen_count();
			String Total_listen_count_formated = Transform.conComma(Total_listen_count);
			bean.setTotal_listen_count_formated(Total_listen_count_formated);

			//公開時間
			double Release_datetime = record.release_datetime();
			String Release_datetime_formated = Transform.getLastUploadTime(Release_datetime);
			bean.setRelease_datetime_formated(Release_datetime_formated);

			//ファイルネーム
			String Image_file_name = record.imege_file_name();
			bean.setImage_file_name(Image_file_name);
			
			songList.add(bean);
		}
		
		int counter_main = 0;

		for (SongRecord record : results) {

			counter_main = counter_main + 1;
		}
		
		String count = NumberFormat.getNumberInstance().format(counter_main);
		request.setAttribute("hits", count);
		request.setAttribute("list", songList);

		// (20) S00006.jsp にフォワーディングする。
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00006.jsp").forward(request, response);
	}

private String getDescription (Connection con, String description_id) throws SQLException {

	String ret = "";
	String SQL = "SELECT description FROM mst_description WHERE description_id = ?;";
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	pstmt = con.prepareStatement(SQL);

	pstmt.setString(1, description_id);
	rs = pstmt.executeQuery();

	if (rs.next()) {
		ret = rs.getString("description");
	}

	rs.close();
	pstmt.close();
	return ret;

}


private List<SongRecord> executeQuery (HttpServletRequest request,
		HttpServletResponse response, 
		Connection con, 
		String release_date_radio, 
		String release_date_from, 
		String release_date_to, 
		String rating_radio, 
		String rating_from, 
		String rating_to, 
		String rating_average_radio, 
		String rating_average_from, 
		String rating_average_to, 
		String views_radio, 
		String views_from, 
		String views_to, 
		String title_radio, 
		String title_type_radio, 
		String title, 
		String sort_order) throws Exception {
	
	String SQL = "SELECT id, title, composer_id, rating_total, rating_average, "
			+ "total_listen_count, release_datetime, last_update_datetime, "
			+ "message, `key` , score_type, bpm, image_file_name, image_file_height, "
			+ "image_file_width, other_link_url, other_link_description "
			+ "FROM song ";

	String sql1 = "release_datetime >=? ";
	String sql2 = "release_datetime <=? ";
	String sql3 = "rating_total >=? ";
	String sql4 = "rating_total <=? ";
	String sql5 = "rating_average >=? ";
	String sql6 = "rating_average <=? ";
	String sql7 = "total_listen_count >=? ";
	String sql8 = "total_listen_count <=? ";
	String sql9 = "title like ? ";
	String sql10 = "title = ? ";
	String sql11 = "ORDER BY release_datetime desc ";
	String sql12 = "ORDER BY release_datetime asc ";
	String sql13 = "ORDER BY rating_total desc ";
	String sql14 = "ORDER BY rating_total asc ";
	String sql15 = "ORDER BY rating_average desc ";
	String sql16 = "ORDER BY rating_average asc ";
	String sql17 = "ORDER BY total_listen_count desc ";
	String sql18 = "ORDER BY total_listen_count asc ";
	String sql19 = "ORDER BY id desc;";
	String and = "AND ";
	/*		String from = ">= ? ";
	 * 		String space = " ";
	 * 		String to = "<= ? ";
	 * 		String orderby = "ORDER BY ";
	 * 		String desc = "desc ";
	 * 		String asc = "asc ";	
	 */		
	List<PlaceHolderInput> list = new ArrayList<PlaceHolderInput>(); 
	
	if ("1".equals(release_date_radio) || "1".equals(rating_radio) || "1".equals(rating_average_radio) || "1".equals(views_radio) || "1".equals(title_radio)) {
		SQL += "WHERE ";

		//公開日FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(release_date_radio)) {
			if (release_date_from == null || "".equals(release_date_from)) {
				//処理続行
			} else if (Judge.isDateValue(release_date_from)) {
				SQL += sql1;
				
				String epochSeconds = getEpochSeconds(release_date_from);
				
				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("2");
				phi.setDoubleValue(Double.parseDouble(epochSeconds));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(release_date_radio))) {
			//処理続行
		}

		//公開日TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(release_date_radio)) {
			if (release_date_to == null || "".equals(release_date_to)) {
				//処理続行

			} else if (Judge.isDateValue(release_date_to)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql2;

				String epochSeconds = getEpochSeconds(release_date_to);
				
				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("2");
				phi.setDoubleValue(Double.parseDouble(epochSeconds));
				list.add(phi);
			}  else {
				throw new Exception();
			}
		} else if (!("1".equals(release_date_radio))) {
			//処理続行				
		}

		//感動指数FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(rating_radio)) {
			if (rating_from == null || "".equals(rating_from)) {
				//処理続行

			} else if (Judge.isNumber(rating_from)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql3;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("1");
				phi.setIntValue(Integer.parseInt(rating_from));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(rating_radio))) {
			//処理続行				
		}

		//感動指数TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(rating_radio)) {
			if (rating_to == null || "".equals(rating_to)) {
				//処理続行

			} else if (Judge.isNumber(rating_to)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql4;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("1");
				phi.setIntValue(Integer.parseInt(rating_to));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(rating_radio))) {
			//処理続行				
		}

		//平均感動指数FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(rating_average_radio)) {
			if (rating_average_from == null || "".equals(rating_average_from)) {
				//処理続行

			} else if (Judge.isDouble(rating_average_from)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql5;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("2");
				phi.setDoubleValue(Double.parseDouble(rating_average_from));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(rating_average_radio))) {
			//処理続行				
		}

		//平均感動指数TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(rating_average_radio)) {
			if (rating_average_to == null || "".equals(rating_average_to)) {
				//処理続行

			} else if (Judge.isDouble(rating_average_to)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql6;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("2");
				phi.setDoubleValue(Double.parseDouble(rating_average_to));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(rating_average_radio))) {
			//処理続行				
		}

		//再生回数FROMのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(views_radio)) {
			if (views_from == null || "".equals(views_from)) {
				//処理続行

			} else if (Judge.isNumber(views_from)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql7;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("1");
				phi.setIntValue(Integer.parseInt(views_from));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(views_radio))) {
			//処理続行				
		}

		//再生回数TOのSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(views_radio)) {
			if (views_to == null || "".equals(views_to)) {
				//処理続行

			} else if (Judge.isNumber(views_to)) {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				SQL += sql8;

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("1");
				phi.setIntValue(Integer.parseInt(views_to));
				list.add(phi);
			} else {
				throw new Exception();
			}

		} else if (!("1".equals(views_radio))) {
			//処理続行				
		}

		//曲名のSQLへの連結及びプレイスホルダへの設定
		if ("1".equals(title_radio)) {
			if (title == null || "".equals(title)) {
				//処理続行

			} else {
				if (list.size() == 0) {
				} else {
					SQL += and;
				}

				if ("3".equals(title_type_radio)) {
					SQL = SQL + sql9; 
					title = "%" + title + "%";

				} else if ("4".equals(title_type_radio)) {
					SQL = SQL + sql10; 

				}

				PlaceHolderInput phi = new PlaceHolderInput();
				phi.setType("3");
				phi.setStringValue(title);
				list.add(phi);
			}

		} else if (!("1".equals(title_radio))) {
			//処理続行				
		}

	}

	if ("新しい順".equals(sort_order)) {
		SQL += sql11;

	} else if ("古い順".equals(sort_order)) {
		SQL += sql12;

	} else if ("感動指数が多い順".equals(sort_order)) {
		SQL += sql13;

	} else if ("感動指数が少ない順".equals(sort_order)) {
		SQL += sql14;

	} else if ("平均感動指数が高い順".equals(sort_order)) {
		SQL += sql15;					

	} else if ("平均感動指数が低い順".equals(sort_order)) {
		SQL += sql16;

	} else if ("再生回数が多い順".equals(sort_order)) {
		SQL += sql17;

	} else if ("再生回数が少ない順".equals(sort_order)) {
		SQL += sql18;
	}

	SQL += sql19;		

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	pstmt = con.prepareStatement(SQL);
	
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

	rs = pstmt.executeQuery();

	List<SongRecord> songList = new ArrayList<SongRecord>();

	while (rs.next()) {
		
		SongRecord record = new SongRecord(
								rs.getString("id"), 
								rs.getString("title"),
								rs.getString("composer_id"),
								rs.getLong("rating_total"),
								rs.getDouble("rating_average"),
								rs.getLong("total_listen_count"),
								rs.getDouble("release_datetime"),
								rs.getDouble("last_update_datetime"),
								rs.getString("message"),
								rs.getString("key"),
								rs.getString("score_type"),
								rs.getDouble("bpm"),
								rs.getString("image_file_name"),
								rs.getInt("image_file_height"),
								rs.getInt("image_file_width"),
								rs.getString("other_link_url"),
								rs.getString("other_link_description"));

		songList.add(record);
	}

	try {
		pstmt.close();
		rs.close();

	} catch (Exception e) {
		throw new Exception();
	}

	return songList;


	}

	private String getEpochSeconds(String num) {
		
			LocalDate date = LocalDate.parse(num, DateTimeFormatter.ISO_LOCAL_DATE);
			Instant instant = date.atStartOfDay().toInstant(ZoneOffset.UTC);
			long epochSeconds = instant.getEpochSecond();
			String formattedDate = String.valueOf(epochSeconds);
			return formattedDate;

	}


}


