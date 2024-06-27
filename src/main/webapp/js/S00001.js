function getParam(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}


$(document).ready(function () {
const category = getParam('category');
console.log(category);
	 
	if(category === '2'){
		$('.top_tab .tab2 ').removeClass('tab2 ').addClass('tab2 selected');
		$('.top_tab .tab2 ').click(function(){
			return false;
		});
	}else if(category === '3'){
		$('.top_tab .tab3 ').removeClass('tab3 ').addClass('tab3 selected');
		$('.top_tab .tab3 ').click(function(){
			return false;
		});
	}else if(category === '4'){
		$('.top_tab .tab4 ').removeClass('tab4 ').addClass('tab4 selected');
		$('.top_tab .tab4 ').click(function(){
			return false;
		});
	}else{
		$('.top_tab .tab1 ').removeClass('tab1 ').addClass('tab1 selected');
		$('.top_tab .tab1 ').click(function(){
			return false;
		});
	}
});