<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	// (1) 「エラー情報(error)」が設定されている場合は、画面に「エラー情報(error)」を表示する。
	String errorMessage = (String)request.getAttribute("error");
    if (errorMessage == null){ errorMessage = ""; }

	// (2) 「公開日_エラー状態(release_date_is_error)」= "1"の場合
	String release_date_is_error = "";
	if ("1".equals(request.getAttribute("release_date_is_error"))) {
		release_date_is_error = " error";
	}
	// (3) 以下の項目を元に公開日時の入力状態を再現する。
	String release_date_radio1 = "";
	String release_date_radio2 = "checked=\"checked\"";
    if ("1".equals(request.getAttribute("release_date_radio"))) {
    	release_date_radio1 = "checked=\"checked\"";
		release_date_radio2 = "";
    }
	String release_date_from = (String)request.getAttribute("release_date_from");
	String release_date_to = (String)request.getAttribute("release_date_to");

	// (4) 「感動指数_エラー状態(rating_is_error)」= "1"の場合、tdタグに errorを加える。
	String rating_is_error = "";
	if ("1".equals(request.getAttribute("rating_is_error"))) {
		rating_is_error = " error";
	}

	// (5) 以下の項目を元に感動指数の入力状態を再現する。
	String rating_radio1 = "";
	String rating_radio2 = "checked=\"checked\"";
	if ("1".equals(request.getAttribute("rating_radio"))) {
		rating_radio1 = "checked=\"checked\"";
		rating_radio2 = "";
	}
	String rating_from = (String)request.getAttribute("rating_from");
	if (rating_from == null){ rating_from = "";}
	String rating_to = (String)request.getAttribute("rating_to");
	if (rating_to == null) {rating_to = "";}

	// (6) 「平均感動指数_エラー状態(rating_average_is_error)」= "1"の場合、tdタグに errorを加える。
	String rating_average_is_error = "";
	if ("1".equals(request.getAttribute("rating_average_is_error"))) {
		rating_average_is_error = " error";
	}
	
	// (7) 以下の項目を元に平均感動指数の入力状態を再現する。
	String rating_average_radio1 = "";
	String rating_average_radio2 = "checked=\"checked\"";
	if ("1".equals(request.getAttribute("rating_average_radio"))) {
		rating_average_radio1 = "checked=\"checked\"";
		rating_average_radio2 = "";
	}
	String rating_average_from = (String)request.getAttribute("rating_average_from");
	if (rating_average_from == null) { 
		rating_average_from="4.0";
	}
	String rating_average_to = (String)request.getAttribute("rating_average_to");
	if (rating_average_to == null) {
		rating_average_to ="5.0";
	}

	// (8) 「再生回数_エラー状態(views_is_error)」= "1"の場合、tdタグにerrorを加える。
	String views_is_error = "";
	if ("1".equals(request.getAttribute("views_is_error"))) {
		views_is_error = " error";
	}
	
	// (9) 以下の項目を元に再生回数の入力状態を再現する。
	String views_radio1 = "";
	String views_radio2 = "checked=\"checked\"";
	if ("1".equals(request.getAttribute("views_radio"))) {
		views_radio1 = "checked=\"checked\"";
		views_radio2 = "";
	}
	String views_from = (String)request.getAttribute("views_from");
	if (views_from == null){ views_from = "";}
	String views_to = (String)request.getAttribute("views_to");
	if (views_to == null){ views_to = "";}

	// (10) 「曲名_エラー状態(title_is_error)」= "1"の場合、divタグのクラス属性に errorを加える。
	String title_is_error = "";
	if ("1".equals(request.getAttribute("title_is_error"))) {
		title_is_error = " error";
	}

	// (11) 以下の項目を元に曲名の入力状態を再現する。
	String title_radio1 = "";
	String title_radio2 ="checked=\"checked\"";

	if ("1".equals(request.getAttribute("title_radio"))) {
		title_radio1 = "checked=\"checked\"";
		title_radio2 = "";
	}
	
	String title_type_radio1 = "";
	String title_type_radio2 = "checked=\"checked\"";

	if ("3".equals(request.getAttribute("title_type_radio"))) {
		title_type_radio1 = "checked=\"checked\"";
		title_type_radio2 = "";
	}
	String title = (String)request.getAttribute("title");
	if (title == null){ title = "";}
	
	// (12) 「キー_エラー状態(key_is_error)」= "1"の場合、tdタグに errorを加える。
	String key_is_error = "";
	if ("1".equals(request.getAttribute("key_is_error"))) {
		key_is_error = " error";
	}
	
	// (13) 以下の項目を元にキーの入力状態を再現する。
	String key_radio1 = "";
	String key_radio2 = "checked=\"checked\"";
	if ("1".equals(request.getAttribute("key_radio"))) {
		key_radio1 = "checked=\"checked\"";
		key_radio2 = "";
	}
	String key = (String)request.getAttribute("key");
	if (key == null) { 
		key="01";
	}

	// (14) 「BPM_エラー状態(views_is_error)」= "1"の場合、tdタグにerrorを加える。
	String bpm_is_error = "";
	if ("1".equals(request.getAttribute("bpm_is_error"))) {
		bpm_is_error = " error";
	}
	
	// (15) 以下の項目を元にBPMの入力状態を再現する。
	String bpm_radio1 = "";
	String bpm_radio2 = "checked=\"checked\"";
	if ("1".equals(request.getAttribute("bpm_radio"))) {
		bpm_radio1 = "checked=\"checked\"";
		bpm_radio2 = "";
	}
	String bpm_from = (String)request.getAttribute("bpm_from");
	if (bpm_from == null){ bpm_from = "";}
	String bpm_to = (String)request.getAttribute("bpm_to");
	if (bpm_to == null){ bpm_to = "";}
	
	// (16) 以下の項目を元に並び順の入力状態を再現する。
	String sort_order = (String)request.getAttribute("sort_order");
	if (sort_order == null){ sort_order="1";}
%>


<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
  <title>作品検索</title>
  <link rel="stylesheet" href="/web/CSS/main.css">
  <link rel="stylesheet" href="/web/CSS/S5678.css" />
  <script src="/web/js/jquery-3.3.0.min.js"></script>
    <script src="/web/js/input.js"></script>
  <script src="/web/js/S00002.js"></script>
  
</head>

<body>
  <!-- メニューのキャンセルレイヤの起点 -->
  <div id="layer_marker">
  </div>

  <div class="wrapper">
	
	<!-- タイトルバー -->
	<div class="title_bar">
      <p class="page_title">作品検索</p>
      <a href="#" id="menu_open">
        <img alt="メニュー" src="/web/image/menu.png" class="menu-icon">
      </a>
    </div>

    <!-- メニューの起点 -->
    <div id="menu_marker">
    </div>

    <!-- エラーメッセージ -->
	<% if ("".equals(errorMessage) == false) { %>
	  <div class="error_message">
 		<img alt="エラーマーク" src="/web/image/error_mark.png">
		  <p><%= errorMessage %></p>
    </div>
    <% } %>

    <!-- フォーム -->
    <form name="main" action="/web/ja/S00005/search" method="post">

      <!-- 公開日 -->
      <div class="input_table" >
        <table>
          <tr>
            <td class="label" rowspan=2  <%= release_date_is_error %>>公開日</td>
            <td class="value" <%= release_date_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" name="release_date_radio" value="1" class="onOffRadio" <%= release_date_radio1 %>><span class="radio_label">指定</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" name="release_date_radio" value="2" class="onOffRadio" <%= release_date_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= release_date_is_error %>>
              <input type="date" name="release_date_from" value="<%= release_date_from %>">
              <br>
              ～
              <br>
              <input type="date" name="release_date_to" value="<%= release_date_to %>">
            </td>
          </tr>
        </table>
      </div>
    

      <!-- 感動指数 -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label" rowspan=2 <%= rating_is_error %>>感動指数</td>
            <td class="value" <%= rating_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" name="rating_radio" value="1" class="onOffRadio" <%= rating_radio1 %>><span class="radio_label">指定</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" name="rating_radio" value="2" class="onOffRadio" <%= rating_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= rating_is_error %>>
              <input type="text" name="rating_from" maxlength=8 value="<%= rating_from %>">
              <br>
              ～
              <br>
              <input type="text" name="rating_to" maxlength=8 value="<%= rating_to %>">
            </td>
          </tr>
        </table>
      </div>

      <!-- 平均感動指数 -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label" rowspan=2 <%= rating_average_is_error %>>平均感動指数</td>
            <td class="value" <%= rating_average_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" name="rating_average_radio" value="1" class="onOffRadio" <%= rating_average_radio1 %>><span class="radio_label">指定</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" name="rating_average_radio" value="2" class="onOffRadio" <%= rating_average_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= rating_average_is_error %>>
              <select name="rating_average_from" tabindex="1" value="<%= rating_average_from %>">
				<option value="1.0" <% if ("1.0".equals(rating_average_from)) { %>selected<% } %>>1.0</option>
				<option value="1.1" <% if ("1.1".equals(rating_average_from)) { %>selected<% } %>>1.1</option>
				<option value="1.2" <% if ("1.2".equals(rating_average_from)) { %>selected<% } %>>1.2</option>
				<option value="1.3" <% if ("1.3".equals(rating_average_from)) { %>selected<% } %>>1.3</option>
				<option value="1.4" <% if ("1.4".equals(rating_average_from)) { %>selected<% } %>>1.4</option>
				<option value="1.5" <% if ("1.5".equals(rating_average_from)) { %>selected<% } %>>1.5</option>
				<option value="1.6" <% if ("1.6".equals(rating_average_from)) { %>selected<% } %>>1.6</option>
				<option value="1.7" <% if ("1.7".equals(rating_average_from)) { %>selected<% } %>>1.7</option>
				<option value="1.8" <% if ("1.8".equals(rating_average_from)) { %>selected<% } %>>1.8</option>
				<option value="1.9" <% if ("1.9".equals(rating_average_from)) { %>selected<% } %>>1.9</option>
				<option value="2.0" <% if ("2.0".equals(rating_average_from)) { %>selected<% } %>>2.0</option>
				<option value="2.1" <% if ("2.1".equals(rating_average_from)) { %>selected<% } %>>2.1</option>
				<option value="2.2" <% if ("2.2".equals(rating_average_from)) { %>selected<% } %>>2.2</option>
				<option value="2.3" <% if ("2.3".equals(rating_average_from)) { %>selected<% } %>>2.3</option>
				<option value="2.4" <% if ("2.4".equals(rating_average_from)) { %>selected<% } %>>2.4</option>
				<option value="2.5" <% if ("2.5".equals(rating_average_from)) { %>selected<% } %>>2.5</option>
				<option value="2.6" <% if ("2.6".equals(rating_average_from)) { %>selected<% } %>>2.6</option>
				<option value="2.7" <% if ("2.7".equals(rating_average_from)) { %>selected<% } %>>2.7</option>
				<option value="2.8" <% if ("2.8".equals(rating_average_from)) { %>selected<% } %>>2.8</option>
				<option value="2.9" <% if ("2.9".equals(rating_average_from)) { %>selected<% } %>>2.9</option>
				<option value="3.0" <% if ("3.0".equals(rating_average_from)) { %>selected<% } %>>3.0</option>
				<option value="3.1" <% if ("3.1".equals(rating_average_from)) { %>selected<% } %>>3.1</option>
				<option value="3.2" <% if ("3.2".equals(rating_average_from)) { %>selected<% } %>>3.2</option>
				<option value="3.3" <% if ("3.3".equals(rating_average_from)) { %>selected<% } %>>3.3</option>
				<option value="3.4" <% if ("3.4".equals(rating_average_from)) { %>selected<% } %>>3.4</option>
				<option value="3.5" <% if ("3.5".equals(rating_average_from)) { %>selected<% } %>>3.5</option>
				<option value="3.6" <% if ("3.6".equals(rating_average_from)) { %>selected<% } %>>3.6</option>
				<option value="3.7" <% if ("3.7".equals(rating_average_from)) { %>selected<% } %>>3.7</option>
				<option value="3.8" <% if ("3.8".equals(rating_average_from)) { %>selected<% } %>>3.8</option>
				<option value="3.9" <% if ("3.9".equals(rating_average_from)) { %>selected<% } %>>3.9</option>
				<option value="4.0" <% if ("4.0".equals(rating_average_from)) { %>selected<% } %>>4.0</option>
				<option value="4.1" <% if ("4.1".equals(rating_average_from)) { %>selected<% } %>>4.1</option>
				<option value="4.2" <% if ("4.2".equals(rating_average_from)) { %>selected<% } %>>4.2</option>
				<option value="4.3" <% if ("4.3".equals(rating_average_from)) { %>selected<% } %>>4.3</option>
				<option value="4.4" <% if ("4.4".equals(rating_average_from)) { %>selected<% } %>>4.4</option>
				<option value="4.5" <% if ("4.5".equals(rating_average_from)) { %>selected<% } %>>4.5</option>
				<option value="4.6" <% if ("4.6".equals(rating_average_from)) { %>selected<% } %>>4.6</option>
				<option value="4.7" <% if ("4.7".equals(rating_average_from)) { %>selected<% } %>>4.7</option>
				<option value="4.8" <% if ("4.8".equals(rating_average_from)) { %>selected<% } %>>4.8</option>
				<option value="4.9" <% if ("4.9".equals(rating_average_from)) { %>selected<% } %>>4.9</option>
				<option value="5.0" <% if ("5.0".equals(rating_average_from)) { %>selected<% } %>>5.0</option>
              </select>
              <br>
              ～
              <br>
              <select name="rating_average_to" tabindex="2" value="<%= rating_average_to %>">
				<option value="1.0" <% if ("1.0".equals(rating_average_to)) { %>selected<% } %>>1.0</option>
				<option value="1.1" <% if ("1.1".equals(rating_average_to)) { %>selected<% } %>>1.1</option>
				<option value="1.2" <% if ("1.2".equals(rating_average_to)) { %>selected<% } %>>1.2</option>
				<option value="1.3" <% if ("1.3".equals(rating_average_to)) { %>selected<% } %>>1.3</option>
				<option value="1.4" <% if ("1.4".equals(rating_average_to)) { %>selected<% } %>>1.4</option>
				<option value="1.5" <% if ("1.5".equals(rating_average_to)) { %>selected<% } %>>1.5</option>
				<option value="1.6" <% if ("1.6".equals(rating_average_to)) { %>selected<% } %>>1.6</option>
				<option value="1.7" <% if ("1.7".equals(rating_average_to)) { %>selected<% } %>>1.7</option>
				<option value="1.8" <% if ("1.8".equals(rating_average_to)) { %>selected<% } %>>1.8</option>
				<option value="1.9" <% if ("1.9".equals(rating_average_to)) { %>selected<% } %>>1.9</option>
				<option value="2.0" <% if ("2.0".equals(rating_average_to)) { %>selected<% } %>>2.0</option>
				<option value="2.1" <% if ("2.1".equals(rating_average_to)) { %>selected<% } %>>2.1</option>
				<option value="2.2" <% if ("2.2".equals(rating_average_to)) { %>selected<% } %>>2.2</option>
				<option value="2.3" <% if ("2.3".equals(rating_average_to)) { %>selected<% } %>>2.3</option>
				<option value="2.4" <% if ("2.4".equals(rating_average_to)) { %>selected<% } %>>2.4</option>
				<option value="2.5" <% if ("2.5".equals(rating_average_to)) { %>selected<% } %>>2.5</option>
				<option value="2.6" <% if ("2.6".equals(rating_average_to)) { %>selected<% } %>>2.6</option>
				<option value="2.7" <% if ("2.7".equals(rating_average_to)) { %>selected<% } %>>2.7</option>
				<option value="2.8" <% if ("2.8".equals(rating_average_to)) { %>selected<% } %>>2.8</option>
				<option value="2.9" <% if ("2.9".equals(rating_average_to)) { %>selected<% } %>>2.9</option>
				<option value="3.0" <% if ("3.0".equals(rating_average_to)) { %>selected<% } %>>3.0</option>
				<option value="3.1" <% if ("3.1".equals(rating_average_to)) { %>selected<% } %>>3.1</option>
				<option value="3.2" <% if ("3.2".equals(rating_average_to)) { %>selected<% } %>>3.2</option>
				<option value="3.3" <% if ("3.3".equals(rating_average_to)) { %>selected<% } %>>3.3</option>
				<option value="3.4" <% if ("3.4".equals(rating_average_to)) { %>selected<% } %>>3.4</option>
				<option value="3.5" <% if ("3.5".equals(rating_average_to)) { %>selected<% } %>>3.5</option>
				<option value="3.6" <% if ("3.6".equals(rating_average_to)) { %>selected<% } %>>3.6</option>
				<option value="3.7" <% if ("3.7".equals(rating_average_to)) { %>selected<% } %>>3.7</option>
				<option value="3.8" <% if ("3.8".equals(rating_average_to)) { %>selected<% } %>>3.8</option>
				<option value="3.9" <% if ("3.9".equals(rating_average_to)) { %>selected<% } %>>3.9</option>
				<option value="4.0" <% if ("4.0".equals(rating_average_to)) { %>selected<% } %>>4.0</option>
				<option value="4.1" <% if ("4.1".equals(rating_average_to)) { %>selected<% } %>>4.1</option>
				<option value="4.2" <% if ("4.2".equals(rating_average_to)) { %>selected<% } %>>4.2</option>
				<option value="4.3" <% if ("4.3".equals(rating_average_to)) { %>selected<% } %>>4.3</option>
				<option value="4.4" <% if ("4.4".equals(rating_average_to)) { %>selected<% } %>>4.4</option>
				<option value="4.5" <% if ("4.5".equals(rating_average_to)) { %>selected<% } %>>4.5</option>
				<option value="4.6" <% if ("4.6".equals(rating_average_to)) { %>selected<% } %>>4.6</option>
				<option value="4.7" <% if ("4.7".equals(rating_average_to)) { %>selected<% } %>>4.7</option>
				<option value="4.8" <% if ("4.8".equals(rating_average_to)) { %>selected<% } %>>4.8</option>
				<option value="4.9" <% if ("4.9".equals(rating_average_to)) { %>selected<% } %>>4.9</option>
				<option value="5.0" <% if ("5.0".equals(rating_average_to)) { %>selected<% } %>>5.0</option>
              </select>
            </td>
          </tr>
        </table>
      </div>

      <!-- 再生回数 -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label" rowspan=2 <%= views_is_error %>>再生回数</td>
            <td class="value" <%= views_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" name="views_radio" value="1" class="onOffRadio" <%= views_radio1 %>><span class="radio_label">指定</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" name="views_radio" value="2" class="onOffRadio" <%= views_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= views_is_error %>>
              <input type="text" name="views_from" maxlength='8' value="<%= views_from %>">
              <br>
              ～
              <br>
              <input type="text" name="views_to" maxlength='8' value="<%= views_to %>">
            </td>
          </tr>
        </table>
      </div>

      <!-- 曲名 -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label" rowspan=2 <%= title_is_error %>>曲名</td>
            <td class="value" <%= title_is_error %>>
              <table class="radio_base">
                <tr>
				  <td>
					<label>
                      <input type="radio" id="id_title1" name="title_radio" value="1" class="onOffRadio" <%=title_radio1 %>><span class="radio_label">指定</span>
 					</label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" id="id_title2" name="title_radio" value="2" class="onOffRadio" <%=title_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= title_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" id="id_title3" name="title_type_radio" value="3" <%=title_type_radio1 %>><span class="radio_label">あいまい</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" id="id_title4" name="title_type_radio" value="4"  <%=title_type_radio2 %>><span class="radio_label" >完全一致</span>
                    </label>
                  </td>
                </tr>
              </table>
              <input type="text" name="title" maxlength=255 value="<%=title%>">
            </td>
          </tr>
        </table>
      </div>

      <!-- キー -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label" rowspan=2 <%= key_is_error %>>キー</td>
            <td class="value" <%= key_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" name="key_radio" value="1" class="onOffRadio" <%= key_radio1 %>><span class="radio_label">指定</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" name="key_radio" value="2" class="onOffRadio" <%= key_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= key_is_error %>>
              <select name="key" tabindex="1" value="<%= key %>">
				<option value="01" <% if ("01".equals(key)) { %>selected<% } %>>Cメジャー</option>
				<option value="02" <% if ("02".equals(key)) { %>selected<% } %>>Cシャープメジャー</option>
				<option value="03" <% if ("03".equals(key)) { %>selected<% } %>>Dフラットメジャー</option>
				<option value="04" <% if ("04".equals(key)) { %>selected<% } %>>Dメジャー</option>
				<option value="05" <% if ("05".equals(key)) { %>selected<% } %>>Dシャープメジャー</option>
				<option value="06" <% if ("06".equals(key)) { %>selected<% } %>>Eフラットメジャー</option>
				<option value="07" <% if ("07".equals(key)) { %>selected<% } %>>Eメジャー</option>
				<option value="08" <% if ("08".equals(key)) { %>selected<% } %>>Fメジャー</option>
				<option value="09" <% if ("09".equals(key)) { %>selected<% } %>>Fシャープメジャー</option>
				<option value="10" <% if ("10".equals(key)) { %>selected<% } %>>Gフラットメジャー</option>
				<option value="11" <% if ("11".equals(key)) { %>selected<% } %>>Gメジャー</option>
				<option value="12" <% if ("12".equals(key)) { %>selected<% } %>>Gシャープメジャー</option>
				<option value="13" <% if ("13".equals(key)) { %>selected<% } %>>Aフラットメジャー</option>
				<option value="14" <% if ("14".equals(key)) { %>selected<% } %>>Aメジャー</option>
				<option value="15" <% if ("15".equals(key)) { %>selected<% } %>>Aシャープメジャー</option>
				<option value="16" <% if ("16".equals(key)) { %>selected<% } %>>Bフラットメジャー</option>
				<option value="17" <% if ("17".equals(key)) { %>selected<% } %>>Bメジャー</option>
				<option value="18" <% if ("18".equals(key)) { %>selected<% } %>>Cマイナー</option>
				<option value="19" <% if ("19".equals(key)) { %>selected<% } %>>Cシャープマイナー</option>
				<option value="20" <% if ("20".equals(key)) { %>selected<% } %>>Dフラットマイナー</option>
				<option value="21" <% if ("21".equals(key)) { %>selected<% } %>>Dマイナー</option>
				<option value="22" <% if ("22".equals(key)) { %>selected<% } %>>Dシャープマイナー</option>
				<option value="23" <% if ("23".equals(key)) { %>selected<% } %>>Eフラットマイナー</option>
				<option value="24" <% if ("24".equals(key)) { %>selected<% } %>>Eマイナー</option>
				<option value="25" <% if ("25".equals(key)) { %>selected<% } %>>Fマイナー</option>
				<option value="26" <% if ("26".equals(key)) { %>selected<% } %>>Fシャープマイナー</option>
				<option value="27" <% if ("27".equals(key)) { %>selected<% } %>>Gフラットマイナー</option>
				<option value="28" <% if ("28".equals(key)) { %>selected<% } %>>Gマイナー</option>
				<option value="29" <% if ("29".equals(key)) { %>selected<% } %>>Gシャープマイナー</option>
				<option value="30" <% if ("30".equals(key)) { %>selected<% } %>>Aフラットマイナー</option>
				<option value="31" <% if ("31".equals(key)) { %>selected<% } %>>Aマイナー</option>
				<option value="32" <% if ("32".equals(key)) { %>selected<% } %>>Aシャープマイナー</option>
				<option value="33" <% if ("33".equals(key)) { %>selected<% } %>>Bフラットマイナー</option>
				<option value="34" <% if ("34".equals(key)) { %>selected<% } %>>Bマイナー</option>
              </select>
            </td>
          </tr>
        </table>
      </div>

      <!-- bpm -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label" rowspan=2 <%= bpm_is_error %>>BPM</td>
            <td class="value" <%= bpm_is_error %>>
              <table class="radio_base">
                <tr>
                  <td>
                    <label>
                      <input type="radio" name="bpm_radio" value="1" class="onOffRadio" <%= bpm_radio1 %>><span class="radio_label">指定</span>
                    </label>
                  </td>
                  <td>
                    <label>
                      <input type="radio" name="bpm_radio" value="2" class="onOffRadio" <%= bpm_radio2 %>><span class="radio_label">指定なし</span>
                    </label>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr>
            <td class="value" <%= bpm_is_error %>>
              <input type="text" name="bpm_from" maxlength='4' value="<%= bpm_from %>">
              <br>
              ～
              <br>
              <input type="text" name="bpm_to" maxlength='4' value="<%= bpm_to %>">
            </td>
          </tr>
        </table>
      </div>


      <!-- 並び順 -->
      <div class="input_table">
        <table>
          <tr>
            <td class="label">並び順</td>
            <td class="value">
              <select name="sort_order" tabindex="10">
                <option value="1" <% if ("1".equals(sort_order)) { %>selected<% } %>>新しい順</option>
                <option value="2" <% if ("2".equals(sort_order)) { %>selected<% } %>>古い順</option>
                <option value="3" <% if ("3".equals(sort_order)) { %>selected<% } %>>感動指数が多い順</option>
                <option value="4" <% if ("4".equals(sort_order)) { %>selected<% } %>>感動指数が少ない順</option>
                <option value="5" <% if ("5".equals(sort_order)) { %>selected<% } %>>平均感動指数が高い順</option>
                <option value="6" <% if ("6".equals(sort_order)) { %>selected<% } %>>平均感動指数が低い順</option>
                <option value="7" <% if ("7".equals(sort_order)) { %>selected<% } %>>再生回数が多い順</option>
                <option value="8" <% if ("8".equals(sort_order)) { %>selected<% } %>>再生回数が少ない順</option>
              </select>
            </td>
          </tr>
        </table>
      </div>

    <!-- メインボタン -->
    <div class="main_button">
      <button type="submit" value="検索">検索
    </div>

    </form>

    <!-- ページトップへjavaScript -->
    <div id="pagetop" hidden>
      <img alt="ページトップ" src="/web/image/pagetop.png">
    </div>

    <!-- フッター -->
    <footer>
      Copyright <a href="https://www.excd.jp/">© EXCEED Co., Ltd.</a> All Rights Reserved.
    </footer>

  </div>
    <script src="/web/js/S00005.js"></script>
  
</body>
</html>