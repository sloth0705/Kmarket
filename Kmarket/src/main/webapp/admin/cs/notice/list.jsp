<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<script>
	$(document).ready(function(){
		
		// 카테고리별 게시글 불러오기
		$('select[name=cate]').on('change', function(){
			
			const cate = this.value;
			const pg = $('input[name=pg]').val();
			console.log(pg);
			const cateText = $("select[name=cate] option:selected").text();
			console.log(cate);
			console.log(cateText);
			
			$(".list tr:not(:first)").remove();
			//$('.paging').children().remove();
			
			const jsonData = {
				"cate": cate,
				"pg": pg
			};
			console.log(jsonData);
			
			$.ajax({
				url: '${path}/admin/cs/notice/list.do',
				type: 'post',
				data: jsonData,
				dataType: 'json',
				success: function(data){
					
					let list = data.map.list; // map 넘겨받기
					var str = '<tr>';
					
					$.each(list , function(i){
						 str += '<td><input type="checkbox" name="chk"/></td>';
					     str += '<td>' + list[i].bno + '</td><td>' + cateText;
					     str += '</td><td><a href="${path}/admin/cs/notice/view.do?bno='+list[i].bno+'">' + list[i].title + '</a></td>';
					     /*str += '<td>조회수</td>';*/
					     str += '<td>'+list[i].rdate+'</td>';
					     str += '<td><a href="${path}/admin/cs/notice/delete.do?bno='+list[i].bno+'">[삭제]<a>'
					     str += '<br><a href="${path}/admin/cs/notice/modify.do?cate='+cate+'&type='+list[i].type+'&bno='+list[i].bno+'">[수정]</a></td>';
					     str += '</tr>';
					});
					$(".list").append(str);
					
					// 페이징 처리
					$('.paging').children().remove();
					console.log(data.map.pageGroupEnd);
					
					var item = '';
					if(data.map.pageGroupStart > 1 ){
						item += '<span class="prev">';
						item += '<a href="${path}/admin/cs/notice/list.do?cate='+cate+'&pg='+(data.map.pageGroupStart -1)+'"><이전</a>';
				        item += '</span>'
					}
					for(var i=data.map.pageGroupStart; i<=data.map.pageGroupEnd; i++){
						item += '<span class="num">';
					    item += '<a href="${path}/admin/cs/notice/list.do?cate='+cate+'&pg='+i+'" class='+ (data.map.currentPage==i?'on':'') +'">'+i+'</a>';
					    item += '</span>';
					}
					if(data.map.pageGroupEnd < data.map.lastPageNum){
						item += '<span class="next">';
				        item += '<span class="next"><a href="${path}/admin/cs/notice/list.do?cate='+cate+'&pg='+(data.map.pageGroupEnd+1)+'">다음</a>';
				        item += '</span>'
					}
					
					$('.paging').append(item);
					console.log(item);
				}
			});
		});
	});
</script>
<main>
<%@ include file="../../inc/aside.jsp" %>
<section id="admin-cs-notice-list">
    <nav>
        <h3>공지사항 목록</h3>
        <p>
            HOME > 고객센터 > <strong>공지사항</strong>
        </p>
    </nav>
	    <section>
	            <div>
	            	<input type="hidden" name="pg" id="pgNum" value="${pg}"/>
	                <select id="cate" name="cate">
					    <!-- <option value="" selected disabled>유형선택</option> -->
					    <option value="All"        <c:if test="${cate eq 'All'}">selected</c:if>>전체</option>
					    <option value="cs"         <c:if test="${cate eq 'cs'}">selected</c:if>>고객서비스</option>
					    <option value="safe"       <c:if test="${cate eq 'safe'}">selected</c:if>>안전거래</option>
					    <option value="dangerProd" <c:if test="${cate eq 'dangerProd'}">selected</c:if>>위해상품</option>
					    <option value="event"      <c:if test="${cate eq 'event'}">selected</c:if>>이벤트 당첨</option>
					</select>
	            </div>
	            <table class="list">
	                <tr>
	                    <th><input type="checkbox" name="all"/></th>
					    <th>번호</th>
					    <th>유형</th>
					    <th>제목</th>
					    <th>날짜</th>
					    <th>관리</th>
	                </tr>
	                <c:forEach var="list" items="${listAll}">
	                <tr>
	                	<td><input type="checkbox" name="chk"/></td>
						<td>${list.bno}</td>
						<td>${list.cateName}</td>
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
	            
				<!-- 상품목록 페이지번호 -->
				<div class="paging">
					<c:if test="${pageGroupStart gt 1}">
					<span class="prev"><a href="${path}/admin/cs/notice/list.do?cate=${cate}&pg=${pageGroupStart-1}">이전</a></span>
					</c:if>
					
					<c:forEach var="i" begin="${pageGroupStart}" end="${pageGroupEnd}">
					<span class="num"><a href="${path}/admin/cs/notice/list.do?cate=${cate}&pg=${i}" class="${currentPage eq i ? 'on' : ''}">${i}</a></span>
					</c:forEach>
					
					<c:if test="${pageGroupEnd < lastPageNum}">
					<span class="next"><a href="${path}/admin/cs/notice/list.do?cate=${cate}&pg=${pageGroupEnd+1}">다음</a></span>
					</c:if>
				</div>
				
				<input type="button" value="작성하기" onclick="location.href='${path}/admin/cs/notice/write.do'"/>
	        </section>
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>