

$(function() {
	$('#id_name1').change(function() {
	
		if ($(this).is(':checked')) {
		
			$('#id_name3').prop('checked',true).change();
		}

	});
	
	$('#id_name2').change(function() {
	
		if ($(this).is(':checked')) {
		
			$('#id_name4').prop('checked',true).change();
		}

	});

	$("input[type=radio].onOffRadio").change(function() {
		var _this$ = $(this);
		
		// テーブルの色替え
		Util.changeTabelStatus(_this$);
		
	});

	
	

//-----------------------------------------------------------------------------
// エラーで背景色変更
//-----------------------------------------------------------------------------
	  $("td[error]").css("background-color", "#FFC0CB");
	
});


