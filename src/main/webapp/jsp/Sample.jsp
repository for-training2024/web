<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"			
%><!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ" />
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
  <title>音楽室</title>
</head>
<body>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="../../CSS/main.css">
 <script src="../../js/jquery-3.3.0.min.js"></script>
 <script type="text/javascript" src="../../js/S00002.js"></script>
</head>
<body>
    <!-- メニューのキャンセルレイヤの起点 -->
 <div id="layer_marker">
 </div>
 <div class="wrapper">
   <!-- タイトルバー -->
   <div class="title_bar">
     <p class="page_title">希望のとびら</p>
     <a href="#" id="menu_open">
        <img alt="メニュー" class="menu-icon"
   		src="../../image/menu.png">
     </a>
   </div>
   <!-- メニューの起点 -->
   <div id="menu_marker">
   </div>
   </div>
  <% String count = (String)request.getAttribute("count");
  if (( count != null )&&( !count.equals(""))) {
	  %><p>Success!</p><%
  } else {
	  %><p>mst_description not founc!</p><%
  }
  %>
</body>
</html>
