package jp.excd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.excd.Util.Transform;
import jp.excd.bean.ExSongBean;
import jp.excd.bean.ExSongRecord;
import jp.excd.conponent.PlaceHolderInput;

public class S00001 extends HttpServlet {
	public void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException {
		//  404.jspにフォワーディングする。
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		return;
	}



	public void doGet(
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
			this.categorySelect(request, response, con);

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
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);
				return;

			}

		}

	}


	private void categorySelect(
			HttpServletRequest request,
			HttpServletResponse response,
			Connection con) throws Exception{

		//　接続URL受け取り
		String URL = request.getRequestURI();

		//  接続URLが「/ja/S00001」以外の場合は、404.jspへフォワーディングする。
		if ("/web/ja/S00001".equals(URL.substring(0,14))) {
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		}

		//　POSTパラメタの文字コードを指定
		request.setCharacterEncoding("UTF-8");

		//  GETパラメタから値を受け取る。
		String category = (String)request.getParameter("category");
		String from = (String)request.getParameter("from");

		//  URLの表示対象言語に応じて(日本語)、アプリリンクに表示する文言を取得する。
		String description = getDescription(con);

		//  URLで指定された言語区分(日本語)をキーに「getTopnotice」を呼び出し、告知情報を取得する。
		String notice = getTopnotice(con,"002");

		//  SQLの組み立てと、Where句への値の設定を行う。「executeQuery」メソッドを呼び出す。
		List<ExSongRecord> results = null;
		try {
			results = executeQuery(request, response, con, category, from);



		} catch (Exception e) {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);
		}

		// 「さらに読み込む」ボタンに設定するURL
		String loadMore = null;
		int fromLoad;


		//　行数指定の有無
		if(from != null) {
			//　整数判定
			Pattern pattern = Pattern.compile("^[0-9]+$");
			boolean numCheck = pattern.matcher(from).matches();


			if ("2".equals(category) || "3".equals(category) || "4".equals(category) ) {

				if(numCheck) {
					fromLoad = Integer.parseInt(from) + 5;
					loadMore = "http://localhost:8080/web/ja/S00001?category=" + category + "&from=" + fromLoad;
					request.setAttribute("from", Integer.parseInt(from));
				} else {
					loadMore = "http://localhost:8080/web/ja/S00001?category=" + category + "&from=6";
					request.setAttribute("from", 1);
				}

			} else {
				if(numCheck) {
					fromLoad = Integer.parseInt(from) + 5;
					loadMore = "http://localhost:8080/web/ja/S00001?category=1&from=" + fromLoad;
					request.setAttribute("from", Integer.parseInt(from));
				} else {
					loadMore = "http://localhost:8080/web/ja/S00001?category=1&from=6";
					request.setAttribute("from", 1);
				}
			}
		} else {

			if ("2".equals(category) || "3".equals(category) || "4".equals(category) ) {
				loadMore = "http://localhost:8080/web/ja/S00001?category=" + category + "&from=6";
				request.setAttribute("from", 1);

			} else {
				loadMore = "http://localhost:8080/web/ja/S00001?category=1&from=6";
				request.setAttribute("from", 1);
			}
		}

		int counter = 0;
		//  ExSongBeanインスタンスを持つListを作成する。
		List<ExSongBean> exSongList = new ArrayList<ExSongBean>();
		for (ExSongRecord record : results) {

			ExSongBean bean = new ExSongBean();

			//ソングID
			String Song_id = record.getsong_id();
			bean.setSong_id(Song_id);

			//曲名
			String Title = record.gettitle();
			bean.setTitle(Title);

			//総感動指数
			long Rating_total = record.getrating_total();

			//rating_totalをカンマ編集してString型に変換
			String rating_total_formated = Transform.conComma(Rating_total);
			bean.setRating_total_forated(rating_total_formated);

			//平均感動指数
			double Rating_average = record.getrating_average();
			String rating_average_formated =Transform.conThree(Rating_average);	
			bean.setRating_average_formated(rating_average_formated);

			//再生回数
			long Total_listen_count = record.gettotal_listen_count();
			String Total_listen_count_formated = Transform.conComma(Total_listen_count);
			bean.setTotal_listen_count_formated(Total_listen_count_formated);

			//公開時間
			double Release_datetime = record.getrelease_datetime();
			String Release_datetime_formated = Transform.getLastUploadTime(Release_datetime);
			bean.setRelease_datetime_formated(Release_datetime_formated);

			//ファイルネーム
			String Image_file_name = record.getimage_file_name();
			bean.setImage_file_name(Image_file_name);

			//ニックネーム
			String Nickname = record.getnickname();
			bean.setnickname(Nickname);

			//ユニークコード
			String Unique_code = record.getunique_code();
			bean.setunique_code(Unique_code);

			exSongList.add(bean);

			counter = counter + 1;
			// 先頭の100件のみ処理を行う。
			if (counter > 100) {
				break;
			}
		}

		// Requestオブジェクトに値をセットする
		request.setAttribute("list", exSongList);
		request.setAttribute("count", counter);
		request.setAttribute("category", category);
		request.setAttribute("notice", notice);
		request.setAttribute("description", description);
		request.setAttribute("loadMore", loadMore);

		//　フォワード先の指定
		RequestDispatcher dispatcher =  request.getRequestDispatcher("/jsp/S00001.jsp");

		//　フォワードの実行
		dispatcher.forward(request, response);

	}


	//discriptionを返却するメソッド
	private String getDescription(Connection con) throws Exception {
		String ret = "";
		String sql = "select description from mst_description where description_id = 'DS00001_001' AND language_type = '002'";
		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			ret = rs.getString("description");
		}

		rs.close();
		pstmt.close();
		return ret;

	}

	//トップページ告知を返却するメソッド
	private String getTopnotice(Connection con, String language) throws Exception {
		String ret = "";
		String sql = "select notice from top_notice where language_type = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, language);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			ret = rs.getString("notice");
		}

		rs.close();
		pstmt.close();
		return ret;

	}

	// SQLの組み立てと、Where句への値の設定を行うメソッド
	private List<ExSongRecord>  executeQuery(HttpServletRequest request, HttpServletResponse response,Connection con, String category, String from) throws Exception{

		//  SQLの断片を用意する。
		String sql1 = "SELECT song.id, song.title, song.rating_total, song.rating_average, song.total_listen_count, song.release_datetime, song.image_file_name, composer.nickname, composer.unique_code ";
		String sql2 = "FROM song ";
		String sql3 = "LEFT JOIN composer ON song.composer_id = composer.id ";
		String sql4 = "WHERE ";
		String sql5 = "release_datetime >= ? ";
		String sql6 = "ORDER BY song.rating_total desc, song.id asc ";
		String sql7 = "ORDER BY song.rating_average desc, song.id asc ";
		String sql8 = "ORDER BY song.release_datetime desc, song.id asc ";
		//String sql9 = "LIMIT 5 OFFSET ? ";

		//  SQLを連結するための文字列を宣言する。
		String query = sql1 + sql2 + sql3;

		//  プレイスホルダに設定する値を格納するためのListを用意する。
		List<PlaceHolderInput> list = new ArrayList<PlaceHolderInput>();

		// 現在のエポック秒を取得
		Date date = new Date();
		double nowEpoch = (double) date.getTime();
		System.out.println(nowEpoch);
		//1ヵ月前
		double monthAgo = (nowEpoch/1000 - 2592000);
		//1年前
		double yearAgo = (nowEpoch/1000 - 31104000);


		//  GETパラメタで受け取った[category]に応じて、SQLを組み立てる。
		PlaceHolderInput phi = new PlaceHolderInput();
		if("2".equals(category)){
			query = query + sql4 + sql5 + sql6;
			phi.setType("2");
			phi.setDoubleValue(monthAgo);
			list.add(phi);

		}else if("3".equals(category)) {
			query = query + sql4 + sql5 + sql7;
			phi.setType("2");
			phi.setDoubleValue(monthAgo);
			list.add(phi);

		}else if("4".equals(category)) {
			query = query + sql4 + sql5 + sql6;
			phi.setType("2");
			phi.setDoubleValue(yearAgo);
			list.add(phi);

		}else {
			query = query + sql4 + sql5 + sql8;
			phi.setType("2");
			phi.setDoubleValue(monthAgo);
			list.add(phi);

		}


		//  PreparedStatementのインスタンスを得る。
		PreparedStatement pstmt = con.prepareStatement(query);

		//  生成したプレイスホルダ用のListの内容をすべて、プレイスホルダに設定する。
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

		//  executeQueryを実行し、結果の「ResultSet」を得る。
		ResultSet rs = pstmt.executeQuery();
		List<ExSongRecord> songList = new ArrayList<ExSongRecord>();

		while (rs.next()) {
			ExSongRecord record = new ExSongRecord();
			//ソングID
			String Song_id = rs.getString("id");
			record.setsong_id(Song_id);

			//曲名
			String Title = rs.getString("title");
			record.settitle(Title);

			//総評価数
			long Rating_total = rs.getLong("rating_total");
			record.setrating_total(Rating_total);

			//平均評価数
			double Rating_average = rs.getDouble("rating_average");
			record.setrating_average(Rating_average);

			//再生回数
			long Total_listen_count = rs.getLong("Total_listen_count");
			record.settotal_listen_count(Total_listen_count);

			//公開日
			double Release_datetime = rs.getDouble("release_datetime");
			record.setrelease_datetime(Release_datetime);

			//ファイルネーム
			String Image_file_name = rs.getString("image_file_name");
			record.setimage_file_name(Image_file_name);

			//ニックネーム
			String Nickname = rs.getString("nickname");
			record.setnickname(Nickname);

			//ユニークコード
			String Unique_code = rs.getString("unique_code");
			record.setunique_code(Unique_code);

			songList.add(record);
		}

		//  ResultSetのインスタンス、PreparedStatementのインスタンスをクローズする。
		pstmt.close();

		//  前処理で生成したListを呼び出し元に返却する。
		return songList;
	}

}