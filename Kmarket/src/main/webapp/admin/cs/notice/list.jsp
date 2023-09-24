<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/header.jsp" %>
<script>
	$(document).ready(function(){
		
		// 카테고리별 게시글 불러오기
		$('select[name=cate]').on('change', function(){
			
			const cate = this.value;
			const cateText = $("select[name=cate] option:selected").text();
			console.log(cate);
			console.log(cateText);
			
			$(".list tr:not(:first)").remove();
			
			const jsonData = {
				"cate": cate
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
					     str += '</td><td><a href="${path}/admin/cs/notice/view.do?cate='+cate+'&bno='+list[i].bno+'">' + list[i].title + '</a></td>';
					     /*str += '<td>조회수</td>';*/
					     str += '<td>'+list[i].rdate+'</td>';
					     str += '<td><a href="${path}/admin/cs/notice/delete.do?cate='+cate+'&bno='+list[i].bno+'">[삭제]<a><br><a href="${path}/admin/cs/notice/modify.do?cate='+cate+'&bno='+list[i].bno+'">[수정]</a></td>';
					     str += '</tr>';
					});
					$(".list").append(str);
				},
				error: function(){
					alert("error");
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
                <select name="cate">
				    <!-- <option value="" selected disabled>유형선택</option> -->
				    <option value="All">전체</option>
				    <option value="cs">고객서비스</option>
				    <option value="safe">안전거래</option>
				    <option value="dangerProd">위해상품</option>
				    <option value="event">이벤트 당첨</option>
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
					<td><a href="${path}/admin/cs/notice/view.do?no=${list.bno}">${list.title}</a></td>
					<td>${list.rdate}</td>
					<td>
						<a href="${path}/admin/cs/notice/delete.do?no=${list.bno}">[삭제]</a>
						<br>
						<a href="${path}/admin/cs/notice/modify.do?cate=${list.cate}&type=${type}&no=${list.bno}">[수정]</a>
					</td>
                </tr>
                </c:forEach>
            </table>
            
            <input type="button" value="선택삭제" />
                                  
			<div class="paging">
				<span class="prev"><a href="#" class="prev">이전</a></span>
				<span class="num"><a href="#"class="on">1</a></span>
				<span class="next"><a href="#" class="next">다음</a></span>
			</div>
			
			<input type="button" value="작성하기" onclick="location.href='${path}/admin/cs/notice/write.do'"/>
        </section>     
</section>
</main>
<%@ include file="../../inc/footer.jsp" %>