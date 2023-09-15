/**
 * 
 */
$(function(){
	const url = "/Kmarket/cs/qnaBoard/write.do"
	
	$.get(url, function(data){
		console.log("write로 날라가라");
		console.log(data);
		
		let cate = $("#cate");
		cate.append("<option value='0'>선택</option>");
		$.each(data, function(index, cateName){
			cate.append("<option value='" + cateName + "'>" + cateName + "</option>")
		});
	});
	
	
	$("#cate").change(function(){
		let selectCate = $(this).val();
		let type = $("#type");
		
		// cate가 바뀔 때 마다 type을 빈값으로 초기화 해주고
		// 그 뒤 append를 통해서 option을 추가해줌
		type.empty();
		type.append("<option value='0'>선택</option>");
		
		if(selectCate !== '0'){
			$.get(url+"?group=qna&cate="+selectCate, function(data){
				console.log("cate가 0이 아닐 때 type option 추가");
				console.log(data);
				
				$.each(data, function (index, typeName) {
                    typeSelect.append("<option value='" + typeName+ "'>" + typeName + "</option>");
                });
			})
		}
	});
});