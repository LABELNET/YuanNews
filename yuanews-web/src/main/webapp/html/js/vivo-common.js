VIVO_UIMIX = {
	init : function(){
		var headBox=$("#vivo-head"),
		navBox=headBox.find(".vivo-nav"),
		searchBox=headBox.find(".vivo-search"),
		searchInput=searchBox.find("input"),
		searchBtn=navBox.find(".search-user a.search"),		
		closeSearchBtn=searchBox.find("a.close"),
		isSearchClose=true,
		isMenuEnter=isCommEnter=false;

		closeSearchBtn.css({opacity:0});
		searchBox.on({
			mouseenter : function(){
				closeSearchBtn.animate({opacity:1},300);
			},
			mouseleave : function(){
				closeSearchBtn.animate({opacity:0},300);
			}
		});

		searchBtn.on("click",function(){
			if(isSearchClose){
				searchBox.children().css({opacity:0});
				searchBox.css({display:"block",height:0}).stop().animate({height:80},300);
				searchBox.children().stop().delay(300).animate({opacity:1},500);
				searchInput.focus().val("");
				$(this).addClass("current");
				isSearchClose=false;
			}else{
				searchBox.stop().animate({height:0},300,function(){
					$(this).css({display:"none"});
					isSearchClose=true;
				});
				$(this).removeClass("current");
			}
			return false;
		});
		closeSearchBtn.on("click",function(){
			searchBtn.click();
			return false;
		});
		
	}
};

$(document).ready(function() {VIVO_UIMIX.init()});
