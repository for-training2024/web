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

import jp.excd.bean.ComposerRecord;
import jp.excd.bean.SongRecord;

public class S00004 extends HttpServlet{
	public  void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
					throws IOException, ServletException{
		
		String URI = request.getRequestURI();
		if ("/web/ja/S00004/search".equals(URI)) {
		}else {
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		}
		request.setCharacterEncoding("UTF-8");
		
		String hostName ="192.168.12.200";
		String dbName = "meloko";
		String userName ="meloko";
		String password ="exceed";
		String TimeZone ="Asia/Tokyo";
		
		final String URL = "jdbc:mysql://"
				+hostName
				+":3306/"
				+dbName
				+"?serverTimezone="
				+TimeZone
				+"&allowPublicKeyRetrival=true"
				+"&useSSL=false";
		
		Connection con = null;

		try {
			//DB接続(コネクションの確立)
			con = MySQLSetting.getConnection(dbName, userName, password, TimeZone);
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/500.jsp").forward(request, response);
		
		
		String comsql ="SELECT composer_id, unique_code, nickname, joined_date, gender, birthday, listener_count, "
				+ "language_type, message, fb_link, tw_link, other_link_url, other_link_description "
				+ "FROM composer WHERE unique_code = ?;";
		
		String sosql ="SELECT song_id, title, composer_id, rating_total,  rating_average, total_listen_count,  "
				+ "release_datetime, last_update_datetime, message, key, score_type, bpm, image_file_name, image_file_height, "
				+ "image_file_width, other_link_url, other_link_description FROM song WHERE composer_id = ?;";
		
		
		// プリペアドステートメント
		PreparedStatement pstmt = null;

		 
		ResultSet rs = null;
		
		try {
			// (4)
			pstmt = con.prepareStatement(comsql);
			
			//(5) ?にunique_codeをセット
			
			
			
			// (6)
			rs = pstmt.executeQuery();
			List<ComposerRecord> comList = new ArrayList<ComposerRecord>();
			
			while(rs.next()) {
				ComposerRecord record = new ComposerRecord(
						rs.getString("song_id"),
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
						rs.getString("other_link_description")
						);
				
			comList.add(record);
				
			}
			
//			まだ使わない↓
			request.setAttribute("Composer",comList);
			
			pstmt.close();
			rs.close();
			
			
		}catch(SQLException e1) {
			e1.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		}
			
		try {
			pstmt = con.prepareStatement(sosql);
			rs = pstmt.executeQuery();
			List<SongRecord> songList = new ArrayList<SongRecord>();
			
			int count = 0;
			
			while(rs.next()) {
				count = count + 1;
				SongRecord record1 = new SongRecord(
						rs.getString("song_id"),
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
						rs.getString("other_link_description")
						);
				
			songList.add(record1);
				
			}
			
			
			String counter= NumberFormat.getNumberInstance().format(count);
			request.setAttribute("hits", count);
			request.setAttribute("songList", songList);
			pstmt.close();
			rs.close();
			
			
		}catch(SQLException e2) {
			e2.printStackTrace();
			getServletConfig().getServletContext().getRequestDispatcher("/jsp/404.jsp").forward(request, response);
		}
		
		
		}
		
	}


}
