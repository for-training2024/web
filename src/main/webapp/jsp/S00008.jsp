<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.excd.bean.ComposerBean"%>
<!DOCTYPE html>
<html>
<%
List<ComposerBean> composers = (List<ComposerBean>) request.getAttribute("list");
String hits = (String) request.getAttribute("hits");
%>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>作曲家検索</title>
<link rel="stylesheet" href="/web/CSS/main2.css" />
<link rel="stylesheet" type="text/css" href="/web/CSS/S00008.css" />
<link rel="stylesheet" href="/web/CSS/S5678.css">
<script src="/web/js/jquery-3.3.0.min.js"></script>
<script type="text/javascript" src="/web/js/S00002.js"></script>
<script type="text/javascript" src="/web/js/S00008.js"></script>


</head>
<body>
	<!-- メニューのキャンセルレイヤの起点 -->
	<div id="layer_marker"></div>

	<div class="wrapper">

		<!-- タイトルバー -->
		<div class="title_bar">
			<p class="page_title">作曲家検索
			<button type="submit" form="formBack" id="back" class="back"
				value="戻る">＜戻る</button>

			<a href="#" id="menu_open"><img alt="メニュー"
				src="/web/image/menu.png" class="menu-icon"> </a>
			</p>
		</div>

		<!-- メニューの起点 -->
		<div id="menu_marker"></div>


		<!-- 検索結果表示 -->
		<div class="message_with_right_button">
			<p><%=hits%>件が該当します。
				<% 
					if( (int)request.getAttribute("listSize") > 10){
				%>
				(うち10件表示しています。)
				<% 
					}
				%>
			</p>
			<div class="right_button">

				<button type="submit" form="formChange" id="change" class="change"
					value="条件変更">条件変更</button>
			</div>
		</div>

		<!-- 作曲家テーブル -->
		<div class="composer_list">
			<ul>
				<%
				for (ComposerBean cb : composers) {
				%>
				<li>
					<div class="cell">
						
							<a href="../S00004/<%=cb.getUnique_code()%>" class ="composer_nickname"><%=cb.getNickname()%></a>
						
						<table class="detail">
							<tr>
								<td><span class="label">登録日：</span></td>
								<td><span><%=cb.getJoined_date_formated()%></span></td>
							</tr>
							<tr>
								<td><span class="label">性別：</span></td>
								<td><span><%=cb.getGender_formated()%></span></td>
							</tr>
							<tr>
								<td><span class="label">誕生日：</span></td>
								<td><span><%=cb.getBirthday_formated()%></span></td>
							</tr>
							<tr>
								<td><span class="label">リスナー数：</span></td>
								<td><span><%=cb.getListener_count_formated()%></span></td>
							</tr>
							<tr>
								<td><span class="label">言語：</span></td>
								<td><span><%=cb.getLanguage_type()%></span></td>
							</tr>
						</table>
					</div>
				</li>
				<%
				}
				%>
			</ul>
			<div class="main_button">
				<button type="submit" form="formChange" id="change" class="change"
					value="条件変更">条件変更</button>
			</div>
		</div>
	</div>

	<form id="formBack" method="POST" action="/web/ja/S00008/back">
		<%-- ここにフォームデータのhiddenフィールドを追加 --%>
		<input name="nickname_radio" type="hidden"
			value="<%=request.getAttribute("nickname_radio")%>"> <input
			name="nickname_type_radio" type="hidden"
			value="<%=request.getAttribute("nickname_type_radio")%>"> <input
			name="nickname" type="hidden"
			value="<%=request.getAttribute("nickname")%>"> <input
			name="joined_date_radio" type="hidden"
			value="<%=request.getAttribute("joined_date_radio")%>"> <input
			name="joined_date_from" type="hidden"
			value="<%=request.getAttribute("joined_date_from")%>"> <input
			name="joined_date_to" type="hidden"
			value="<%=request.getAttribute("joined_date_to")%>"> <input
			name="gender_radio" type="hidden"
			value="<%=request.getAttribute("gender_radio")%>"> <input
			name="gender" type="hidden"
			value="<%=request.getAttribute("gender")%>"> <input
			name="birthday_radio" type="hidden"
			value="<%=request.getAttribute("birthday_radio")%>"> <input
			name="birthday_from" type="hidden"
			value="<%=request.getAttribute("birthday_from")%>"> <input
			name="birthday_to" type="hidden"
			value="<%=request.getAttribute("birthday_to")%>"> <input
			name="listener_count_radio" type="hidden"
			value="<%=request.getAttribute("listener_count_radio")%>"> <input
			name="listener_count_from" type="hidden"
			value="<%=request.getAttribute("listener_count_from")%>"> <input
			name="listener_count_to" type="hidden"
			value="<%=request.getAttribute("listener_count_to")%>"> <input
			name="language_type_jp" type="hidden"
			value="<%=request.getAttribute("language_type_jp")%>"> <input
			name="language_type_en" type="hidden"
			value="<%=request.getAttribute("language_type_en")%>"> <input
			name="sort_order" type="hidden"
			value="<%=request.getAttribute("sort_order")%>">
	</form>
	</form>
	<form id="formChange" method="POST" action="/web/ja/S00008/change">
		<%-- ここにフォームデータのhiddenフィールドを追加 --%>
		<input name="nickname_radio" type="hidden"
			value="<%=request.getAttribute("nickname_radio")%>"> <input
			name="nickname_type_radio" type="hidden"
			value="<%=request.getAttribute("nickname_type_radio")%>"> <input
			name="nickname" type="hidden"
			value="<%=request.getAttribute("nickname")%>"> <input
			name="joined_date_radio" type="hidden"
			value="<%=request.getAttribute("joined_date_radio")%>"> <input
			name="joined_date_from" type="hidden"
			value="<%=request.getAttribute("joined_date_from")%>"> <input
			name="joined_date_to" type="hidden"
			value="<%=request.getAttribute("joined_date_to")%>"> <input
			name="gender_radio" type="hidden"
			value="<%=request.getAttribute("gender_radio")%>"> <input
			name="gender" type="hidden"
			value="<%=request.getAttribute("gender")%>"> <input
			name="birthday_radio" type="hidden"
			value="<%=request.getAttribute("birthday_radio")%>"> <input
			name="birthday_from" type="hidden"
			value="<%=request.getAttribute("birthday_from")%>"> <input
			name="birthday_to" type="hidden"
			value="<%=request.getAttribute("birthday_to")%>"> <input
			name="listener_count_radio" type="hidden"
			value="<%=request.getAttribute("listener_count_radio")%>"> <input
			name="listener_count_from" type="hidden"
			value="<%=request.getAttribute("listener_count_from")%>"> <input
			name="listener_count_to" type="hidden"
			value="<%=request.getAttribute("listener_count_to")%>"> <input
			name="language_type_jp" type="hidden"
			value="<%=request.getAttribute("language_type_jp")%>"> <input
			name="language_type_en" type="hidden"
			value="<%=request.getAttribute("language_type_en")%>"> <input
			name="sort_order" type="hidden"
			value="<%=request.getAttribute("sort_order")%>">
	</form>

	<footer>
		<p>
			Copyright &copy; <a href="https://www.excd.jp/top">EXCEED
				Co.,ltd.</a>
		</p>

		<div id="pagetop" hidden>
			<img src="/web/image/pagetop.png" alt="ページトップ">
		</div>

	</footer>
</body>
</html>
