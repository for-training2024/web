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

import jp.excd.Util.Transform;
import jp.excd.bean.ComposerRecord;
import jp.excd.bean.S00004SongBean;
import jp.excd.bean.SongRecord;

public class S00004 extends HttpServlet {
	
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

		request.setCharacterEncoding("UTF-8");

		String dbName = "meloko";
		String userName = "meloko";
		String password = "exceed";
		String TimeZone = "Asia/Tokyo";

		Connection con = null;

		try {
			//DB接続(コネクションの確立)
			con = MySQLSetting.getConnection(dbName, userName, password, TimeZone);

			this.main(request, response, con);

		} catch (Exception e) {
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);
			
		} finally {
				//コネクションのクローズ
				try {
					if(con != null) {
						con.close();
					}
				}catch(SQLException e){
					e.printStackTrace();
					getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);
					return;
				}
				
			}
		}

	

	private void main(HttpServletRequest request,
			HttpServletResponse response, Connection con)
			throws Exception, IOException {
		{
			S00004SongBean songBean = new S00004SongBean();

			// 接続URL受け取り
			String url = request.getRequestURI().toString();

			// URLを解析して必要な部分を取得
			String[] parts = url.split("/");
			// 最後の部分を取得
			String urlunique_code = parts[parts.length - 1];

			// (1) 接続URLが「/ja/S00004searh」以外の場合は、404.jspへフォワーディングする。
			if (("/web/ja/S00004/" + urlunique_code).equals(url)) {

			} else {
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
				return;
			}

			String comsql = "SELECT id, unique_code, nickname, joined_date, gender, birthday, listener_count, "
					+ "language_type, message, fb_link, tw_link, other_link_url, other_link_description "
					+ "FROM composer WHERE unique_code = ?;";

			String sosql = "SELECT id, title, composer_id, rating_total,  rating_average, total_listen_count,  "
					+ "release_datetime, last_update_datetime, message, \"key\", score_type, bpm, image_file_name, image_file_height, "
					+ "image_file_width, other_link_url, other_link_description FROM song WHERE composer_id = ? ORDER BY id;";

			// プリペアドステートメント
			PreparedStatement pstmt = null;

			ResultSet rs = null;

			try {
				// (4)
				pstmt = con.prepareStatement(comsql);

				//(5) ?にunique_codeをセット

				String unique_code = request.getPathInfo();
				unique_code = unique_code.substring(1);
				//System.out.println(unique_code);
				pstmt.setString(1, unique_code);

				// (6)
				rs = pstmt.executeQuery();
				ComposerRecord comRrecord = null;
				if (rs.next()) {
					comRrecord = new ComposerRecord(
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

				
					songBean.setcomposer_id(comRrecord.composer_id());

					songBean.setUnique_code(comRrecord.unique_code());

					songBean.setNickname(comRrecord.nickname());

					String joined_date_formated = Transform.conDate(comRrecord.joined_date());
					songBean.setJoined_date_formated(joined_date_formated);

					String Gender_formated = Transform.getGender(comRrecord.gender());
					songBean.setGender_formated(Gender_formated);

					String Birthday_formated = Transform.conBirthday(comRrecord.birthday());
					songBean.setBirthday_formated(Birthday_formated);

					String Listener_count_formated = Transform.conComma(comRrecord.listener_count());
					songBean.setListener_count_formated(Listener_count_formated);

					String Language_type = Transform.getLanguage_type(comRrecord.language_type());
					songBean.setLanguage_type(Language_type);

					songBean.setmessage(comRrecord.message());

					songBean.setFb_link(comRrecord.fb_link());

					songBean.setTw_link(comRrecord.tw_link());

					songBean.setother_link_url(comRrecord.other_link_url());

					songBean.setother_link_description(comRrecord.other_link_description());

				}else {
					//データが取れなかった場合、404.jspに遷移
					getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);

				}

				//			まだ使わない↓
				request.setAttribute("Composer",songBean);
				pstmt.close();
				rs.close();
				
				
				
				
				//songテーブルから取得
				pstmt = con.prepareStatement(sosql);

				//(5) ?にunique_codeをセット

				String composer_id = comRrecord.composer_id();
				System.out.println(sosql);
				pstmt.setString(1, composer_id);

				// (6)
				rs = pstmt.executeQuery();
				List<SongRecord> songList = new ArrayList<SongRecord>();

				int count = 0;
				long count1 = 0;
				long count2 = 0;
				Double count3 = (double) 0;
				
				while (rs.next()) {
					count = count + 1;
					count1 = count1 + rs.getLong("total_listen_count");
					count2 = count2 + rs.getLong("rating_total");
					count3 = count3 + rs.getDouble("rating_average");
					
					SongRecord SongRecord = new SongRecord(
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

					songList.add(SongRecord);

				}
				
				count3 = count3 / count;
				List<S00004SongBean> songBeanList = new ArrayList<S00004SongBean>();
				
				for (SongRecord SongRecord : songList) {
					S00004SongBean songBean2 = new S00004SongBean();

					songBean2.setsong_id(SongRecord.song_id());

					songBean2.settitle(SongRecord.title());

					songBean2.setcomposer_id(SongRecord.composer_id());

					String rating_total_formated = Transform.conComma(SongRecord.rating_total());
					songBean2.setrating_total_forated(rating_total_formated);

					String rating_average_formated = Transform.conThree(SongRecord.rating_average());
					songBean2.setrating_average_formated(rating_average_formated);

					String total_listen_count_formated = Transform.conComma(SongRecord.total_listen_count());
					songBean2.settotal_listen_count_formated(total_listen_count_formated);

					String release_datetime_formated = String.valueOf(SongRecord.release_datetime());
					songBean2.setrelease_datetime_formated(release_datetime_formated);

					String last_update_datetime_formated = Transform
							.getLastUploadTime(SongRecord.last_update_datetime());
					songBean2.setrelease_datetime_formated(last_update_datetime_formated);

					songBean2.setmessage(SongRecord.message());

					songBean2.setkey_formated(SongRecord.key());

					String score_type_formated = Transform.getScore_type(SongRecord.score_type());
					songBean2.setscore_type_formated(score_type_formated);

					songBean2.setbpm(SongRecord.bpm());

					songBean2.setimage_file_name(SongRecord.imege_file_name());

					songBean2.setimage_file_height(SongRecord.image_file_height());

					songBean2.setimage_file_width(SongRecord.image_file_width());

					songBean2.setother_link_url(SongRecord.other_link_url());

					songBean2.setother_link_description(SongRecord.other_link_description());

					songBeanList.add(songBean2);
					
				}

				String Count1 =Transform.conComma(count1);
				request.setAttribute("composer_total_listen_count", Count1);
				
				String Count2 = Transform.conComma(count2);
				request.setAttribute("composer_rating_total", Count2);
				
				String Count3 = Transform.conThree(count3);
				request.setAttribute("composer_rating_average", Count3);
				
				request.setAttribute("hits", count);
				request.setAttribute("songList", songBeanList);
				pstmt.close();
				rs.close();
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/S00004.jsp").forward(request, response);

			} catch (SQLException e2) {
				e2.printStackTrace();
				getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
			}

		}

	}

}
