<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.excd.bean.S00003Record"%>
<%@ page import="jp.excd.bean.CommentRatingRecord"%>
<!DOCTYPE html>
<html lang="ja">

<html>
<%
	List<S00003Bean> songs = (List<S00003Record>) request.getAttribute("list");
	List<CommentRatingBean> songs = (List<CommentRatingRecord>) request.getAttribute("list");

%>
<head>
<meta charset="utf-8">
<%
					for (S00003Bean s3Bean : songs) {
				%>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
  <title><%=s3Bean.getTitle()%></title>
  <link rel="stylesheet" href="../css/main.css">
  <script src="../js/jquery-3.3.0.min.js"></script>
  <script src="../js/util.js"></script>
<!-- 画像の圧縮表示設定 -->
<style>
div.song_link div.cell div.song1 img {
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

    <!-- タイトルバー -->
    <div class="title_bar">
      <p class="page_title"><%=s3Bean.getTitle()%></p>
      <a href="#" id="menu_open">
        <img alt="メニュー" src="../images/menu.png" class="menu-icon">
      </a>
    </div>

    <!-- メニューの起点 -->
    <div id="menu_marker">
    </div>

    <!-- 曲名 -->
    <div class="double_rows_table">
      <table>
        <tr>
          <td class="label">曲名</td>
          <td><%=s3Bean.getTitle()%></td>
        </tr>
      </table>
    </div>

    <!-- 作者へのリンク -->
    <div class="label_and_link">
      <span class="label">作者：</span><span class="link"><a href="https://www/web/ja/S00004/<%=record.getUnique_code()%>"><%=record.getNickname()%></a></span>
    </div>
    
    <!-- メッセージ -->
    <div class="single_row_table">
      <table>
        <tr>
          <td class="label">メッセージ</td>
        </tr>
        <tr>
          <td><%=record.getMessage()%></td>
        </tr>
      </table>
    </div>

    <!-- 曲画像リンク -->
    <div class="song_link">
      <div class="cell">
        <div class="image_base">
          <a href="meloko://?song_id=256">
            <div class="image song1">
              <img alt="希望の扉" src="../images/tsugumi_01.jpg">
              <img alt= "play" class="play" src="../images/play.png">
            </div>
          </a>
        </div>
      </div>
    </div>

    <!-- 情報 -->
    <div class="single_row_table">
      <table>
        <tr>
          <td class="label">情報</td>
        </tr>
        
        <tr>
          <td class="value">
            <span class="label_top">総感動指数：</span><span><%=s3Bean.getRating_total()%></span>
            <span class="label">平均感動指数：</span><span><%=s3Bean.getRating_average_formated()%></span>
            <span class="label">再生回数：</span><span><%=s3Bean.getTotal_listen_count_formated()%></span>
            <span class="label">公開：</span><span><%=s3Bean.getRelease_datetime_fomated()%></span>
            <span class="label">最終更新日：</span><span><%=s3Bean.getLast_update_datetime_formated()%></span>
            <span class="label">KEY：</span><span><%=s3Bean.getScore_type_formated()%></span>
            <span class="label">楽譜表記：</span><span><%=s3Bean.getScore_type_formated()%></span>
            <span class="label">BPM：</span><span><%=s3Bean.getBpm()%></span>

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
          <td class="value"> <!-- 関連リンクUrL -->
            <a href="<%=s3Bean.getOther_link_url()%>"><%=s3Bean.getother_link_description()%></a>
          </td>
        </tr>
      </table>
    </div>

    <!-- コメントテーブルのヘッダー -->
    <div class="sub_header">
      <p>この曲についたコメント</p>
    </div>

    <!-- コメントテーブル -->
 <%   List<List<String>> results = (List<List<String>>)request.getAttribute("result");%>
    <div class="comments">
      <ul>
<%
					for (CommentRatingBean crBean : songs) {
				%>
        <li>
          <div class="normal">
            <div class="rating star45"></div>
            <div class="composer_link"><a href="https://www/web/ja/S00004/<%=crBean.getcomposer_unique_code()%>"><%=crBean.getComposer_nickname()%></a></div>
            <p class="comment"><%=crBean.getcomment_comment()%></p>
            <p class="time"><%=crBean.getcomment_write_datetime()%></p>
          </div>
        </li>


        <li>
          <div class="normal">
            <div class="rating star50"></div>
            <div class="composer_link"><a href="S00004.html">吟遊詩人</a></div>
            <p class="comment">スプーンドラゴンさんの曲はいつも聞いています。</p>
            <p class="time">2週間前</p>
          </div>
        </li>

        <li>
          <div class="reply">
            <div class="grater_than">&gt;</div>
            <div class="composer_link_no_rating"><a href="S00004.html">スプーンドラゴン</a></div>
            <p class="comment">吟遊詩人さんありがとうございます。吟遊詩人さんの新曲も心待ちにしています。</p>
            <p class="time">1週間前</p>
          </div>
        </li>

        <li>
          <div class="reply">
            <div class="grater_than">&gt;</div>
            <div class="rating star40"></div>
            <div class="composer_link"><a href="S00004.html">吟遊詩人</a></div>
            <p class="comment">今、練りに練っているところなので、ちょっと待ってください。</p>
            <p class="time">6日間前</p>
          </div>
        </li>

        <li>
          <div class="normal">
            <div class="rating star40"></div>
            <div class="composer_link"><a href="S00004.html">John Lennon</a></div>
            <p class="comment">It's cool!</p>
            <p class="time">5日前</p>
          </div>
        </li>


        <li>
          <div class="normal">
            <div class="rating star40"></div>
            <div class="composer_link"><a href="S00004.html">Steve Smith</a></div>
            <p class="comment">So tender Melody!<br>I love this Song!</p>
            <p class="time">4日前</p>
          </div>
        </li>

        <li>
          <div class="normal">
            <div class="rating star10"></div>
            <div class="composer_link"><a href="S00004.html">クレーマー</a></div>
            <p class="comment">So tender Melody!<br>これ曲っていうの？？？</p>
            <p class="time">たった今</p>
          </div>
        </li>


      </ul>
    </div>


    <!-- ページトップへjavaScript -->
    <div id="pagetop" hidden>
      <img alt="ページトップ" src="../images/pagetop.png">
    </div>

    <!-- フッター -->
    <footer>
      Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All Rights Reserved.
    </footer>

  </div>
</body>
</html>
