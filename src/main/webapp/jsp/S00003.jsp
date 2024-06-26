<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jp.excd.bean.S00003Bean"%>
<%@ page import="jp.excd.bean.CommentRatingBean"%>
<!DOCTYPE html>
<html lang="ja">
<html>
<%
	//S00003Beanの読み込み
	S00003Bean beanS3 = (S00003Bean)request.getAttribute("list1");
	//CommentRatingBeanの読み込み
	List<CommentRatingBean> newCRList = (List<CommentRatingBean>)request.getAttribute("list2");
%>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="keywords"
	content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
<meta name="description"
	content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
<title><%=beanS3.getTitle()%></title>
<link rel="stylesheet" href="../../CSS/main.css">
<script src="../../js/jquery-3.3.0.min.js"></script>
<script src="../../js/S00002.js"></script>

<!-- 画像の圧縮表示設定 -->
<style>
div.song_link div.cell div.song1 img {
	position: relative;
	left: 0px;
	top: -11px;
	width: 275px;
	height: 182px;
}
</style>
</head>
<body>
	<!-- メニューのキャンセルレイヤの起点 -->
	<div id="layer_marker"></div>
	<div class="wrapper">

		<!-- タイトルバー -->
		<div class="title_bar">
			<p class="page_title"><%=beanS3.getTitle()%></p>
			<a href="#" id="menu_open"> <img alt="メニュー"
				src="../../image/menu.png" class="menu-icon">
			</a>
		</div>

		<!-- メニューの起点 -->
		<div id="menu_marker"></div>

		<!-- 曲名 -->
		<div class="double_rows_table">
			<table>
				<tr>
					<td class="label">曲名</td>
					<td class="value"><%=beanS3.getTitle()%></td>
				</tr>
			</table>
		</div>

		<!-- 作者へのリンク -->
		<div class="label_and_link">
			<span class="label">作者：</span><span class="link"><a
				href="../S00004/<%=beanS3.getunique_code()%>"><%=beanS3.getnickname()%></a></span>
		</div>

		<!-- メッセージ -->
		<div class="single_row_table">
			<table>
				<tr>
					<td class="label">メッセージ</td>
				</tr>
				<tr>
					<td class="value"><%=beanS3.getMessage()%></td>
				</tr>
			</table>
		</div>

		<!-- 曲画像リンク -->
		<div class="song_link">
			<div class="cell">
				<div class="image_base">
					<a href="meloko://?song_id=<%=beanS3.getSong_id()%>">
						<div class="image song1">
						<%
						if((beanS3.getImage_file_name()) != null){
						%>
							<img alt="<%=beanS3.getTitle()%>" src="<%=beanS3.getImage_file_name()%>">
						<%
						}else{
						%>
							<img alt="<%=beanS3.getTitle()%>" src="/web/image/noimage.png">						
						<%
						}
						%>	
								<img alt="play" class="play" src="../../image/play.png">
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
					<td class="value"><span class="label_top">総感動指数：</span><span><%=beanS3.getRating_total_formated()%></span>
						<span class="label">平均感動指数：</span><span><%=beanS3.getRating_average_formated()%></span>
						<span class="label">再生回数：</span><span><%=beanS3.getTotal_listen_count_formated()%></span>
						<span class="label">公開：</span><span><%=beanS3.getRelease_datetime_formated()%></span>
						<span class="label">最終更新日：</span><span><%=beanS3.getLast_update_datetime_formated()%></span>
						<span class="label">KEY：</span><span><%=beanS3.getKey_formated()%></span>
						<span class="label">楽譜表記：</span><span><%=beanS3.getScore_type_formated()%></span>
						<span class="label">BPM：</span><span><%=beanS3.getBpm()%>
	          </td>
	        </tr>
			<table>
		</div>
		
		   <!-- 関連リンク -->
   		 <div class="single_row_table">
     		 <table>
				<tr>
					<td class="label">関連リンク</td>
				</tr>
				<tr>
					<td class="value">
						<!-- 関連リンクUrL --> 
						<%
						if((beanS3.getOther_link_description()) != null && (beanS3.getOther_link_url()) != null){
						%>
						<a href="<%=beanS3.getOther_link_url()%>"><%=beanS3.getOther_link_description()%></a>
						<%
						}else{
							%>
							<p>No links</p>
							<%
						}
						%>
											</td>
				</tr>
			</table>
		</div>

		<!-- コメントテーブルのヘッダー -->
		<div class="sub_header">
			<p>この曲についたコメント</p>
		</div>

		<!-- コメントテーブル -->
		<div class="comments">
			<ul>
<%
	//ノーマルコメントの取得
	String root = null;
	if (newCRList != null) {
		for  (CommentRatingBean beanCR : newCRList) {
			if (beanCR.getcomment_type() != 1){
				root = beanCR.getcomment_id();
%>
				<!-- コメント -->
				<li>
					<div class="normal">
						<div class="rating star<%=beanCR.getrating_rating()%>0"></div>
						<div class="composer_link">
							<a
								href="../S00004/<%=beanCR.getcomposer_unique_code()%>"><%=beanCR.getcomposer_nickname()%></a>
						</div>
						<p class="comment"><%=beanCR.getcomment_comment()%></p>
						<p class="time"><%=beanCR.getcomment_write_datetime_fomated()%></p>
					</div>
				</li>
<%
				//ノーマルコメントの返信の取得
					for  (CommentRatingBean beanReply : newCRList) {
						if (root.equals(beanReply.getcomment_to_comment_id())){
							if(!(beanS3.getunique_code()).equals(beanReply.getcomposer_unique_code())){
%>
					<!-- 返信コメント -->
						<li>
						<div class="reply">
							<div class="grater_than">&gt;</div>
							<div class="rating star<%=beanReply.getrating_rating()%>0"></div>
						<div class="composer_link">
								<a
									href="../S00004/<%=beanReply.getcomposer_unique_code()%>"><%=beanReply.getcomposer_nickname()%></a>
							</div>
							<p class="comment"><%=beanReply.getcomment_comment()%></p>
							<p class="time"><%=beanReply.getcomment_write_datetime_fomated()%></p>
						</div>
					</li>
<%
								//返信コメントの返信の取得
									for  (CommentRatingBean beanReply2 : newCRList) {
										if ((beanReply.getcomment_id()).equals(beanReply2.getcomment_to_comment_id())){
											if(!(beanS3.getunique_code()).equals(beanReply2.getcomposer_unique_code())){
%>
					<!-- 返信コメントの返信コメント -->
						<li>
						<div class="reply">
							<div class="grater_than">&gt;</div>
							<div class="rating star<%=beanReply2.getrating_rating()%>0"></div>
						<div class="composer_link">
								<a
									href="../S00004/<%=beanReply2.getcomposer_unique_code()%>"><%=beanReply2.getcomposer_nickname()%></a>
							</div>
							<p class="comment"><%=beanReply2.getcomment_comment()%></p>
							<p class="time"><%=beanReply2.getcomment_write_datetime_fomated()%></p>
						</div>
					</li>
<%
											}else{
%>
					<!-- 返信コメントの作者の返信コメント -->
						<li>
						<div class="reply">
							<div class="grater_than">&gt;</div>
							<div class="rating star<%=beanReply2.getrating_rating()%>0"></div>
						<div class="composer_link">
								<a
									href="../S00004/<%=beanReply2.getcomposer_unique_code()%>"><%=beanReply2.getcomposer_nickname()%></a>
							</div>
							<p class="comment"><%=beanReply2.getcomment_comment()%></p>
							<p class="time"><%=beanReply2.getcomment_write_datetime_fomated()%></p>
						</div>
					</li>
<%
											}
										}
									}
							}else{
%>
					<!-- 作者の返信コメント -->
				<li>
					<div class="reply">
						<div class="grater_than">&gt;</div>
						<div class="composer_link_no_rating">
						<a href="../S00004/<%=beanReply.getcomposer_unique_code()%>"><%=beanReply.getcomposer_nickname()%></a>
						</div>
						<p class="comment"><%=beanReply.getcomment_comment()%></p>
						<p class="time"><%=beanReply.getcomment_write_datetime_fomated()%></p>
					</div>
				</li>	
<%
									for  (CommentRatingBean beanReply2_2 : newCRList) {
										if ((beanReply.getcomment_id()).equals(beanReply2_2.getcomment_to_comment_id())){
											if(!(beanS3.getunique_code()).equals(beanReply2_2.getcomposer_unique_code())){
%>
						<!-- 作者の返信コメントの返信コメント -->
						<li>
						<div class="reply">
							<div class="grater_than">&gt;</div>
							<div class="rating star<%=beanReply2_2.getrating_rating()%>0"></div>
						<div class="composer_link">
								<a
									href="../S00004/<%=beanReply2_2.getcomposer_unique_code()%>"><%=beanReply2_2.getcomposer_nickname()%></a>
							</div>
							<p class="comment"><%=beanReply2_2.getcomment_comment()%></p>
							<p class="time"><%=beanReply2_2.getcomment_write_datetime_fomated()%></p>
						</div>
					</li>				
				
<%
											}
										}
									}
								}
					}
				}
			}
		}
	}
%>


			</ul>
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

	</div>
</body>
</html>
