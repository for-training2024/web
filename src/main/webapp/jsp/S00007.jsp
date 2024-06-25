
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<%
// (1) 「エラー情報(error)」が設定されている場合は、画面に「エラー情報(error)」を表示する。
String errorMessage = (String) request.getAttribute("error");
if (errorMessage == null)
	errorMessage = "";

// (2) 「ニックネーム_エラー状態(nickname_is_error)」= "1"の場合
String nickname_is_error = "";
if ("1".equals(request.getAttribute("nickname_is_error"))) {
	nickname_is_error = ", error";
}

// (3) 以下の項目を元にニックネームの入力状態を再現する。
String nickname_Radio1 = "";
if ("1".equals(request.getAttribute("nickname_radio"))) {
	nickname_Radio1 = "checked=\"checked\"";
}
;
String nickname_Radio2 = "";
if ("2".equals(request.getAttribute("nickname_radio"))) {
	nickname_Radio2 = "checked=\"checked\"";
}
String nickname_type_Radio1 = "";
if ("1".equals(request.getAttribute("nickname_type_radio"))) {
	nickname_type_Radio1 = "checked=\"checked\"";
}
String nickname_type_Radio2 = "";
if ("2".equals(request.getAttribute("nickname_type_radio"))) {
	nickname_type_Radio2 = "checked=\"checked\"";
}
String nickname = (String) request.getAttribute("nickname");
if (nickname == null)
	nickname = "";

// (4) 「登録日_エラー状態(joined_date_is_error)」= "1"の場合、divタグのクラス属性に errorを加える。
String joined_date_is_error = "";
if ("1".equals(request.getAttribute("joined_date_is_error"))) {
	joined_date_is_error = ", error";
}

// (5) 以下の項目を元に登録日の入力状態を再現する。
String joined_date_Radio1 = "";
if ("1".equals(request.getAttribute("joined_date_radio"))) {
	joined_date_Radio1 = "checked=\"checked\"";
}
String joined_date_Radio2 = "";
if ("2".equals(request.getAttribute("joined_date_radio"))) {
	joined_date_Radio2 = "checked=\"checked\"";
}
String joined_date_from = (String) request.getAttribute("joined_date_from");
String joined_date_to = (String) request.getAttribute("joined_date_to");

// (6) 「性別_エラー状態(gender_is_error)」= "1"の場合、divタグのクラス属性に errorを加える。
String gender_is_error = "";
if ("1".equals(request.getAttribute("gender_is_error"))) {
	gender_is_error = ", error";
}

// (7) 以下の項目を元に性別の入力状態を再現する。
String gender_Radio1 = "";
if ("1".equals(request.getAttribute("gender_radio"))) {
	gender_Radio1 = "checked=\"checked\"";
}
String gender_Radio2 = "";
if ("2".equals(request.getAttribute("gender_radio"))) {
	gender_Radio2 = "checked=\"checked\"";
}
String gender = (String) request.getAttribute("gender");
if (gender == null)
	gender = "男";

// (8) 「誕生日_エラー状態(birthday_is_error)」= "1"の場合、divタグのクラス属性に errorを加える。
String birthday_is_error = "";
if ("1".equals(request.getAttribute("birthday_is_error"))) {
	birthday_is_error = ", error";
}

// (9) 以下の項目を元に再生回数の入力状態を再現する。
String birthday_Radio1 = "";
if ("1".equals(request.getAttribute("birthday_radio"))) {
	birthday_Radio1 = "checked=\"checked\"";
}
String birthday_Radio2 = "";
if ("2".equals(request.getAttribute("birthday_radio"))) {
	birthday_Radio2 = "checked=\"checked\"";
}
String birthday_from = (String) request.getAttribute("birthday_from");
String birthday_to = (String) request.getAttribute("birthday_to");

// (10) 「リスナー数_エラー状態(listener_is_error)」= "1"の場合、divタグのクラス属性に errorを加える。
String listener_is_error = "";
if ("1".equals(request.getAttribute("listener_count_is_error"))) {
	listener_is_error = ", error";
}

// (11) 以下の項目を元にリスナー数の入力状態を再現する。
String listener_count_Radio1 = "";
if ("1".equals(request.getAttribute("listener_count_radio"))) {
	listener_count_Radio1 = "checked=\"checked\"";
}
String listener_count_Radio2 = "";
if ("2".equals(request.getAttribute("listener_count_radio"))) {
	listener_count_Radio2 = "checked=\"checked\"";
}
String listener_count_from = (String) request.getAttribute("listener_count_from");
if(listener_count_from == null)
	listener_count_from = "";
String listener_count_to = (String) request.getAttribute("listener_count_to");
if(listener_count_to == null)
	listener_count_to ="";

// (12) 「言語_エラー状態(language_is_error)」= "1"の場合、divタグのクラス属性に errorを加える。
String language_is_error = "";
if ("1".equals(request.getAttribute("language_is_error"))) {
	language_is_error = ", error";
}

// (13) 以下の項目を元に言語の入力状態を再現する。
String language_type_jp = "";
if ("001".equals(request.getAttribute("language_type_jp"))) {
	language_type_jp = "checked=\"checked\"";
}
String language_type_en = "";
if ("002".equals(request.getAttribute("language_type_en"))) {
	language_type_en = "checked=\"checked\"";
}

// (14) 以下の項目を元に並び順の入力状態を再現する。
String sort_order = (String) request.getAttribute("sort_order");
if (sort_order == null)
	sort_order = "01";
%>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="keywords"
	content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
<meta name="description"
	content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
<title>作曲家検索</title>
<link rel="stylesheet" href="/web/CSS/main.css">
<link rel="stylesheet" href="/web/CSS/S00007.css">
<link rel="stylesheet" href="/web/CSS/S5678.css">
<script src="/web/js/jquery-3.3.0.min.js"></script>
<script src="/web/js/S00002.js"></script>
<script src="/web/js/S00007.js"></script>
</head>


<body>
	<!-- メニューのキャンセルレイヤの起点 -->
	<div id="layer_marker"></div>

	<div class="wrapper">

		<!-- タイトルバー -->
		<div class="title_bar">
			<p class="page_title">作曲家検索</p>

			<a href="#" id="menu_open"> <img alt="メニュー"
				src="/web/image/menu.png" class="menu-icon">
			</a>
		</div>

		<!-- メニューの起点 -->
		<div id="menu_marker"></div>

		<!-- エラーメッセージ -->
		<%
		if ("".equals(errorMessage) == false) {
		%>
		<div class="error_message">
			<img alt="エラーマーク" src="/web/image/error_mark.png">
			<p><%=errorMessage%></p>
		</div>
		<%
		}
		%>

		<form name="main" action="/web/ja/S00007/search" method="post">

			<!-- ニックネーム -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label" rowspan=2 <%=nickname_is_error%>>ニックネーム</td>
						<td class="value" <%=nickname_is_error%>>
							<table class="radio_base">
								<tr>
									<td><label> <input type="radio"
											name="nickname_radio" id="id_name1" value="1"
											class="onOffRadio" <%=nickname_Radio1%>><span
											class="radio_label">指定</span>
									</label></td>
									<td><label> <input type="radio"
											name="nickname_radio" id="id_name2" value="2"
											checked="checked" class="onOffRadio" <%=nickname_Radio2%>><span
											class="radio_label">指定なし</span>
									</label></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="value" <%=nickname_is_error%>>
							<table class="text_base">
								<tr>
									<td><label> <input type="radio"
											name="nickname_type_radio" id="id_name3" value="1"
											class="onOffRadio" <%=nickname_type_Radio1%>><span
											class="radio_label">あいまい</span>
									</label></td>
									<td><label> <input type="radio"
											name="nickname_type_radio" id="id_name4" value="2"
											class="onOffRadio" <%=nickname_type_Radio2%>><span
											class="radio_label">完全一致</span>
									</label></td>
								</tr>
								<tr>
									<td colspan=2><input type="text" name="nickname"
										class="nickname_text" maxlength="255" value="<%=nickname%>"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<br>

			<!-- 登録日 -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label" rowspan=2 <%=joined_date_is_error%>>登録日</td>
						<td class="value" <%=joined_date_is_error%>>
							<table class="radio_base">
								<tr>
									<td><label> <input type="radio"
											name="joined_date_radio" value="1" class="onOffRadio"
											<%=joined_date_Radio1%>><span class="radio_label">指定</span>
									</label></td>
									<td><label> <input type="radio"
											name="joined_date_radio" value="2" checked="checked"
											class="onOffRadio" <%=joined_date_Radio2%>><span
											class="radio_label">指定なし</span>
									</label></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="value" <%=joined_date_is_error%>>
							<table class="date_base">
								<tr>
									<td><input type="date" name="joined_date_from"
										value="<%=joined_date_from%>"></td>
								</tr>
								<tr>
									<td>～</td>
								</tr>
								<tr>
									<td><input type="date" name="joined_date_to"
										value="<%=joined_date_to%>"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<br>

			<!-- 性別 -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label" rowspan=2 <%=gender_is_error%>>性別</td>
						<td class="value" <%=gender_is_error%>>
							<table class="radio_base">
								<tr>
									<td><label> <input type="radio"
											name="gender_radio" value="1" class="onOffRadio"
											<%=gender_Radio1%>><span class="radio_label">指定</span>
									</label></td>
									<td><label> <input type="radio"
											name="gender_radio" value="2" class="onOffRadio"
											checked="checked" <%=gender_Radio2%>><span
											class="radio_label">指定なし</span>
									</label></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="value" <%=gender_is_error%>><select name="gender">
								<option value="1" <%=gender%>>男
								<option value="2" <%=gender%>>女
						</select></td>
					</tr>
				</table>
			</div>
			<br>

			<!-- 誕生日 -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label" rowspan="2" <%=birthday_is_error %>>誕生日</td>
						<td class="value"<%=birthday_is_error %>>
							<table class="radio_base">
								<tr>
									<td><label> <input type="radio"
											name="birthday_radio" value="1" class="onOffRadio"
											<%=birthday_Radio1%>><span class="radio_label">指定</span>
									</label></td>
									<td><label> <input type="radio"
											name="birthday_radio" value="2" checked="checked"
											class="onOffRadio" <%=birthday_Radio2%>><span
											class="radio_label">指定なし</span>
									</label></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="value" <%=birthday_is_error %>>
							<table class="date_base">
								<tr>
									<td><input type="date" name="birthday_from"
										value="<%=birthday_from%>"></td>
								</tr>
								<tr>
									<td>～</td>
								</tr>
								<tr>
									<td><input type="date" name="birthday_to"
										value="<%=birthday_to%>"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<br>

			<!-- リスナー数 -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label" rowspan="2" <%=listener_is_error%>>リスナー数</td>
						<td class="value"<%=listener_is_error %>>
							<table class="radio_base">
								<tr>
									<td><label> <input type="radio"
											name="listener_count_radio" value="1" class="onOffRadio"
											<%=listener_count_Radio1%>><span class="radio_label">指定</span>
									</label></td>
									<td><label> <input type="radio"
											name="listener_count_radio" value="2" class="onOffRadio"
											<%=listener_count_Radio2%> checked="checked"><span
											class="radio_label">指定なし</span>
									</label></td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td class="value" <%=listener_is_error%>>
							<table class="text_base">
								<tr>
									<td><input type="text" name="listener_count_from"
										maxlength="8" class="listner_count_text"
										value="<%=listener_count_from%>"></td>
								</tr>
								<tr>
									<td>～</td>
								</tr>
								<tr>
									<td><input type="text" name="listener_count_to"
										maxlength="8" class="listner_count_text"
										value="<%=listener_count_to%>"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<br>

			<!-- 言語 -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label"<%=language_is_error%>>言語</td>
						<td class="value"<%=language_is_error%>>
							<table class="check_base">
								<tr>
									<td><label> <input type="checkbox"
											name="language_type_jp" value="001"><span
											class="check_label"<%=language_type_jp %>>日本語</span>
									</label></td>
								</tr>
								<tr>
									<td><label> <input type="checkbox"
											name="language_type_en" value="002"><span
											class="check_label"<%=language_type_en %>>英語</span>
									</label></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<br>

			<!-- 並び順 -->
			<div class="input_table">
				<table>
					<tr>
						<td class="label">並び順</td>
						<td class="value"><select name="sort_order">
								<option value="01">新しい順</option>
								<option value="02">古い順</option>
								<option value="03">リスナー数が多い順</option>
								<option value="04">リスナー数が少ない順</option>
						</select></td>
					</tr>
				</table>
			</div>

			<!-- メインボタン -->
			<div class="main_button">
				<button type="submit" value="送信">送信
			</div>
		</form>
	</div>
	<!-- ページトップへjavaScript -->
	<div id="pagetop" hidden>
		<img alt="ページトップ" src="/web/image/pagetop.png">
	</div>

	<!-- フッター -->
	<footer>
		Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All
		Rights Reserved.
	</footer>

</body>
</html>

