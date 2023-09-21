/**
 * 
 */
$(function(){
	let moreview = $("div > ul > li:nth-child(n+4)"); 
	
	$(".moreAteg").click(function(e){
		e.preventDefault();
		console.log("more click");

		// this.classList : 배열 형태의 class 속성을 가짐
		// => 배열이니깐 index 1번이 ${type.type}이 됨
		let type = this.classList[1];
		$("."+type).show();
		$(this).hide();
		$(".lessAteg."+type).show();
	});
	
	$(".lessAteg").click(function(e){
		e.preventDefault();
		console.log("less click");
		let type = this.classList[1];

		$("."+type).hide();
		$(this).hide();
		$(".moreAteg."+type).show();
	});
	
})