<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
  <meta name="keywords" content="作曲アプリ,Meloko,楽譜,iPhone,iPad,iOS,MIDI,メロコ,作詞,作曲,コミュニティー,スマホ">
  <meta name="description" content="「メロコ」はiPhone,iPadで動作する作曲アプリです。思いついたメロディーをどんどん曲として保存していきましょう。">
  <title>作曲家紹介</title>
  <link rel="stylesheet" href="../../css/main.css">
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
          <td class="value">SpoonDragon</td>
        </tr>
        <tr>
          <td class="label">ニックネーム</td>
          <td class="value">スプーンドラゴン</td>
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
          <td class="value">作曲の面白さを誰かと語り合いたいです。</td>
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
            <span class="value">男</span>
            <span class="label">誕生日：</span>
            <span class="value">1976/04/08</span>
            <br>
            <span class="label_top">FB：</span>
            <span class="value"><a href="https://google.co.jp">https://xxx.xx.xxxxx/xxxx</a></span>
            <br>
            <span class="label_top">Twitter：</span>
            <span class="value"><a href="https://google.co.jp">https://xxx.xx.xxxx/xxxxx</a></span>
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
            <span class="value">2008年12月</span>
            <br>

            <span class="label_top">作品数：</span>
            <span class="value">25</span>
            <br>

            <span class="label_top">総感動指数：</span>
            <span class="value">531,345</span>
            <br>

            <span class="label_top">平均感動指数：</span>
            <span class="value">4.8</span>
            <br>

            <span class="label_top">総再生回数：</span>
            <span class="value">2,445,931</span>
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
            <a href="https://google.co.jp">BLOG</a>
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

        <li>
          <div class="cell">
            <div class="song_title">希望の扉</div>
            <div class="image_base">
              <a href="S00003.html">
                <div class="image song1">
                  <img alt="希望の扉" src="../../image/tsugumi_01.jpg">
                  <img alt= "play" class="play" src="../../image/play.png">
                </div>
              </a>
            </div>
            <div class="detail">
              <span class="label_top">総感動指数：</span>
              <span class="value">868</span>
              <span class="label">平均感動指数：</span>
              <span class="value">4.3</span>
              <span class="label">再生回数：</span>
              <span class="value">1,253</span>
              <span class="label">公開：</span>
              <span class="value">5分前</span>
            </div>
          </div>
        </li>

        <li>
          <div class="cell">
            <div class="song_title">Melody Loop Of World</div>
            <div class="image_base">
              <a href="S00003.html">
                <div class="image song2">
                  <img alt="Melody Loop Of World" src="../../image/song2.jpg">
                  <img alt="play" class="play" src="../../image/play.png">
                </div>
              </a>
            </div>
            <div class="detail">
              <span class="label_top">総感動指数：</span>
              <span class="value">2,583</span>
              <span class="label">平均感動指数：</span>
              <span class="value">4.3</span>
              <span class="label">再生回数：</span>
              <span class="value">25,136</span>
              <span class="label">公開：</span>
              <span class="value">2週間前</span>
            </div>
          </div>
        </li>

        <li>
          <div class="cell">
            <div class="song_title">朝日の見える丘から</div>
            <div class="image_base">
              <a href="S00003.html">
                <div class="image song3">
                  <img alt="朝日の見える丘から" src="../../image/noimage.png">
                  <img alt="play" class="play" src="../../image/play.png">
                </div>
              </a>
            </div>
            <div class="detail">
              <span class="label_top">総感動指数：</span>
              <span class="value">21,013</span>
              <span class="label">平均感動指数：</span>
              <span class="value">4.3</span>
              <span class="label">再生回数：</span>
              <span class="value">250,511</span>
              <span class="label">公開：</span>
              <span class="value">1ヶ月前</span>
            </div>
          </div>
        </li>

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