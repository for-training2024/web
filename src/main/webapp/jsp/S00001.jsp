<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"			
%>
<%@ page import="java.util.*"%>
<%@ page import="jp.excd.bean.ExSongBean"%>
<%@ page import="jp.excd.bean.ExSongRecord"%>

<!DOCTYPE html>
<html lang="ja">
<%
	List<ExSongBean> songs = (List<ExSongBean>) request.getAttribute("list");
%>

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
  <title>音楽室</title>
  <link rel="stylesheet" href="../CSS/main.css">
  <script src="../js/jquery-3.3.0.min.js"></script>
  <script src="../js/S00002.js"></script>
  <script src="../js/S00001.js"></script>
  
<!-- 画像の圧縮表示設定 -->
<style>
div.song_list ul li div.cell div.song1 img {
    position: relative;
    left: 0px;
    top: -11px;
    width :275px;
    height :182px;
}

</style>
</head>
<body>
  <!-- メニューのキャンセルレイヤの起点 -->
  <div id="layer_marker">
  </div>

  <div class="wrapper">

    <!-- トップバナー -->
    <div class="top_banner">
      <a href=https://itunes.apple.com/jp/app/id1440134774?mt=8>
        <img alt="メロコ～iPhone用作曲アプリアイコン" src="../image/melokoIcon.png" class="icon">
        <p><%=request.getAttribute("description") %></p>
        <img alt="メロコ～専用アプリダウンロード画面へのリンク" src="../image/right_blue_arrow.png" class="to_download_page_arrow">
      </a>
    </div>

    <!-- タイトルバー -->
    <div class="title_bar">
      <p class="main_title">音楽室</p>
      <p class="sub_title">～作曲家たちのコミュニティー～</p>
      <a href="#" id="menu_open">
        <img alt="メニュー" src="../image/menu.png" class="menu-icon">
      </a>
    </div>
    
    <!-- メニューの起点 -->
    <div id="menu_marker">
    </div>
    
    <!-- トップタブ -->
    <div class="top_tab">
      <ul>
        <li class="tab1 "><a href="http://localhost:8080/web/ja/S00001?category=1">新着</a></li>
        <li class="tab2 "><a href="http://localhost:8080/web/ja/S00001?category=2">人気</a></li>
        <li class="tab3 "><a href="http://localhost:8080/web/ja/S00001?category=3">高評価</a></li>
        <li class="tab4 "><a href="http://localhost:8080/web/ja/S00001?category=4">名作</a></li>
      </ul>
    </div>

    <!-- トップ告知 -->

	<%
    	String notice = (String)request.getAttribute("notice");
    	if (notice != "" && notice != null){
   			out.println("<div class=\"top_notice\">");
   			out.println("<p class=\"top_notice_title\">告知</p>");
   			out.println("<p class=\"top_notice_body\">" + notice + "</p>");
   			out.println("</div>");
    	}
	%>
    <!-- ソングテーブル -->
    <div class="song_list">
      <ul>
		<%  
			int from = (Integer)request.getAttribute("from");
			int count = (Integer)request.getAttribute("count");
			if (from<=count) {
				for (int i=from-1; i<= from+3; i++) {
					if(i >= songs.size()-1){
						break;
					}
		%>
			
        <li>
          <div class="cell">
            <div class="song_title"><%=songs.get(i).getTitle() %></div>
            <div class="composer">
              <span class="label_top">作曲：</span>
              <span class="composer_link"><a href="http://localhost:8080/web/ja/S00004/<%=songs.get(i).getunique_code()%>"><%=songs.get(i).getnickname() %></a></span>
            </div>
            <div class="image_base">
              <a href="http://localhost:8080/web/ja/S00003/<%=songs.get(i).getSong_id()%>">
                <div class="image song1">
                  <img alt="<%=songs.get(i).getTitle() %>" src="
                  <% if(songs.get(i).getImage_file_name() == null){%>
                	  ../image/noimage.png
                  <%} else{%>
                	  <%=songs.get(i).getImage_file_name()%>
                  <%}%>">
                  <img alt= "play" class="play" src="../image/play.png">
                </div>
              </a>
            </div>
            <div class="detail">
              <span class="label_top">総感動指数：</span>
              <span class="value"><%=songs.get(i).getRating_total_formated() %></span>
              <span class="label">平均感動指数：</span>
              <span class="value"><%=songs.get(i).getRating_average_formated() %></span>
              <span class="label">再生回数：</span>
              <span class="value"><%=songs.get(i).getTotal_listen_count_formated() %></span>
              <span class="label">公開：</span>
              <span class="value"><%=songs.get(i).getRelease_datetime_formated() %></span>
            </div>
          </div>
        </li>
		<%
			
				}
			}
		%>
      </ul>
    </div>

    <!-- メインボタン -->
    
	<% 
		if((Integer)request.getAttribute("from")<=(Integer)request.getAttribute("count")-6) {
			out.println("<div class=\"main_button\">");
 		   	out.println("<a href=\""+ request.getAttribute("loadMore") + "\">さらに読み込む</a>");
 		   	out.println("</div>");    	
 		}
 	%>
    
    <!-- ページトップへjavaScript -->
    <div id="pagetop" hidden>
      <img alt="ページトップ" src="../image/pagetop.png">
    </div>

    <!-- フッター -->
    <footer>
      Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All Rights Reserved.
    </footer>

  </div>
</body>
</html>