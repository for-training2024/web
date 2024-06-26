package jp.excd.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S00009 extends HttpServlet{

	public void doGet( 
			HttpServletRequest request,			
			HttpServletResponse response)		
					throws IOException, ServletException{				

		Connection con = null;
		request.setCharacterEncoding("UTF-8");

		String dbName = "meloko";
		String userName = "meloko";
		String password = "exceed";
		String timeZone = "Asia/Tokyo";

		try {
			//DB接続（コネクション）の確率
			con = MySQLSetting.getConnection(dbName, userName, password, timeZone);

			String URL = request.getRequestURI();

			//接続URLが「/ja/S00009」以外の場合は、404.jspへフォワーディングする。
			if ("/web/ja/S00009".equals(URL)) {

			}else {
				getServletConfig().getServletContext().
				getRequestDispatcher("/jsp/404.jsp").
				forward(request, response);
			}

			String wording = null;

			String gsp = request.getServletPath();
			String[] sp = gsp.split("/");
			String language = sp[1];

			//サーブレットパスから取得した値が"ja"なら、getDescriptionメソッドでDBから文言を取得する。"ja"以外の場合、""（空白）を入れる。
			if("ja".equals(language)) {
				try {
					wording = getDescription(con, "DS00009_001");

				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else {
				wording = "";
			}
			
			//取得した文言をsetする。
			request.setAttribute("wording", wording);
			
		//例外をキャッチした場合、500.jspへ遷移する。
		}catch (SQLException e){
			e.printStackTrace();
			getServletConfig().getServletContext().
			getRequestDispatcher("/jsp/500.jsp").
			forward(request, response);

		}finally {
			try {
				if (con != null) {

					//接続したコネクションの切断を行う。
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				getServletConfig().getServletContext().
				getRequestDispatcher("/jsp/500.jsp").
				forward(request, response);
			}
		}		
		//S00009.jspへフォワーディングする。
		getServletConfig().getServletContext().
		getRequestDispatcher("/jsp/S00009.jsp" ).
		forward( request, response );

	}

	public void doPost( 
			HttpServletRequest request,			
			HttpServletResponse response)		
					throws IOException, ServletException{

		//POST遷移の場合、404.jspへフォワーディングする。
		getServletConfig().getServletContext().
		getRequestDispatcher("/jsp/404.jsp").
		forward(request, response);
	}


	//文言マスタより引数で渡されたkeyをIDにもつレコードを取得
	private String getDescription(Connection con, String description_id) 
			throws Exception {

		String ret = null;
		String sql = "select description from mst_description where description_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, description_id);
		ResultSet rs = pstmt.executeQuery();

		if(rs.next()) {
			ret = rs.getString("description");
		}

		rs.close();
		pstmt.close();
		return ret;
	}		
}
