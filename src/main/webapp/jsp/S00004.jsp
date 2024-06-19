<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="jp.excd.bean.S00004SongBean" %>
<!DOCTYPE html>
<html lang="ja">
<html>
<%
	S00004SongBean composer = (S00004SongBean)request.getAttribute("Composer");
	List<S00004SongBean> songs = (List<S00004SongBean>)request.getAttribute("songList");
%>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
  <title>作曲家紹介</title>
  <link rel="stylesheet" href="../../CSS/main.css">
  <script src="../../js/jquery-3.3.0.min.js"></script>
  <script src="../../js/S00002.js"></script>
</head>
<body>
 <!-- メニューのキャンセルレイヤの起点 -->
  <div id="layer_marker">
  </div>

  <div class="wrapper">

    <!-- タイトルバー -->
    <div class="title_bar">
      <p class="page_title">作曲家紹介</p>
      <a href="#" id="menu_open">
         <img alt="メニュー" class="menu-icon"
			src="../../image/menu.png">
      </a>
    </div>

    <!-- メニューの起点 -->
    <div id="menu_marker">
    </div>
       <div class="double_rows_table">
      <table>
        <tr>
          <td class="label">ID</td>
          <td class="value"> <%=composer.getUnique_code() %></td>
        </tr>
        <tr>
          <td class="label">ニックネーム</td>
          <td class="value"><%=composer.getNickname() %></td>
        </tr>
      </table>
    </div>
    
    <!-- メッセージ -->
    <div class="single_row_table">
      <table>
        <tr>
          <td class="label">メッセージ</td>
        </tr>
        <tr>
          <td class="value"><%=composer.getmessage() %></td>
        </tr>
      </table>
    </div>

    <!-- プロフィール -->
    <div class="single_row_table">
      <table>
        <tr>
          <td class="label">プロフィール</td>
        </tr>
        <tr>
          <td class="value">
            <span class="label_top">性別：</span>
            <span class="value"><%=composer.getGender_formated() %></span>
            <span class="label">誕生日：</span>
            <span class="value"><%=composer.getBirthday_formated() %></span>
            <br>
            <span class="label_top">FB：</span>
            <span class="value"><a href="https://google.co.jp"><%=composer.getFb_link() %></a></span>
            <br>
            <span class="label_top">Twitter：</span>
            <span class="value"><a href="https://google.co.jp"><%=composer.getTw_link() %></a></span>
          </td>
        </tr>
      </table>
    </div>

    <!-- 情報 -->
    <div class="single_row_table">
      <table>
        <tr>
          <td class="label">情報</td>
        </tr>
        <tr>
          <td class="value">
            <span class="label_top">登録：</span>
            <span class="value"><%=composer.getJoined_date_formated() %></span>
            <br>

            <span class="label_top">作品数：</span>
            <span class="value"><%=request.getAttribute("hits") %></span>
            <br>

            <br>

          </td>
        </tr>
      </table>
    </div>

    <!-- 関連リンク -->
    <div class="single_row_table">
      <table>
        <tr>
          <td class="label">関連リンク</td>
        </tr>
        <tr>
          <td class="value">
            <a href="https://google.co.jp"><%=composer.getother_link_url() %></a>
          </td>
        </tr>
      </table>
    </div>

    <!-- 公開曲一覧のヘッダー -->
    <div class="sub_header">
      <p>公開曲一覧</p>
    </div>

    <!-- ソングテーブル -->
    <div class="song_list">
      <ul>

<% 
System.out.println(songs);
for (int i=0; i<songs.size(); i++) { %>
        <li>
          <div class="cell">
            <div class="song_title"><%=songs.get(i).gettitle() %></div>
            <div class="image_base">
              <a href="web/ja/S00003/<%= songs.get(i).getsong_id() %>">
                <div class="image song1">
                  <img src="<%=songs.get(i).getimage_file_name() %>" class="trimc" alt="">
                  <img alt= "play" class="play" src="../../image/play.png">
                  
                </div>
              </a>
            </div>
            <div class="detail">
              <span class="label_top">総感動指数：</span>
              <span class="value"><%=songs.get(i).getrating_total_formated() %></span>
              <span class="label">平均感動指数：</span>
              <span class="value"><%=songs.get(i).getrating_average_formated() %></span>
              <span class="label">再生回数：</span>
              <span class="value"><%=songs.get(i).gettotal_listen_count_formated() %></span>
              <span class="label">公開：</span>
              <span class="value"><%=songs.get(i).getrelease_datetime_formated() %></span>
            </div>
          </div>
        </li>
<%
	}
%>

      </ul>
    </div>


    <!-- ページトップへjavaScript -->
    <div id="pagetop" hidden>
      <img alt="ページトップ" src="../../image/pagetop.png">
    </div>

    <!-- フッター -->
    <footer>
      Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All Rights Reserved.
    </footer>
    </div>
</body>
</html>