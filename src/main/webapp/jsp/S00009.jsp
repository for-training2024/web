<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>専用アプリダウンロード</title>
<link rel="stylesheet" type="text/css" href="/web/CSS/main.css">
<link rel="stylesheet" type="text/css" href="/web/CSS/S00009.css">
<script src="/web/js/jquery-3.3.0.min.js"></script>
<script src="/web/js/S00002.js"></script>

</head>
<body>
	<!-- メニューのキャンセルレイヤの起点 -->
	<div id="layer_marker"></div>
	<div class="wrapper">

		<!-- タイトルバー -->
		<div class="title_bar">
			<p class="page_title">アプリダウンロード</p>
			<a href="#" id="menu_open"> <img alt="メニュー"
				src="/web/image/menu.png" class="menu-icon">
			</a>
		</div>

		<!-- メニューの起点 -->
		<div id="menu_marker"></div>

		<!-- サーブレットで取得した文言を表示 -->
		<p class="ap">
			<%=request.getAttribute("wording")%>
		</p>

		<!-- アプリの画像とリンクを追加 -->
		<div class="asd">
			<a href="https://itunes.apple.com/jp/app/id1440134774?mt=8"
				target="_blank"> <img alt="メロコ～専用アプリダウンロード画面へ"
				src="/web/image/melokoIcon.png" class="app-icon">
			</a> <br> <a
				href="https://itunes.apple.com/jp/app/id1440134774?mt=8"
				target="_blank"> <img alt="メロコ～専用アプリダウンロード画面へのリンク"
				src="/web/image/applestore.png" class="apple-store">
			</a>
		</div>

		<!-- ページトップへjavaScript -->
		<div id="pagetop" hidden>
			<img  src="/web/image/pagetop.png">
		</div>

		<!-- フッター -->
		<div id="FT">
			<footer>
				Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All
				Rights Reserved.
			</footer>
		</div>
	</div>
</body>
</html>