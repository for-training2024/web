<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.excd.bean.SongBean"%>
<!DOCTYPE html>
<html>
<%
	List<SongBean> songs = (List<SongBean>) request.getAttribute("list");
	Integer hits = (Integer) request.getAttribute("hits");
%>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
<title>作品検索</title>
<link rel="stylesheet" href="/web/CSS/main.css" />
<link rel="stylesheet" href="/web/CSS/S5678.css" />
<script src="/web/js/jquery-3.3.0.min.js"></script>
<script type="text/javascript" src="/web/js/input.js"></script>
<script type="text/javascript" src="/web/js/S00002.js"></script>
</head>
<body>
  <!-- メニューのキャンセルレイヤの起点 -->
  <div id="layer_marker">
  </div>

  <div class="wrapper">

    <!-- タイトルバー -->
	<div class="title_bar">
	  <p class="page_title">
	  作品検索
		<button type="submit" form="formBack" id= "back" class="back" value="＜戻る">＜戻る</button>
      </p>
      
	  <a href="#" id="menu_open">
		<img alt="メニュー" src="/web/image/menu.png" class="menu-icon">
	  </a>
	</div>

		<!-- メニューの起点 -->
	<div id="menu_marker">
	</div>
    
	<!-- フォーム -->
	<form name="main" action="?" method="post">
	</form>
    
	<div class="message_with_right_button">
	<% if( hits > 10) {%>
	  <p><%=hits%>件が該当します。(うち10件を表示しています。)</p>
	<% }else{ %>
	  <p><%=hits%>件が該当します。</p>
	<% } %>
 	  <div class="right_button">
		<button type="submit" form="formChange" class="change" id="change" value="条件変更">条件変更</button>
	  </div>
	</div>

	<!-- ソングテーブル -->
	<div class="song_list">
	  <ul>
		
		<% for (SongBean bean : songs) { %>
		<li>
 		  <div class="cell">
			<div class="song_title"><%=bean.getTitle()%></div>
			<div class="image_base">
			  <a href="/web/ja/S00003/<%= bean.getSong_id()%>">
				<div class="image song1">

<%
				double width = 0;
				double x = 0;
				double y = 0;
				int height = 0;
				int top = 0;

				width = 275;
				x = width / (bean.getImage_file_width());
				y = (bean.getImage_file_height()) * x;
				height = (int) y;
				top = height - 160;
				top = top / 2;
				
				String imageStyle ="'";
				imageStyle += "position: relative;";
				imageStyle += "left: 0px;";
				imageStyle += "width: 275px;";
				
				if (height > 160){
					imageStyle += "top: -" + top + "px;";
					imageStyle += "height:" + height + "px;";
				}else{
					imageStyle += "height:" + height + "px;";
				}
				imageStyle += "'";
%>

				<img src="<%if(bean.getImage_file_name() != null){%><%=bean.getImage_file_name()%>
				  <%}else if(bean.getImage_file_name() == null){%>/web/image/noimage.png<%}%>" class="trimc" alt="" style=<%=imageStyle%>>
				  <img alt= "play" class="play" src="/web/image/play.png">
				</div>
			  </a>
			</div>
			<div class="detail">
			  <span class="label_top">総感動指数:</span><span class="value"><%=bean.getRating_total_formated()%></span>
			  <span class="label">平均感動指数:</span><span class="value"><%=bean.getRating_average_formated()%></span><br>
			  <span class="label">再生回数</span><span class="value"><%=bean.getTotal_listen_count_formated()%></span>
			  <span class="label">公開:</span><span class="value"><%=bean.getRelease_datetime_formated()%></span>
			</div>
		  </div>
		</li>
		<%
			}
		%>
	  </ul>
	</div>
	<div class="main_button">
	  <button type="submit" form="formChange" id="change" class="change" value="条件変更">条件変更</button>
	</div>

	<form id="formBack" method="POST" action="/web/ja/S00006/back">
		<input name="release_date_radio" type="hidden" value="<%= request.getAttribute("release_date_radio") %>">
		<input name="release_date_from" type="hidden" value="<%= request.getAttribute("release_date_from") %>">
		<input name="release_date_to" type="hidden" value="<%= request.getAttribute("release_date_to") %>">
		<input name="rating_radio" type="hidden" value="<%= request.getAttribute("rating_radio") %>">
		<input name="rating_from" type="hidden" value="<%= request.getAttribute("rating_from") %>">
		<input name="rating_to" type="hidden" value="<%= request.getAttribute("rating_to") %>">
		<input name="rating_average_radio" type="hidden" value="<%= request.getAttribute("rating_average_radio") %>">
		<input name="rating_average_from" type="hidden" value="<%= request.getAttribute("rating_average_from") %>">
		<input name="rating_average_to" type="hidden" value="<%= request.getAttribute("rating_average_to") %>">
		<input name="views_radio" type="hidden" value="<%= request.getAttribute("views_radio") %>">
		<input name="views_from" type="hidden" value="<%= request.getAttribute("views_from") %>">
		<input name="views_to" type="hidden" value="<%= request.getAttribute("views_to") %>">
		<input name="title_radio" type="hidden" value="<%= request.getAttribute("title_radio") %>">
		<input name="title_type_radio" type="hidden" value="<%= request.getAttribute("title_type_radio") %>">
		<input name="title" type="hidden" value="<%= request.getAttribute("title") %>">
		<input name="sort_order" type="hidden" value="<%= request.getAttribute("sort_order") %>">
		<input name="hits" type="hidden" value="<%= request.getAttribute("hits") %>">
		<input name="list" type="hidden" value="<%= request.getAttribute("list") %>">
		
	</form>
	<form id="formChange" method="POST" action="/web/ja/S00006/change">
		<input name="release_date_radio" type="hidden" value="<%= request.getAttribute("release_date_radio") %>">
		<input name="release_date_from" type="hidden" value="<%= request.getAttribute("release_date_from") %>">
		<input name="release_date_to" type="hidden" value="<%= request.getAttribute("release_date_to") %>">
		<input name="rating_radio" type="hidden" value="<%= request.getAttribute("rating_radio") %>">
		<input name="rating_from" type="hidden" value="<%= request.getAttribute("rating_from") %>">
		<input name="rating_to" type="hidden" value="<%= request.getAttribute("rating_to") %>">
		<input name="rating_average_radio" type="hidden" value="<%= request.getAttribute("rating_average_radio") %>">
		<input name="rating_average_from" type="hidden" value="<%= request.getAttribute("rating_average_from") %>">
		<input name="rating_average_to" type="hidden" value="<%= request.getAttribute("rating_average_to") %>">
		<input name="views_radio" type="hidden" value="<%= request.getAttribute("views_radio") %>">
		<input name="views_from" type="hidden" value="<%= request.getAttribute("views_from") %>">
		<input name="views_to" type="hidden" value="<%= request.getAttribute("views_to") %>">
		<input name="title_radio" type="hidden" value="<%= request.getAttribute("title_radio") %>">
		<input name="title_type_radio" type="hidden" value="<%= request.getAttribute("title_type_radio") %>">
		<input name="title" type="hidden" value="<%= request.getAttribute("title") %>">
		<input name="sort_order" type="hidden" value="<%= request.getAttribute("sort_order") %>">
		<input name="hits" type="hidden" value="<%= request.getAttribute("hits") %>">
		<input name="list" type="hidden" value="<%= request.getAttribute("list") %>">
	
	</form>


    <!-- ページトップへjavaScript -->
	<div id="pagetop" hidden>
	  <img alt="ページトップ" src="/web/image/pagetop.png">
	</div>

	<footer>
		<p>
		  Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All Rights Reserved.
		</p>

	</footer>

</body>
</html>