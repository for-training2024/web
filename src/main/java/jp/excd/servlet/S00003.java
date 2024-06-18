package jp.excd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.excd.bean.CommentRatingBean;
import jp.excd.bean.CommentRatingRecord;
import jp.excd.bean.S00003Bean;
import jp.excd.bean.S00003Record;
import jp.excd.transform.Transform;

public class S00003 extends HttpServlet {

	public void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws IOException, ServletException {


		request.setCharacterEncoding("UTF-8");

		String dbName = "meloko";
		String userName = "meloko";
		String password = "exceed";
		String timeZone = "Asia/Tokyo";

		Connection con = null;

		try {
			// (1)DB接続（コネクションの確立）
			con = MySQLSetting.getConnection(dbName, userName, password, timeZone);

			// (2)内部メソッド呼び出し
			this.main(request, response, con);

		} catch (Exception e) {
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);
			return;

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

	private void main(HttpServletRequest request, HttpServletResponse response, Connection con)
			throws IOException, Exception {

		// 接続URL受け取り
		String url = request.getRequestURI().toString();

		// URLを解析して必要な部分を取得
		String[] parts = url.split("/");
		// 最後の部分を取得
		String urlSongId = parts[parts.length - 1];

		//  接続URLが「/ja/S00003searh」以外の場合は、404.jspへフォワーディングする。
		if (("/web/ja/S00003/" + urlSongId).equals(url)) {
			
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
			return;
		}

		//(3)songS3をS00003Record型で呼び出し
		S00003Record recordS3 = songS3(con, urlSongId);


		//  DBに値がある以外の場合は、404.jspへフォワーディングする。
		if (!((recordS3.getsong_id()).equals(null))) {
			
		} else {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
			return;
		}
			
		// (4)前処理で得られたListを用いて、S00003Beanに値を設定していく。
			S00003Bean beanS3 = new S00003Bean();			
			
			//曲ID
			String song_id = recordS3.getsong_id();
			beanS3.setsong_id(song_id);
			//曲名
			String title = recordS3.gettitle();
			beanS3.settitle(title);
			//作曲家ID
			String Composer_id = recordS3.getcomposer_id();
			beanS3.setcomposer_id(Composer_id);
			//総評価数
			String rating_total_formated = Transform.isComma(recordS3.getrating_total());
			beanS3.setrating_total_formated(rating_total_formated);

			//平均感動指数
			String rating_average_formated = Transform.isThree(recordS3.getrating_average());			
			beanS3.setrating_average_formated(rating_average_formated);

			//再生回数
			String total_listen_count_formated = Transform.isComma(recordS3.gettotal_listen_count());
			beanS3.settotal_listen_count_formated(total_listen_count_formated);

			//公開時間
			String release_datetime_formated = Transform.getLastUploadTime(recordS3.getrelease_datetime());
			beanS3.setrelease_datetime_formated(release_datetime_formated);

			//最終更新時間
			String last_update_datetime_formated = Transform.getLastUploadTime(recordS3.getlast_update_datetime());
			beanS3.setlast_update_datetime_formated(last_update_datetime_formated);

			//メッセージ
			String message = recordS3.getmessage();
			beanS3.setmessage(message);

			//キー
			String key_formated = Transform.isKey(recordS3.getkey());
			beanS3.setkey_formated(key_formated);

			//楽譜表記
			String score_type_formated = Transform.isScore_type(recordS3.getscore_type());
			beanS3.setscore_type_formated(score_type_formated);

			//BPM
			String bpm =  String.format("%d", (int) Math.floor(recordS3.getbpm()));
			beanS3.setbpm(bpm);
			
			//イメージファイル名
			String Image_file_name = recordS3.getimage_file_name();
			beanS3.setimage_file_name(Image_file_name);

			//イメージファイル画像高さ
			int image_file_height = recordS3.getimage_file_height();
			beanS3.setimage_file_height(image_file_height);

			//イメージファイル画像幅
			int image_file_width = recordS3.getimage_file_width();
			beanS3.setimage_file_width(image_file_width);

			//関連リンク
			String other_link_url = recordS3.getother_link_url();
			beanS3.setother_link_url(other_link_url);

			//関連リンク文字列
			String other_link_description = recordS3.getother_link_description();
			beanS3.setother_link_description(other_link_description);

			//ユニーク名
			String unique_code = recordS3.getunique_code();
			beanS3.setunique_code(unique_code);

			//ニックネーム
			String nickname = recordS3.getnickname();
			beanS3.setnickname(nickname);

		request.setAttribute("list1", beanS3);

		
		//(3)songS3をS00003Record型で呼び出し
		List<CommentRatingRecord> resultsCR = commentRating(con, urlSongId);
		List<CommentRatingBean> newCRList = new ArrayList<CommentRatingBean>();

			
		int counter = 0;
		
		// (4) 前処理で得られたListを用いて、CommentRatingBeanに値を設定していく。
		for (CommentRatingRecord recordCR : resultsCR) {
			CommentRatingBean beanCR = new CommentRatingBean();

			//コメントID
			String Comment_id = Integer.toString(recordCR.getcomment_id());
			beanCR.setcomment_id(Comment_id);

			//ソング番号
			String comment_song_id = Integer.toString(recordCR.getcomment_song_id());
			beanCR.setcomment_song_id(comment_song_id);

			//シーケンス
			int comment_sequence = recordCR.getcomment_sequence();
			beanCR.setcomment_sequence(comment_sequence);

			//作曲家番号
			String comment_composer_id = Integer.toString(recordCR.getcomment_composer_id());
			beanCR.setcomment_composer_id(comment_composer_id);

			//文言
			String comment_comment = recordCR.getcomment_comment();
			beanCR.setcomment_comment(comment_comment);

			//コメントタイプ
			int comment_type = recordCR.getcomment_type();
			beanCR.setcomment_type(comment_type);

			//元コメントID
			String comment_to_comment_id = Integer.toString(recordCR.getcomment_to_comment_id());
			beanCR.setcomment_to_comment_id(comment_to_comment_id);

			//書き込み日時
			String comment_write_datetime_fomated = Transform.getLastUploadTime(recordCR.getcomment_write_datetime());
			beanCR.setcomment_write_datetime_fomated(comment_write_datetime_fomated);

			//感動指数
			String rating_rating = String.format("%d", (int) Math.floor(recordCR.getrating_rating()));
			beanCR.setrating_rating(rating_rating);

			//ユニーク名
			String composer_unique_code = recordCR.getcomposer_unique_code();
			beanCR.setcomposer_unique_code(composer_unique_code);

			//ニックネーム
			String composer_nickname = recordCR.getcomposer_nickname();
			beanCR.setcomposer_nickname(composer_nickname);

			counter = counter + 1;
			// 先頭の100件のみ処理を行う。
			if (counter > 100) {
				break;
			}
		
		newCRList.add(beanCR);

		}

		request.setAttribute("list2", newCRList);

		// (5) S00003.jsp にフォワーディングする。
		getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00003.jsp").forward(request, response);
		return;
	}

	private S00003Record songS3(Connection con,
			String urlSongId) throws Exception {

		@SuppressWarnings("unused")
		boolean joinFlg = false; // true:結合した、false：結合していない

		// (1) 曲情報を取得するSQLを用意する。
		String sql = "SELECT song.id, song.title, song.composer_id, song.rating_total,\n"
				+ " song.rating_average, song.total_listen_count, song.release_datetime, song.last_update_datetime,\n"
				+ " song.message, song.key, song.score_type, song.bpm, song.image_file_name, song.image_file_height,\n"
				+ " song.image_file_width, song.other_link_url, song.other_link_description, \n"
				+ " composer.unique_code, composer.nickname FROM song\n"
				+ "LEFT OUTER JOIN composer ON song.composer_id = composer.id\n"
				+ "where song.id = ? ;\n";

		// (2) PreparedStatementのインスタンスを得る。
		PreparedStatement pstmt = con.prepareStatement(sql);
		//urlの曲IDを代入する
		pstmt.setString(1, urlSongId);
		
		// (3) executeQueryを実行し、結果の「ResultSet1」を得る。
		ResultSet rs1 = pstmt.executeQuery();
		
			S00003Record record = new S00003Record();
			//ソングID
		if(rs1.next()) {			
			String Song_id = rs1.getString("song.id");
			record.setsong_id(Song_id);
			//曲名
			String Title = rs1.getString("song.title");
			record.settitle(Title);
			//作曲家ID
			String Composer_id = rs1.getString("song.composer_id");
			record.setcomposer_id(Composer_id);
			//総評価数
			long Rating_total = rs1.getLong("song.rating_total");
			record.setrating_total(Rating_total);
			//平均評価数
			double Rating_average = rs1.getDouble("song.rating_average");
			record.setrating_average(Rating_average);
			//再生回数
			long Total_listen_count = rs1.getLong("song.total_listen_count");
			record.settotal_listen_count(Total_listen_count);
			//公開日
			double Release_datetime = rs1.getDouble("song.release_datetime");
			record.setrelease_datetime(Release_datetime);
			//最終更新日
			double Last_update_datetime = rs1.getDouble("song.last_update_datetime");
			record.setlast_update_datetime(Last_update_datetime);
			//コメント
			String Message = rs1.getString("song.message");
			record.setmessage(Message);
			//キー
			String Key = rs1.getString("song.key");
			record.setkey(Key);
			//楽譜表記
			String Score_type = rs1.getString("song.score_type");
			record.setscore_type(Score_type);
			//BPM
			double Bpm = rs1.getDouble("song.bpm");
			record.setbpm(Bpm);
			//ファイルネーム
			String Image_file_name = rs1.getString("song.image_file_name");
			record.setimage_file_name(Image_file_name);
			//ファイル高さ
			int Image_file_height = rs1.getInt("song.image_file_height");
			record.setimage_file_height(Image_file_height);
			//ファイル幅
			int Image_file_width = rs1.getInt("song.image_file_width");
			record.setimage_file_width(Image_file_width);
			//関連リンク
			String Other_link_url = rs1.getString("song.other_link_url");
			record.setother_link_url(Other_link_url);
			//関連リンク名
			String Other_link_description = rs1.getString("song.other_link_description");
			record.setother_link_description(Other_link_description);
			//ユニークコード
			String Unique_code = rs1.getString("composer.unique_code");
			record.setunique_code(Unique_code);
			//ニックネーム
			String Nickname = rs1.getString("composer.nickname");
			record.setnickname(Nickname);
		}

		// (4) ResultSetのインスタンス、PreparedStatementのインスタンスをクローズする。
		pstmt.close();

		// (5) 前処理で生成したListを呼び出し元に返却する。
		return record;
		
	}

	//コメント取得呼び出し先
	private List<CommentRatingRecord> commentRating(Connection con,
			String urlSongId) throws Exception {

		@SuppressWarnings("unused")
		boolean joinFlg = false; // true:結合した、false：結合していない			

		// (1)SQLを組み立てる
		String sql = "SELECT comment.id, comment.song_id, comment.sequence, comment.composer_id,\n"
				+ " comment.comment, comment.type, comment.to_comment_id, comment.write_datetime,\n"
				+ " rating.rating, composer.unique_code, composer.nickname FROM comment\n"
				+ "LEFT OUTER JOIN rating ON rating.composer_id = comment.composer_id\n"
				+ "LEFT OUTER JOIN composer ON comment.composer_id = composer.id\n"
				+ "where comment.song_id = ?\n"
				+ "ORDER BY comment.sequence; \n";

		//(2) PreparedStatementのインスタンスを得る。
		PreparedStatement pstmt = con.prepareStatement(sql);
		//ソングIDを?に代入
		pstmt.setString(1, urlSongId);

		//(3) executeQueryを実行し、結果の「ResultSet2」を得る。
		ResultSet rs2 = pstmt.executeQuery();
		List<CommentRatingRecord> commentRatingRecordList = new ArrayList<CommentRatingRecord>();

		while (rs2.next()) {			
			CommentRatingRecord record = new CommentRatingRecord();
			//コメントテーブルID
			int Comment_id = rs2.getInt("comment.id");
			record.setcomment_id(Comment_id);
			//ソングID
			int Comment_song_id = rs2.getInt("comment.song_id");
			record.setcomment_song_id(Comment_song_id);
			//シーケンス
			int Comment_sequence = rs2.getInt("comment.sequence");
			record.setcomment_sequence(Comment_sequence);
			//作曲家ID
			int Comment_composer_id = rs2.getInt("comment.composer_id");
			record.setcomment_composer_id(Comment_composer_id);
			//文言
			String Comment_comment = rs2.getString("comment.comment");
			record.setcomment_comment(Comment_comment);
			//コメントタイプ
			int Comment_type = rs2.getInt("comment.type");
			record.setcomment_type(Comment_type);
			//元コメントID
			int Comment_to_comment_id = rs2.getInt("comment.to_comment_id");
			record.setcomment_to_comment_id(Comment_to_comment_id);
			//書き込み日時
			double Comment_write_datetime = rs2.getDouble("comment.write_datetime");
			record.setcomment_write_datetime(Comment_write_datetime);
			//総感動指数
			double Rating_rating = rs2.getDouble("rating.rating");
			record.setrating_rating(Rating_rating);
			//ユニークコード
			String Composer_unique_code = rs2.getString("composer.unique_code");
			record.setcomposer_unique_code(Composer_unique_code);
			//ニックネーム
			String Composer_nickname = rs2.getString("composer.nickname");
			record.setcomposer_nickname(Composer_nickname);

			commentRatingRecordList.add(record);
		}
		// (4) ResultSetのインスタンス、PreparedStatementのインスタンスをクローズする。
		pstmt.close();

		// (5) 前処理で生成したListを呼び出し元に返却する。
		return commentRatingRecordList;

	}
	
	
}
