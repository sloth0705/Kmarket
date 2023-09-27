<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-faq-list">
<script>
$(function(){
	const url = "/Kmarket/cs/Board/ajaxWrite.do"
	// /admin/cs/qna/list.do
	
	$("#cate").change(function(){
		let optionValue = $(this).val();
		let selectType = $("#type");
		
		const jsonData = {
			"optionValue" : optionValue
		};
		console.log(jsonData);
		
		// cate가 바뀔 때 마다 type을 빈값으로 초기화 해주고
		// 그 뒤 append를 통해서 option을 추가해줌
		selectType.empty();
		selectType.append(
			$('<option>',{
				value: '',
                text: '2차 분류 선택',
                disabled: 'disabled',
                selected: 'selected'
			})
		);
		
		if(optionValue !== '0'){
			$.getJSON(url, jsonData, function(data){
				console.log("cate가 0이 아닐 때 type option 추가");
				console.log(data);
				
				$.each(data, function (index, type) {
					selectType.append(
						$('<option>',{
							value: type.type,
			                text: type.typeName,
						})
					); // appnd end
                }); // each end
			}); // ajax end
		} // if end
	}); // cate change end
	
	$("#type").change(function() {
		
		const cate = $("#cate").val();
		const type = this.value;
		const cateText = $("select[name=cate] option:selected").text();
		const typeText = $("select[name=type] option:selected").text();
		$(".list tr:not(:first)").remove();
		
		const jsonData = {
			"cate": cate,
			"type": type
		};
		console.log(jsonData);
		
		$.ajax({
			url: '${path}/admin/cs/faq/list.do',
			type: 'post',
			data: jsonData,
			dataType: 'json',
			success: function(data){
				
				let list = data.map.list; // map 넘겨받기
				var str = '<tr>';
				
				$.each(list , function(i){
					 str += '<td><input type="checkbox" name="chk"/></td>';
				     str += '<td>' + list[i].bno + '</td><td>' + cateText + '</td><td>' + typeText;
				     str += '</td><td><a href="${path}/admin/cs/faq/view.do?bno='+list[i].bno+'">' + list[i].title + '</a></td>';
				     /*str += '<td>조회수</td>';*/
				     str += '<td>'+list[i].rdate+'</td>';
				     str += '<td><a href="${path}/admin/cs/faq/delete.do?bno='+list[i].bno+'">[삭제]<a>'
				     str += '<br><a href="${path}/admin/cs/faq/modify.do?cate='+cate+'&type='+list[i].type+'&bno='+list[i].bno+'">[수정]</a></td>';
				     str += '</tr>';
				});
				$(".list").append(str);
				
				// 페이징 처리
				$('.paging').children().remove();
				console.log(data.map.pageGroupEnd);
				
				var item = '';
				if(data.map.pageGroupStart > 1 ){
					item += '<span class="prev">';
					item += '<a href="${path}/admin/cs/faq/list.do?cate='+cate+'&pg='+(data.map.pageGroupStart -1)+'"><이전</a>';
			        item += '</span>'
				}
				for(var i=data.map.pageGroupStart; i<=data.map.pageGroupEnd; i++){
					item += '<span class="num">';
				    //item += '<a href="${path}/admin/cs/notice/list.do?cate='+cate+'&pg='+i+'" class='+ (data.map.currentPage==i?'on':'') +'">'+i+'</a>';
				    item += '<a href="${path}/admin/cs/faq/list.do?cate='+cate+'&pg='+i+'&cate=' + cate + '&type=' + type + '" class="'+ (data.map.currentPage==i?'on':'off') +'">'+i+'</a>';
				    item += '</span>';
				}
				if(data.map.pageGroupEnd < data.map.lastPageNum){
					item += '<span class="next">';
			        item += '<span class="next"><a href="${path}/admin/cs/faq/list.do?cate='+cate+'&pg='+(data.map.pageGroupEnd+1)+'">다음</a>';
			        item += '</span>'
				}
				
				$('.paging').append(item);
				console.log(item);
			}
		});
	});
	
	// 전체 체크박스
	$('input[name=all]').change(function(){
		const isChecked = $(this).is(':checked');
		if (isChecked) {
			$('input[name=chk]').prop('checked', true);
		} else {
			$('input[name=chk]').prop('checked', false);
		}
	});
    
	$('input[name=chk]').change(function() {
		const chk = $('input[name=chk]');
		let cnt = 0;
		for (let i = 0; i < chk.length; i++) {
			if (chk[i].checked) {
				cnt++;
			}
		}
		if (!$(this).is(':checked')) {
			$('input[name=all]').prop('checked', false);
		} else if (cnt == chk.length) {
			$('input[name=all]').prop('checked', true);
		}
	});
});
</script>
    <nav>
        <h3>자주묻는질문 목록</h3>
        <p>
            HOME > 고객센터 > <strong>자주묻는질문</strong>
        </p>
    </nav>
    <section>
            <div>
                <!-- cateName이랑 동일함 -->
                <select name="cate" id="cate">
				    <option value="" selected disabled>1차 선택</option>
				    <c:forEach var="cateOption" items="${cateOptions }">
				    	<option value="${cateOption.cate}">${cateOption.cateName}</option>
				    </c:forEach>
				</select>
				 <!-- cateName에 따라서 선택지가 달라짐 -->
                <select name="type" id="type">
					<option selected disabled value="0">2차 선택</option>
				</select>
            </div>
            <table class="list">
                <tr>
                    <th><input type="checkbox" name="all"/></th>
				    <th>번호</th>
				    <th>1차유형</th>
				    <th>2차유형</th>
				    <th>제목</th>
				    <th>날짜</th>
				    <th>관리</th>
                </tr>
                <c:forEach var="list" items="${listAll}">
	                <tr>
	                	<td><input type="checkbox" name="chk"/></td>
						<td>${list.bno}</td>
						<td>${list.cateName}</td>
						<td>${list.typeName}</td>
						<td><a href="${path}/admin/cs/notice/view.do?bno=${list.bno}">${list.title}</a></td>
						<td>${list.rdate}</td>
						<td>
							<a href="${path}/admin/cs/notice/delete.do?bno=${list.bno}">[삭제]</a>
							<br>
							<a href="${path}/admin/cs/notice/modify.do?cate=${list.cate}&type=${list.type}&bno=${list.bno}">[수정]</a>
						</td>
	                </tr>
                </c:forEach>
            </table>
            <input type="button" value="선택삭제" />
			<div class="paging">
				<c:if test="${pageGroupStart gt 1}">
				<span class="prev"><a href="${path}/admin/cs/faq/list.do?cate=${cate}&pg=${pageGroupStart-1}">이전</a></span>
				</c:if>
				
				<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
				<span class="num"><a href="${path}/admin/cs/faq/list.do?cate=${cate}&pg=${i}" class="${currentPage eq i ? 'on' : ''}">${i}</a></span>
				</c:forEach>
				
				<c:if test="${pageGroupEnd < lastPageNum}">
				<span class="next"><a href="${path}/admin/cs/faq/list.do?cate=${cate}&pg=${pageGroupEnd+1}">다음</a></span>
				</c:if>
			</div>
			<input type="button" value="작성하기" onclick="location.href='${path}/admin/cs/faq/write.do'"/>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>