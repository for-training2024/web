<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">

 
  <link rel="stylesheet" href="../../CSS/S00002.css">
  <script src="../../js/jquery-3.3.0.min.js"></script>
  <script type="text/javascript" src="../../js/S00002.js"></script>


</head>
<body>
	<!-- メニューのキャンセルレイヤの起点 -->
	<div id="layer_marker">
	<div id="layer"></div>
	</div>
	<!-- タイトルバーの起点 -->
	<div class="title_bar">
		<a href="#" id="menu_open"> <img alt="メニュー" class="menu-icon"
			src="../../image/menu.png">
		</a>
	</div>
	<div id="menu_marker">
		<div class="menu_base">
			<div class="menu_header">
				<p>メニュー</p>
				<a id="menu_close" href="#">×CLOSE</a>
			</div>

			<ul>
				<li><a href="/web/ja/S00001.jsp">
						<p>HOME</p> <img alt="HOME" class="right_arrow"
						src="../../image/right_arrow.png">
				</a></li>

				<li><a href="/web/ja/S00005.jsp">
						<p>作品検索</p> <img alt="作品検索" class="right_arrow"
						src="../../image/right_arrow.png">
				</a></li>

				<li><a href="/web/ja/S00007.jsp">
						<p>作曲家検索</p> <img alt="作曲家検索" class="right_arrow"
						src="../../image/right_arrow.png">
				</a></li>

				<li><a href="/web/ja/S00009.jsp">
						<p>専用アプリダウンロード</p> <img alt="専用アプリダウンロード" class="right_arrow"
						src="../../image/right_arrow.png">
				</a></li>

				<li><a href="https://excd.jp">
						<p class="to_excd">運営会社 </p>
						<img alt="運営会社" class="pop_up" src="../../image/return.png">
				</a></li>

			</ul>
		</div>
	</div>
</body>
</html>